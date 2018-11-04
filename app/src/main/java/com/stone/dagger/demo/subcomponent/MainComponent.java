package com.stone.dagger.demo.subcomponent;

import dagger.Subcomponent;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 22/02/2017 19 17
 */
@Subcomponent(modules = EmModule.class)
interface MainComponent  {

    Employee getEmployee();

    void inject(MainActivity activity);
}
