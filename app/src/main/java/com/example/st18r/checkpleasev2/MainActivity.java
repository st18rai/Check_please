package com.example.st18r.checkpleasev2;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends BaseActivity {

    private EditText mEditSum;
    private EditText mEditPeople;
    private TextView mTextResult;
    private CheckBox mCheckbox;
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mEditSum.setText(null);
                mEditPeople.setText(null);
                mTextResult.setText(null);
                mCheckbox.setChecked(false);
                mSpinner.setSelection(0);

                Snackbar.make(view, R.string.text_sb, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        mEditSum = (EditText) findViewById(R.id.editSumm);
        mEditPeople = (EditText) findViewById(R.id.editPeople);
        mTextResult = (TextView) findViewById(R.id.tvResult);
        mCheckbox = (CheckBox) findViewById(R.id.checkBox);
        mSpinner = (Spinner) findViewById(R.id.spinner);

        Animation anim = null;
        anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
        mTextResult.startAnimation(anim);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Intent intent = new Intent(MainActivity.this,AboutActivity.class);
        startActivity(intent);

        //noinspection SimplifiableIfStatement
        if (id == R.id.about_app) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick(View view) {

        if (TextUtils.isEmpty(mEditSum.getText().toString())
                || TextUtils.isEmpty(mEditPeople.getText().toString())) {
            Toast toast = Toast.makeText(this, R.string.toast, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 20);
            toast.show();
            return;
        }

        double inputSum = Double.parseDouble(mEditSum.getText().toString());
        double inputPeople = Double.parseDouble(mEditPeople.getText().toString());

        if (mCheckbox.isChecked()){
            int tips = Integer.valueOf(mSpinner.getSelectedItem().toString());
            double result = inputSum / inputPeople;
            double resultWithTips = (result * tips)/100 + result;
            double roundedResult = ((int)(resultWithTips * 100)/100.00);
            mTextResult.setText(getResources().getString(R.string.result2) + " " + roundedResult + " " + getResources().getString(R.string.with_tips));
        }
        else {
            double result = inputSum / inputPeople;
            double roundedResult = ((int) (result * 100) / 100.00);
            mTextResult.setText(getResources().getString(R.string.result2) + " " + roundedResult);
        }
    }
}
