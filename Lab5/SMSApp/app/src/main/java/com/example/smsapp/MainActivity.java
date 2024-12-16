package com.example.smsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
013
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText phoneNumber = findViewById(R.id.editTextPhone);
        EditText messageText = findViewById(R.id.editTextMessage);
        Button sendButton = findViewById(R.id.buttonSend);

        sendButton.setOnClickListener(v -> {
            String phone = phoneNumber.getText().toString();
            String message = messageText.getText().toString();

            // Create an Intent for sending an SMS
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:" + phone)); // Set the URI with phone number
            intent.putExtra("sms_body", message); // Attach the message content
            startActivity(intent); // Start the SMS app
        });
    }
}
