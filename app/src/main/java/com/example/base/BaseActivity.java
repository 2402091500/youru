package com.example.base;

import android.app.Activity;
import android.os.Bundle;

import com.example.youlu.R;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
