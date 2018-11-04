package com.stone.dagger.demo.module;

import dagger.Component;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 22/02/2017 19 17
 */
//@Component(modules = MainModule.class)  //modules值指示 关联的模块(module)     一个module
@Component(modules = {BossModule.class, EmModule.class})  //多个module

interface MainComponent {
    void inject(MainActivity activity);
}
