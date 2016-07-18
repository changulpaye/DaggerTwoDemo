package com.parm.daggertwodemo.base;

import com.parm.daggertwodemo.model.FlowerResponse;
import com.parm.daggertwodemo.service.FlowerViewInterface;

import java.util.List;

import rx.Observer;

/**
 * Created by PARAM on 7/18/2016.
 *
 */
public class FlowerPresenter extends BasePresenter implements Observer<List<FlowerResponse>>  {
    private FlowerViewInterface mFlowerViewInterface;

    public FlowerPresenter(FlowerViewInterface flowerViewInterface) {
        this.mFlowerViewInterface = flowerViewInterface;
    }

    @Override
    public void onCompleted() {
        mFlowerViewInterface.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        mFlowerViewInterface.onError(e.getMessage());
    }

    @Override
    public void onNext(List<FlowerResponse> flowerResponses) {
        mFlowerViewInterface.onFlowers(flowerResponses);
    }

    public void fetchFlowers() {
        unSubscribeAll();
        subscribe(mFlowerViewInterface.getFlowers(), FlowerPresenter.this);
    }
}
