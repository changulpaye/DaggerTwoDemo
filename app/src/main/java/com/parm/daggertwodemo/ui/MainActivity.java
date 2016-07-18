package com.parm.daggertwodemo.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.parm.daggertwodemo.R;
import com.parm.daggertwodemo.application.FlowerApplication;
import com.parm.daggertwodemo.base.FlowerPresenter;
import com.parm.daggertwodemo.model.FlowerAdapter;
import com.parm.daggertwodemo.model.FlowerResponse;
import com.parm.daggertwodemo.service.FlowerService;
import com.parm.daggertwodemo.service.FlowerViewInterface;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements FlowerViewInterface {

    @Inject FlowerService mFlowerService;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    private FlowerPresenter mPresenter;
    private FlowerAdapter mAdapter;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);
        resolveDependency();

        configView();
        mPresenter = new FlowerPresenter(MainActivity.this);
        mPresenter.onCreate();
        
    }


    private void resolveDependency() {
        ((FlowerApplication)getApplication())
                .getmApiComponent()
                .inject(MainActivity.this);
    }
    private void configView() {
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new FlowerAdapter(getLayoutInflater());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
        mPresenter.fetchFlowers();
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setTitle("Downloading");
        mProgressDialog.setMessage("Please wait.");
        mProgressDialog.show();
    }

    @Override
    public void onCompleted() {
        mProgressDialog.dismiss();
    }

    @Override
    public void onError(String message) {
        mProgressDialog.dismiss();
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFlowers(List<FlowerResponse> flowerResponses) {
            mAdapter.addFlowers(flowerResponses);
    }

    @Override
    public Observable<List<FlowerResponse>> getFlowers() {
        return mFlowerService.getFlowers() ;
    }
}
