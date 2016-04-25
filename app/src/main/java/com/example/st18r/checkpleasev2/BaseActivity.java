package com.example.st18r.checkpleasev2;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by st18r on 14.04.2016.
 */
public class BaseActivity extends AppCompatActivity {
    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_AUTO);
    }
}
