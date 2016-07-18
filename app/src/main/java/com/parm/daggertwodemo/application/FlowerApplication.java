package com.parm.daggertwodemo.application;

import android.app.Application;

import com.parm.daggertwodemo.dependencies.ApiComponent;
import com.parm.daggertwodemo.dependencies.DaggerApiComponent;
import com.parm.daggertwodemo.dependencies.DaggerNetworkComponent;
import com.parm.daggertwodemo.dependencies.NetworkComponent;
import com.parm.daggertwodemo.dependencies.NetworkModule;
import com.parm.daggertwodemo.model.Constant;

/**
 * Created by pchangul on 7/18/2016.
 */
public class FlowerApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
         mApiComponent = DaggerApiComponent.builder()
                 .networkComponent(getNetworkComponent())
                 .build();

    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constant.BASE_URL))
                .build();


    }

    public ApiComponent getmApiComponent() {
        return mApiComponent;
    }
}
