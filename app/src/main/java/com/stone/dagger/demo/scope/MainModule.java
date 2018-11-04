package com.stone.dagger.demo.scope;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 22/02/2017 19 38
 */
@Module
class MainModule {
    @ActivityScope  //与直接应用 @Singleton效果一样
//    @Singleton
    @Provides
    public Boss getMyBoss() {
        return new Boss("什么11鬼");
    }

    @ActivityScope
    @Named("大鬼")
    @Provides
    public Boss getMyBoss2() {
        return new Boss("大鬼");
    }

    @Provides
    public GlobalSetting getSetting() {
        return new GlobalSetting();
    }
}
