package com.example.jalen.mydemoforzhihu;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Jalen on 2015/7/21.
 */
public class BaseActivity extends ActionBarActivity{


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Fresco.initialize(this);

    }
}
