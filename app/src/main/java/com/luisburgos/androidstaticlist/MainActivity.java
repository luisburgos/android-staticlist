package com.luisburgos.androidstaticlist;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.luisburgos.staticlist.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    private Fragment mainContainerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainContainerFragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (mainContainerFragment == null) {
            mainContainerFragment = MyContainerFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), mainContainerFragment, R.id.container
            );
        }
    }
}
