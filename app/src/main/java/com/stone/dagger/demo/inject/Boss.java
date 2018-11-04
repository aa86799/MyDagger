package com.stone.dagger.demo.inject;

import javax.inject.Inject;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 22/02/2017 19 06
 */
class Boss {

    private String name;

    @Inject
    public Boss() {
        System.out.println("new 了一个 匿名的 boss");
    }

//    @Inject //error
//    public Boss(String name) {
//        this.name = name;
//        System.out.println("new 了一个 boss: " + name);
//    }

}
