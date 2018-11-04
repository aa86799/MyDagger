package com.stone.dagger.demo.parameter;

import dagger.Component;

@Component(modules = MainModule.class)
interface MainComponent {
    void inject(MainActivity mainActivity);
}