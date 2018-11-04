package com.stone.dagger.demo.named;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * desc   : 使用@Inject-bean它的构造方法；
 *      使用了@Component 注解的接口，关联应用注入的类型
 *      使用@Module和@Provides 来产生 对象实例
 *      使用@Named来标识同一个类型的不同对象
 * author : stone
 * email  : aa86799@163.com
 * time   : 20/02/2017 09 39
 */
public class MainActivity extends Activity {

    @Inject
    @Named("zhangsan")
    Employee mEmZ;

    @Inject
    @Named("lisi")
    Employee mEmL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        MainComponent t = DaggerMainComponent.create();
        MainComponent t = DaggerMainComponent.builder()
//                .mainModule(new MainModule()) //会自动注入
                .build();
        t.inject(this);

    }
}
