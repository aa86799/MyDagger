package com.stone.dagger.demo.dependencies;

import android.app.Activity;
import android.os.Bundle;


import javax.inject.Inject;

/**
 * desc   : 使用@Inject-bean它的构造方法；
 *      使用了@Component 注解的接口，关联应用注入的类型
 *      使用@Module和@Provides 来产生 对象实例
 *      使用@Component(dependencies=..) 来依赖其它 Component
 *          主Component在创建时，需要手动设置其依赖的Component
 *          本例中，使用Config来创建；如有必要可以将Config单例化
 *      一个Component可以被多处依赖
 * author : stone
 * email  : aa86799@163.com
 * time   : 20/02/2017 09 39
 */
public class MainActivity extends Activity {

    @Inject
    Employee mEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        MainComponent t = DaggerMainComponent.create();
        MainComponent t = DaggerMainComponent.builder()
                .emComponent(Config.getEmComponent())
                .build();
        t.inject(this);

    }
}
