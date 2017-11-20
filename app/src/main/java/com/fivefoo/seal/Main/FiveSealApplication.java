package com.fivefoo.seal.Main;

import android.app.Application;

/**
 * Created by 67423 on 2017/11/16.
 */

public class FiveSealApplication extends Application {

    static final String TAG = FiveSealApplication.class.getSimpleName();

    private static FiveSealApplication getInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        getInstance = this;

    }


    public static FiveSealApplication getInstance(){
        return getInstance;
    }

}
