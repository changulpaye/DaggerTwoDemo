package com.parm.daggertwodemo.dependencies;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by pchangul on 7/18/2016.
 */

@Singleton
@Component(modules = NetworkModule.class)
public interface NetworkComponent  {

    Retrofit retrofit(); // this method will access in ApiComponent (Exposed)
}
