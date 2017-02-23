package com.leshiy.registerapp.registerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity implements View.OnClickListener{
    
    private static final int RESULT_CODE = 101;
    private Button doneButton;
    private Button cancelButton;
    private EditText editTextFirstName;
    private EditText editTextLastName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_name);

        editTextFirstName = (EditText) findViewById(R.id.edit_text_firstname);
        editTextLastName = (EditText) findViewById(R.id.edit_text_lastname);
        doneButton = (Button) findViewById(R.id.button_name_done);
        cancelButton = (Button) findViewById(R.id.button_name_cancel);
        doneButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

        editTextFirstName.setText(getIntent().getStringExtra("firstName"));
        editTextLastName.setText(getIntent().getStringExtra("lastName"));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_name_done:
                String firstName = editTextFirstName.getText().toString();
                String lastName = editTextLastName.getText().toString();
                if (! (firstName.equals("") || lastName.equals("")) ){
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("firstName",firstName);
                    resultIntent.putExtra("lastName",lastName);
                    setResult(RESULT_CODE,resultIntent);
                    finish();
                }
                else{
                    Toast.makeText(this, "Enter all data", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_name_cancel:
                finish();
                break;
        }

    }
}
