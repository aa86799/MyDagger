package com.stone.dagger.demo.scope;

import dagger.Component;
import dagger.Module;

/**
 * desc     :
 * author   : stone
 * homepage : http://stone86.top
 * email    : aa86799@163.com
 * time     : 2018/11/4 11 04
 */
@ApplicationScope
@Component(modules = MainModule.class)
public interface GlobalComponent {

    void injectGlobalSetting(ScopeApplication application);
}
