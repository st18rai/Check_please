package com.example.st18r.checkpleasev2;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends BaseActivity {

    private TextView mVersionTv;
    private TextView mAboutApp;
    private String mVersionName = BuildConfig.VERSION_NAME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mVersionTv = (TextView) findViewById(R.id.version_tv);
        mAboutApp = (TextView) findViewById(R.id.about_app);

        mVersionTv.setText(getResources().getString(R.string.about) + " " + mVersionName);

        Animation anim = null;
        anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
        mAboutApp.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
        mVersionTv.startAnimation(anim);


    }

    public void onPlayStoreClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://search?q=pub:Aleksey+Rudenko"));
        try {
            startActivity(intent);
        }
        catch (ActivityNotFoundException e)
        {
            Toast.makeText(this, " Sorry, Not able to open!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onMailClick(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL  , new String[] { "rudenko.al.iv@gmail.com" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "About app");

        startActivity(Intent.createChooser(intent, "Email via..."));
    }

    public void onRateClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.st18apps.st18r.checkplease"));
        try {
            startActivity(intent);
        }
        catch (ActivityNotFoundException e)
        {
            Toast.makeText(this, " Sorry, Not able to open!", Toast.LENGTH_SHORT).show();
        }
    }
}
