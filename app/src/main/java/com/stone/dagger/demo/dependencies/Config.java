package com.stone.dagger.demo.dependencies;


/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 23/02/2017 10 49
 */
class Config {
    private static EmComponent mEmComponent;

    public static EmComponent getEmComponent() {
        if (mEmComponent == null) {
            mEmComponent = DaggerEmComponent.builder()
//                    .emModule(new EmModule())  //这一步 dagger会自动注入
                    .build();
        }
        return mEmComponent;
    }
}
