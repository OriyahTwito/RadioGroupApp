package com.example.radiogroupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

// View.OnClickListener - Implementation of the function "onClick"
public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup rgGreeting; // Set RadioGroup
    private RadioButton rbBirthday, rbPassTest; // Set RadioButton
    private EditText etGreetingTo, etGreetingFrom; // Set EditText
    private Button btnCreateGreeting; // Set Button
    private String rgChoose; // Set String

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // The design of SecondActivity

        initUI();
        initListeners();
    }

    private void initUI() {
        // Id of RadioGroup
        rgGreeting = findViewById(R.id.rgGreeting);
        // Id of RadioButton
        rbBirthday = findViewById(R.id.rbBirthday);
        rbPassTest = findViewById(R.id.rbPassTest);
        // Id of EditText
        etGreetingTo = findViewById(R.id.etGreetingTo);
        etGreetingFrom = findViewById(R.id.etGreetingFrom);
        // Id of Button
        btnCreateGreeting = findViewById(R.id.btnCreateGreeting);
    }

    private void initListeners() {
        // Give access to elements to be clicked
        btnCreateGreeting.setOnClickListener(this);
    }

    // Intent data to MainActivity with data for onActivityResult
    private void sendData() {
        int selectedId = rgGreeting.getCheckedRadioButtonId();

        if (selectedId == rbBirthday.getId()) {
            rgChoose = "Birthday";
        } else if (selectedId == rbPassTest.getId()) {
            rgChoose = "PassTest";
        }

        if (rgChoose != null && !etGreetingTo.getText().toString().isEmpty() && !etGreetingFrom.getText().toString().isEmpty()) {
            Intent intent = new Intent();
            intent.putExtra("rgChoose", rgChoose);
            intent.putExtra("to", etGreetingTo.getText().toString());
            intent.putExtra("from", etGreetingFrom.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        } else {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_LONG).show();
        }
    }

    // Performs tasks after click on the elements
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Perform the method sendData()
            case R.id.btnCreateGreeting:
                sendData();
                break;
        }
    }

}