package com.helloword.activity;

import com.helloword.R;
import com.helloword.R.layout;
import com.helloword.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ChangePhotoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_photo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.change_photo, menu);
        return true;
    }

}