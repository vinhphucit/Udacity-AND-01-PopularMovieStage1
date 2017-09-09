package com.phuctran.popularmoviesfirststage;

import android.app.Application;
import android.content.Context;

/**
 * Created by phuctran on 9/9/17.
 */

public class MovieApplication extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    public static Context getContext() {
        return sContext;
    }
}
