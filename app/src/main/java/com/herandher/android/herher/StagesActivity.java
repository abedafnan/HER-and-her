package com.herandher.android.herher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class StagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stages);

        Toolbar toolbar = (Toolbar) findViewById(R.id.stages_toolbar);
        setSupportActionBar(toolbar);
        // Setting the title of the toolbar
        getSupportActionBar().setTitle("Choose Stage");

    }
}
