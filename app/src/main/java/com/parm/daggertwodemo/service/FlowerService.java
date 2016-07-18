package com.parm.daggertwodemo.service;


import com.parm.daggertwodemo.model.FlowerResponse;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by pchangul on 7/18/2016.
 */
public interface FlowerService {

    /**
     * TODO Write info about method
     * @return
     */
    @GET("/feeds/flowers.json")
    Observable<List<FlowerResponse>> getFlowers();
}
