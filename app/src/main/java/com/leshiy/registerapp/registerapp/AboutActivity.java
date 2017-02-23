package com.leshiy.registerapp.registerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int RESULT_CODE = 103;
    private Button doneButton;
    private Button cancelButton;
    private EditText aboutme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        aboutme = (EditText) findViewById(R.id.edit_text_aboutme);
        doneButton = (Button) findViewById(R.id.button_about_done);
        cancelButton = (Button) findViewById(R.id.button_about_cancel);
        doneButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
        aboutme.setText(getIntent().getStringExtra("about"));
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_about_done:
                String about = aboutme.getText().toString();
                if (!(about.equals(""))) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("about", about);
                    setResult(RESULT_CODE, resultIntent);
                    finish();
                } else {
                    Toast.makeText(this, "Enter all data", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_about_cancel:
                finish();
                break;
        }

    }
}
