package com.stone.dagger.demo.parameter;

import dagger.Module;
import dagger.Provides;

@Module
class MainModule {

    @Provides
    public Cloth getCloth() {
        Cloth cloth = new Cloth();
        cloth.setColor("蓝色");
        return cloth;
    }

    @Provides
    Clothes getClothes(Cloth cloth) {
        return new Clothes(cloth);
    }
}