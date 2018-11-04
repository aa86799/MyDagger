package com.stone.dagger.demo.inject;

import dagger.Component;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 22/02/2017 19 17
 */
@Component
interface MainComponent {
    void inject(MainActivity activity);
}
