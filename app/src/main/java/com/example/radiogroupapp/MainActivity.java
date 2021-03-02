package com.example.radiogroupapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

// View.OnClickListener - Implementation of the function "onClick"
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCreateGreeting; // Set Button
    private TextView tvGreetingTo, tvGreetingText, tvGreetingFrom; // Set TextView
    private ImageView ivGreeting; // Set ImageView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // The design of MainActivity

        initUI();
        initListeners();
    }

    private void initUI() {
        // Id of Button
        btnCreateGreeting = findViewById(R.id.btnCreateGreeting);
        // Id of TextView
        tvGreetingTo = findViewById(R.id.tvGreetingTo);
        tvGreetingText = findViewById(R.id.tvGreetingText);
        tvGreetingFrom = findViewById(R.id.tvGreetingFrom);
        // Id of ImageView
        ivGreeting = findViewById(R.id.ivGreeting);
    }

    private void initListeners() {
        // Give access to elements to be clicked
        btnCreateGreeting.setOnClickListener(this);
    }

    // onActivityResult - get data from SecondActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                tvGreetingTo.setText("To dear " + data.getStringExtra("to"));
                tvGreetingFrom.setText("From " + data.getStringExtra("from"));

                if (data.getStringExtra("rgChoose").equals("Birthday")) {
                    tvGreetingText.setText("Happy birthday!");
                    ivGreeting.setImageResource(R.drawable.happy_birthday);
                } else if (data.getStringExtra("rgChoose").equals("PassTest")) {
                    tvGreetingText.setText("Congratulations on passing the test!");
                    ivGreeting.setImageResource(R.drawable.pass_test);
                }
            } else if (resultCode == RESULT_CANCELED) {
                tvGreetingText.setText("No result...");
            }
        }
    }

    // Performs tasks after click on the elements
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Intent to SecondActivity with requestCode 1 for onActivityResult
            case R.id.btnCreateGreeting:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
    }

}