package com.herandher.android.herher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);
    }

    // Just for testing !
    public void move(View view) {
        Intent intent = new Intent(MainActivity.this, GroupActivity.class);
        startActivity(intent);
    }

    public void move2(View view) {
        Intent intent = new Intent(MainActivity.this, StagesActivity.class);
        startActivity(intent);
    }

    public void move3(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}
