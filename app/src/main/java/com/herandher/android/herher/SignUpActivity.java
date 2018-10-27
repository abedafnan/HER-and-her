package com.herandher.android.herher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.herandher.android.herher.R;

public class SignUpActivity extends AppCompatActivity {


    private EditText userName_editText;
    private EditText password_editText;
    private EditText email_editText;
    private Spinner countyrSpinner;
    private Spinner statuesSpinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userName_editText = findViewById(R.id.userName_editText_signUp);
        password_editText = findViewById(R.id.password_editText_signUp);
        email_editText = findViewById(R.id.email_editText);
        countyrSpinner = findViewById(R.id.country_spinner);
        statuesSpinner = findViewById(R.id.userStatus_spinner);

        String username= userName_editText.getText().toString();
        String password = password_editText.getText().toString();
        String email_user = email_editText.getText().toString();


        ArrayAdapter<String> countries =
                new ArrayAdapter<String>(this,R.layout.item_spinner,R.id.spinner_textView);
        countries.add(" Palestine");
        countries.add(" Jordan");
        countries.add(" Egypt");
        countries.add(" Lebanon");
        countries.add(" Canada");
        countries.add(" America");
        countries.add(" India");
        countyrSpinner.setAdapter(countries);


        ArrayAdapter<String> statusUser =
                new ArrayAdapter<String>(this,R.layout.item_spinner,R.id.spinner_textView);
        statusUser.add(" Patient");
        statusUser.add(" Doctor");
        statusUser.add(" Survivor");
        statusUser.add(" Protection");
        statuesSpinner.setAdapter(statusUser);
    }

    public void signUp(View view){
        Intent intent = new Intent(SignUpActivity.this, StagesActivity.class);
        startActivity(intent);
    }
}
