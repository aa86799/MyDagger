package com.stone.dagger.demo.scope;

import javax.inject.Inject;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 22/02/2017 19 06
 */
class Boss {

    private String name;

//    @Inject //只有有一个 @Inject 的构造方法， 不能多个同时注解
    public Boss() {

    }

//    @Inject
    public Boss(String name) {
        System.out.println("new 了一个 boss " + name);
    }

}
