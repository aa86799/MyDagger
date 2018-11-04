package com.stone.dagger.demo.subcomponent;

import dagger.Module;
import dagger.Provides;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 23/02/2017 18 23
 */
@Module
class EmModule {

    @Provides
    Employee getEmployee() {
        return new Employee();
    }
}
