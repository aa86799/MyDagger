package com.stone.dagger.demo.named;

import javax.inject.Named;

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

    @Provides()
    @Named("zhangsan")
    public Employee getEmZhangsan() {
        return new Employee("张三");
    }

    @Provides()
    @Named("lisi")
    public Employee getEmLisi() {
        return new Employee("李四");
    }
}
