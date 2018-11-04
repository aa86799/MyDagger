package com.stone.dagger.demo.dependencies;

import dagger.Component;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 23/02/2017 10 32
 */
@Component(modules = EmModule.class)
interface EmComponent {
    Employee getEm2(); //可以和Module中的 方法名不同，但类型需要一致; 实际调用的就是 EmModule的对应返回类型的相关方法
}
