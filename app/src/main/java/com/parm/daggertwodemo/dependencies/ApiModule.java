package com.parm.daggertwodemo.dependencies;

import com.parm.daggertwodemo.service.FlowerService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by pchangul on 7/18/2016.
 */

@Module
public class ApiModule {

    /**
     * Retrofit is a dependency.
     * @param retrofit
     * @return
     */
    @Provides
    @CustomScope
    FlowerService provideFlowerService(Retrofit retrofit) {
        return retrofit.create(FlowerService.class);
    }
}
