package com.stone.dagger.demo.named;

import javax.inject.Inject;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 22/02/2017 20 58
 */
class Employee {

//    @Inject
    public Employee(String name) {
        System.out.println("new 了一个 Employee : " + name);
    }
}
