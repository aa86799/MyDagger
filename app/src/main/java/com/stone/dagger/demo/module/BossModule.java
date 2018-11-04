package com.stone.dagger.demo.module;

import dagger.Module;
import dagger.Provides;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 22/02/2017 19 38
 */
@Module
class BossModule {

    @Provides
    public Boss getMyBoss() {
        return new Boss("什么11鬼");
    }
}
