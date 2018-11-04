package com.stone.dagger.demo.dependencies;

import dagger.Component;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 22/02/2017 19 17
 */
@Component(dependencies = EmComponent.class)
interface MainComponent {
    void inject(MainActivity activity);
}
