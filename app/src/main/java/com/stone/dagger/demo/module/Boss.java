package com.stone.dagger.demo.module;

import javax.inject.Inject;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 22/02/2017 19 06
 */
class Boss {
    /*
     * 本示例中，本类的构造方法不需要使用 @Inject
     * 是由 Module 中，@Provides 注解的方法来提供对象；
     * 且会生成 该方法相对应的 Factory 类
     */

    private String name;

//    @Inject //只能有一个 @Inject 的构造方法， 不能多个同时注解
    public Boss() {

    }

//    @Inject
    public Boss(String name) {
        System.out.println("new 了一个 boss " + name);
    }

}
