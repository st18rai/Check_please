package com.example.st18r.checkpleasev2;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends BaseActivity {

    private TextView version_tv;
    private TextView about_app;
    private String version_name = BuildConfig.VERSION_NAME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        version_tv = (TextView) findViewById(R.id.version_tv);
        about_app = (TextView) findViewById(R.id.about_app);

        version_tv.setText(getResources().getString(R.string.about) + " " + version_name);

        Animation anim = null;
        anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
        about_app.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
        version_tv.startAnimation(anim);


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
