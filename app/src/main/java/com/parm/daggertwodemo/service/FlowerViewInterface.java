package com.parm.daggertwodemo.service;

import com.parm.daggertwodemo.model.FlowerResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by PARAM on 7/18/2016.
 */
public interface FlowerViewInterface {
    void onCompleted();

    void onError(String message);

    void onFlowers(List<FlowerResponse> flowerResponses);

    Observable<List<FlowerResponse>> getFlowers();
}
