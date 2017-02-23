package com.leshiy.registerapp.registerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BirthdayActivity extends AppCompatActivity implements View.OnClickListener {


    private static final int RESULT_CODE = 102;
    private Button doneButton;
    private Button cancelButton;
    private EditText editTextBirthday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        editTextBirthday = (EditText) findViewById(R.id.edit_text_birthday);
        doneButton = (Button) findViewById(R.id.button_birthday_done);
        cancelButton = (Button) findViewById(R.id.button_birthday_cancel);
        doneButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
        editTextBirthday.setText(getIntent().getStringExtra("birthday"));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_birthday_done:
                String birthday = editTextBirthday.getText().toString();
                if (!(birthday.equals(""))) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("birthday", birthday);
                    setResult(RESULT_CODE, resultIntent);
                    finish();
                } else {
                    Toast.makeText(this, "Enter all data", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_birthday_cancel:
                finish();
                break;
        }
    }
}
