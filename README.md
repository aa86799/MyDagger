[TOC]



# Dagger2

Dagger2是Android中比较热门的依赖注入框架。一个类中需要依赖其他对象时，不需要你亲自为那些需要依赖的对象赋值,为那些对象赋值的操作交给了控制反转框架。



# 基本描述

component 提供实例，即可被注入的实例，由指定的module来获取实例； 还要提供一个关联目标类的 inject(destClass) 方法  
module 真正提供实例的地方。由@Provides 来注解定义。可被视为实例提供者的方法标(需要注入实例的)类。  类中会调用DaggerX..Component对象的index(this); 

> @Provides 提供的依赖如果没有提供给子类，只注入一个对象实例，建议直接new一个对象出来，将其它已生成的依赖传入。
> 如果直接将依赖对象当做参数传进来，会生成对应的工厂方法，增加程序运行成本。



# 简单的流程

从component 接口中，查找对象的返回方法；对象返回的具体实现，从定义的modules中查找；
modules中，@Provides 注解的方法，返回相应的对象；没有 modules 时，而使用@inject 注解了需要注入类的构造方法，也可以。



# 实例注入时 @Inject用法

(下面一段话来自：http://blog.csdn.net/handsome_926/article/details/50195165)
Dagger需要注入依赖的地方，需要@Inject的注解，共有三种inject方式：Identifies injectable constructors, methods, and fields.  
constructors首先被注入，然后是method和field，父类中的method和field会先于子类中的method和field注入，同一个类中的fields和methods注入不分先后。 
当类中含有@Inject注解的成员变量， 却没有@Inject注解的构造函数时， Dagger将使用类的默认构造函数。若类中缺少@Inject注解， 该类是不能由Dagger创建的。 

1、Constructors 
在构造方法添加@Inject注解，指明Constructor的参数需要dependency，这些参数可以被使用在private或final字段。 
需要指出的是一个类只能有一个构造方法可以被inject，否则会报：Error: Types may only contain one @Inject constructor. 

2、Methods 注入参数对象
在成员方法添加@Inject注解，成员方法不可以是抽象的，指明方法参数需要依赖。一般会这样用：@inject void test(Boss boss)；其中Boss的构造函数是@Inject的

3、Fields
在成员变量上加@Inject，不可以是private或者是final字段。



# Demo Package Info

## package inject

- 仅使用@Inject 加 @Component 来完成对一个对象(必须是无参构造方法，且只能注解它一个)的注入。会生成一个Xxx_Factory类。这是一个单例工厂类，用于创建新的被注解实例。

- 对于@Component注解的接口，内部的抽象方法所依赖的类，会在该类中以@Inject 声明要注入的成员对象。

  在编译时，会自动生成一个Dagger开头的Component类。

  同一被依赖类中，以@Inject 注解的所有成员，会生成一个名为 [被依赖类名_MembersInjector]的类。

- 示例中，生成的三个类为：Boss_Factory、MainActivity_MembersInjector、DaggerMainComponent。

  Boss_Factory：单例工厂，创建 @Inject 注解的 Boss 类的对象。

  MainActivity_MembersInjector：生成多个被@Inject 注解的对象。在injectMembers()中赋值。

  DaggerMainComponent：由内部 Builder 类构建外部DaggerMainComponent实例，并对成员MainActivity_MembersInjector对象赋值：

  ```java
  this.mainActivityMembersInjector = MainActivity_MembersInjector.create(Boss_Factory.create());
  ```

- @Component 注解的类中声明的 抽象方法，在DaggerMainComponent中进行了实现，调用了

  ```java
  mainActivityMembersInjector.injectMembers(activity);
  ```


## package module

使用@Module 和 @Provides 来提供具体注入的对象，   @Component(modules=...) 来关联 Module，展示了注入一个或多个对象的示例。

- 生成的类与相关代码及作用，与 【package inject】中相似。仅以下几点不一样

- BossModule 类使用了@Module 注解。内部方法使用@Provides 注解，用于创建对象，调用的是 Boss 类的有参构造方法(该方法应用@Inject)。

  生成BossModule_GetMyBossFactory类(_[@Provides 注解的方法名+Factory])；类中依赖 module，并创建一个返回 Boss 对象的方法，方法内调用的是 module 的@Provides 注解的方法。

- 在生成的DaggerMainComponent 中，内部 Builder 类，增加了 应用@Module注解的类成员，并赋值。创建Provider<Boss>对象时，会调用

  ```java
  this.getMyBossProvider = BossModule_GetMyBossFactory.create(builder.bossModule);
  ```

  之后，与之前一样：

  ```java
  this.mainActivityMembersInjector =
          MainActivity_MembersInjector.create(getMyBossProvider, getEmployeeProvider);
  ```



## package parameter

  一个对象A依赖另一个对象B而构造时，在Module中也需要提供B对象的获取方法。即要以@Provides注解。  

- Clothes 依赖于 Cloth 类进行构造。

- MainMoudle 对Clothes、Cloth定义了获取对象的对象方法，以@Provides 进行注解。

  生成了类 MainModule_GetClothesFactory、MainModule_GetClothFactory。功能与之前分析的类似。

  (省略其它相似分析...)


## package named

  使用@Named来标识同一个类型的不同对象。

-  在MainModule中 @Provides 注解的方法上再添加一个@Named("标识字符串")，来区分标识返回相同类型的对象的不同方法。

- 在 Component依赖的类，即 MainActivity 中，以@Inject 注解的成员上，也加上@Named("") 注解；内部标识字符串与 Moudle 中定义的相匹配

- 同样对 Moudle 中定义的应用了@Provides 的方法，会生成相应的 Factory 类。本例生成了MainModule_GetEmLisiFactory、MainModule_GetEmZhangsanFactory

  (省略其它相似分析...)



## package scope  
使用@Scope 在Component和@Provides上， 而使注入对象在Component生命周期中，保持***局部单例*** 效果；再次注入，则会生成新的对象。
在实际开发中，可能需要有些对象在整个APP中保持单例  如可定义一个@ApplicationScope，在application或某个全局单例配置类中注入(即要注入的成员属性的声明在这些类中)。  
有些在同一个用户下保持单例    如可定义一个@UserScope，在application或某个全局单例配置类，以User为比对条件，User不同时，重新注入  
有些在同一个Activity下保持单例， 比如示例中的@ActivityScope。  
还有一个单例的注解是javax.inject.Singleton   @Singleton的定义上就使用了@Scope

- 定义一个应用了@Scope 的注解：(类似与直接使用 @Single)

  ```java
  @Scope
  @Target({ElementType.METHOD, ElementType.TYPE})
  @Retention(RUNTIME)
  @interface ActivityScope {
  }
  ```

- Moudle 应用了@Provides 注解的方法上，再使用@ActivityScope，即表示返回对象是一个局部单例。是谁的局部呢？示例中，在Component中应用了@ActivityScope，即是 Component 的局部单例，即保持与 Component 的生命周期一致。


## package dependencies  
  使用@Component(dependencies=..) 来依赖其它 Component  
  主Component在创建时，需要手动设置其依赖的Component。  本例中，使用Config来创建，如有必要可以将Config单例化  
  一个Component可以被多处依赖  

## package subcomponent
  使用@Subcomponent的Component接口，逻辑上，它就是子；被父Component接口使用；  
  父中，必须定义返回子的方法；子中可以指定自己的module，并定义相关的获取对象方法；  
  子继承了父中所有的module; 调用时，先初始化父，再获取子;    
  通过Subcomponent，子Component就好像同时拥有两种Scope(来自父和子各自的Scope)，  
  当注入的元素来自父Component的Module，则这些元素会缓存在父Component，  
  当注入的元素来自子Component的Module，则这些元素会缓存在子Component中。

- ParentComponent使用@Component 注解。MainComponent使用@SubComponent 注解。

  仅生成了DaggerParentComponent类。且对MainComponent生成了MainComponentImpl的静态内部类。

## package coffee

这是官方的示例。

类结构：

CoffeeApp
CoffeeMaker
DripCoffeeModule
ElectricHeater
Heater
Pump
PumpModule
Thermosiphon





  