package com.stone.dagger.demo.scope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 22/02/2017 19 17
 */
@ActivityScope  //与直接应用 @Singleton效果一样
//@Singleton
@Component(modules = MainModule.class)  //modules值指示 关联的模块(module)     一个module
interface MainComponent {

    void inject(MainActivity activity);
}
