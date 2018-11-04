package com.stone.dagger.demo.module;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

/**
 * desc   : 使用@Inject-bean它的构造方法；
 *      使用了@Component 注解的接口，注入方法关联应用注入的使用类型
 *      使用@Module和@Provides 来产生 对象实例
 * author : stone
 * email  : aa86799@163.com
 * time   : 20/02/2017 09 39
 */
public class MainActivity extends Activity {

    @Inject
    Boss mBoss;
    @Inject
    Employee mEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        MainComponent t = DaggerMainComponent.create();
        MainComponent t = DaggerMainComponent.builder().build();
        t.inject(this);
    }
}
