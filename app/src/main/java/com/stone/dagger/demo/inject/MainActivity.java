package com.stone.dagger.demo.inject;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;


/**
 * desc   : 仅使用@Inject 注解bean的无参构造方法；
 *      使用了@Component 注解的接口，注入方法关联应用注入的使用类型
 * author : stone
 * email  : aa86799@163.com
 * time   : 20/02/2017 09 39
 */
public class MainActivity extends Activity {

    @Inject
    Boss mBoss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        编译时生成 DaggerMainComponent
         */
        MainComponent t = DaggerMainComponent.create();
//        MainComponent t = DaggerMainComponent.builder().build();
        t.inject(this);

    }
}
