package com.stone.dagger.demo.parameter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

/**
 * 一个对象A依赖另一个对象B时，在Module中也提供B对象的获取方法。即要以@Provides
 */
public class MainActivity extends Activity {
    @Inject
    Clothes clothes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainComponent mainComponent = DaggerMainComponent
                .builder()
//                .mainModule(new MainModule())
                .build();
        mainComponent.inject(this);

        Log.d("gxd", clothes.toString());
    }
}
