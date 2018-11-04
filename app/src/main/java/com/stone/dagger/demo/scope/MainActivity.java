package com.stone.dagger.demo.scope;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * desc   : 使用@Inject-bean它的构造方法；
 *      使用了@Component 注解的接口，注入方法关联应用注入的使用类型
 *      使用@Module和@Provides 来产生 对象实例
 *      使用@Scope 在Component和@Provides上， 而使注入对象在Component生命周期中，保持局部单例效果
 * author : stone
 * email  : aa86799@163.com
 * time   : 20/02/2017 09 39
 */
public class MainActivity extends Activity {

    @Inject
    Boss mBoss;

    @Inject
    Boss mBoss2;

    @Inject
    @Named("大鬼")
    Boss mBoss3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        MainComponent t = DaggerMainComponent.create();
        MainComponent t = DaggerMainComponent.builder().build();
        t.inject(this);
        /*
        MainComponent 对象使用完毕后，就可以被gc处理了。(什么时候回收，由gc决定)
         */
        System.out.println("mBoss == mBoss2 :" + (mBoss == mBoss2)); //会输出true
        System.out.println("mBoss2 == mBoss3 :" + (mBoss2 == mBoss3)); //会输出 false


        Boss temp = mBoss;
        /*
        再次注入，则会生成 新的对象
         */
        t = DaggerMainComponent.builder()/*.mainModule(new MainModule())*/.build();
        t.inject(this);
        System.out.println(mBoss == temp);//会输出false

//        System.out.println();
    }
}
