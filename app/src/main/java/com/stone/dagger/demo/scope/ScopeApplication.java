package com.stone.dagger.demo.scope;

import android.app.Application;

import javax.inject.Inject;

/**
 * desc     :
 * author   : stone
 * homepage : http://stone86.top
 * email    : aa86799@163.com
 * time     : 2018/11/4 10 08
 */
public class ScopeApplication extends Application {

    @Inject
    GlobalSetting mGlobalSetting;

    @Override
    public void onCreate() {
        super.onCreate();
        GlobalComponent component = DaggerGlobalComponent.builder().build();
        component.injectGlobalSetting(this);
    }


}
