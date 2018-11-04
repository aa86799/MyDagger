package com.stone.dagger.demo.dependencies;

import dagger.Module;
import dagger.Provides;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 23/02/2017 10 32
 */
@Module
class EmModule {
    @Provides
    Employee getEm() {
        return new Employee();
    }
}
