package com.stone.dagger.demo.subcomponent;

import dagger.Component;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 23/02/2017 17 50
 */
@Component(modules = MainModule.class)
interface ParentComponent {
    Boss getBoss();

    MainComponent getMainComponent(); //显示添加获取子Component的方法
}
