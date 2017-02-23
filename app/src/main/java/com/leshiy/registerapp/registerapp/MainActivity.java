package com.leshiy.registerapp.registerapp;

import android.content.Intent;
import android.icu.text.BreakIterator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int NAME_REQUEST_CODE = 101;
    private static final int BIRTHDAY_REQUEST_CODE = 102;
    private static final int ABOUT_REQUEST_CODE = 103;
    private static final int REGISTER_REQUEST_CODE = 104;

    private static final int RESULT_CODE_NAME = 101;
    private static final int RESULT_CODE_BIRTHDAY = 102;
    private static final int RESULT_CODE_ABOUT = 103;
    private static final int RESULT_CODE_EXIT = 104;

    private Button buttonName;
    private Button buttonBirthday;
    private Button buttonAbout;
    private Button buttonRegister;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonName = (Button) findViewById(R.id.btn_start_activity_name);
        buttonAbout = (Button) findViewById(R.id.btn_start_activity_aboutme);
        buttonBirthday = (Button) findViewById(R.id.btn_start_activity_birthday);
        buttonRegister = (Button) findViewById(R.id.btn_register);
        buttonName.setOnClickListener(this);
        buttonBirthday.setOnClickListener(this);
        buttonAbout.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
        user = new User();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_start_activity_name:
                intent = new Intent(this, NameActivity.class);
                intent.putExtra("firstName", user.getFirstName());
                intent.putExtra("lastName", user.getLastName());
                startActivityForResult(intent, NAME_REQUEST_CODE);
                break;
            case R.id.btn_start_activity_birthday:
                intent = new Intent(this, BirthdayActivity.class);
                intent.putExtra("birthday", user.getBirthday());
                startActivityForResult(intent, BIRTHDAY_REQUEST_CODE);
                break;
            case R.id.btn_start_activity_aboutme:
                intent = new Intent(this, AboutActivity.class);
                intent.putExtra("about", user.getAbout());
                startActivityForResult(intent, ABOUT_REQUEST_CODE);
                break;
            case R.id.btn_register:
                if (user.checkData()) {
                    intent = new Intent(this, ResultActivity.class);
                    intent.putExtra("user", user);
                    startActivityForResult(intent, REGISTER_REQUEST_CODE);
                } else {
                    Toast.makeText(this, "Not all data is entered", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                return;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case RESULT_CODE_NAME:
                user.setFirstName(data.getStringExtra("firstName"));
                user.setLastName(data.getStringExtra("lastName"));
                break;
            case RESULT_CODE_BIRTHDAY:
                user.setBirthday(data.getStringExtra("birthday"));
                break;
            case RESULT_CODE_ABOUT:
                user.setAbout(data.getStringExtra("about"));
                break;
            case RESULT_CODE_EXIT:
                finish();
                break;

        }
    }
}
