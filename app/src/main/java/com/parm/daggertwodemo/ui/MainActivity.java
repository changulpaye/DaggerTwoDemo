package com.parm.daggertwodemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parm.daggertwodemo.R;
import com.parm.daggertwodemo.application.FlowerApplication;
import com.parm.daggertwodemo.service.FlowerService;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject FlowerService flowerService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((FlowerApplication)getApplication())
                .getmApiComponent()
                .inject(MainActivity.this);
    }
}
