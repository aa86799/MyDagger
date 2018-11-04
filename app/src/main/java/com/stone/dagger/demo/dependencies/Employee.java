package com.stone.dagger.demo.dependencies;

import javax.inject.Inject;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 22/02/2017 20 58
 */
class Employee {

    @Inject
    public Employee() {
        System.out.println("dependencies new 了一个 匿名的 Employee");
    }
}
