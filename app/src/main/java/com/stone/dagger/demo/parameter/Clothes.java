package com.stone.dagger.demo.parameter;

import javax.inject.Inject;

/**
 * 衣服
 */
class Clothes {
    private Cloth cloth;

//    @Inject
    Clothes(Cloth cloth) {
        this.cloth = cloth;
    }

    public Cloth getCloth() {
        return cloth;
    }

    @Override
    public String toString() {
        return cloth.toString() + "衣服";
    }

}