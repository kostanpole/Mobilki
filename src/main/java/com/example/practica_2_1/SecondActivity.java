package com.example.practica_2_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends MainActivity {

    TextView ansText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ansText = findViewById(R.id.ansId);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String binary = extras.getString("key2");
            String octal = extras.getString("key8");
            String demical = extras.getString("key10");
            String hex = extras.getString("key16");
            ansText.setText("В двоичной СС:  " + binary + "  В восьмиричной СС:  " + octal + "  В десятичной СС:  " + demical + "  В шестнадцатиричной СС:  " + hex);
        }

        Button infoButton = findViewById(R.id.button2);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}