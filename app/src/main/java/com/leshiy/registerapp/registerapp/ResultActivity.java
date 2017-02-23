package com.leshiy.registerapp.registerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private static final int RESULT_CODE_EXIT = 104;

    private TextView firstName;
    private TextView lastName;
    private TextView birthday;
    private TextView about;
    private Button closeapp;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        firstName = (TextView) findViewById(R.id.textview_firstname);
        lastName = (TextView) findViewById(R.id.textview_lastname);
        birthday = (TextView) findViewById(R.id.textview_birthday);
        about = (TextView) findViewById(R.id.textview_about);
        closeapp = (Button) findViewById(R.id.button_closeapp);
        user = getIntent().getParcelableExtra("user");

        closeapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CODE_EXIT);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        birthday.setText(user.getBirthday());
        about.setText(user.getAbout());
    }
}
