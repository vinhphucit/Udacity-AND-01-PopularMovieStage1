package com.phuctran.popularmoviesfirststage.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by phuctran on 9/9/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        ButterKnife.bind(this);
        updateFollowingViewBinding(savedInstanceState);

    }

    protected abstract void updateFollowingViewBinding(Bundle savedInstanceState);

    protected abstract int getLayoutResource();
}
