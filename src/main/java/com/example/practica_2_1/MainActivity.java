package com.example.practica_2_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputText;
    Button btnToBinary, btnToOctal, btnToDecimal, btnToHexadecimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputID);
        btnToBinary = findViewById(R.id.ID2);
        btnToOctal = findViewById(R.id.ID8);
        btnToDecimal = findViewById(R.id.ID10);
        btnToHexadecimal = findViewById(R.id.ID16);


        btnToBinary.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String binary = inputText.getText().toString();
                int demicalNumber = 0;
                int power = 0;

                for (int i = binary.length() - 1; i >= 0; i--) {
                    if (binary.charAt(i) == '1') {
                        demicalNumber += Math.pow(2, power);
                    }
                    power++;
                }
                String octalNumber = Integer.toOctalString(demicalNumber);
                String hexNumber = Integer.toHexString(demicalNumber);
                String demical = Integer.toString(demicalNumber);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("key2", binary);
                intent.putExtra("key8", octalNumber);
                intent.putExtra("key10", demical);
                intent.putExtra("key16", hexNumber);
                startActivity(intent);
            }
        });

        btnToOctal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String number = inputText.getText().toString();
                int demicalNumber = Integer.parseInt(number, 8);
                String demical = Integer.toString(demicalNumber);
                String binary = Integer.toBinaryString(demicalNumber);
                String hexNumber = Integer.toHexString(demicalNumber);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("key2", binary);
                intent.putExtra("key8", number);
                intent.putExtra("key10", demical);
                intent.putExtra("key16", hexNumber);
                startActivity(intent);
            }
        });

        btnToHexadecimal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String number = inputText.getText().toString();
                int demicalNumber = Integer.parseInt(number, 16);
                String demical = Integer.toString(demicalNumber);
                String binary = Integer.toBinaryString(demicalNumber);
                String octalNumber = Integer.toOctalString(demicalNumber);
                ;
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("key2", binary);
                intent.putExtra("key8", octalNumber);
                intent.putExtra("key10", demical);
                intent.putExtra("key16", number);
                startActivity(intent);
            }
        });

        btnToDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputText.getText().toString();
                double number = Double.parseDouble(input);
                String octalNumber = Integer.toOctalString((int) number) + ".";
                double fraction = number - (int) number;

                for (int i = 0; i < 4; i++) {
                    fraction *= 8;
                    octalNumber += (int) fraction;
                    fraction -= (int) fraction;
                }

                String hexNumber = Integer.toHexString((int) number) + ".";
                double fraction1 = number - (int) number;
                for (int i = 0; i < 2; i++) {
                    fraction1 *= 16;
                    int intValue = (int) fraction1;
                    hexNumber += Integer.toHexString(intValue);
                    fraction1 -= intValue;
                }

                String binary = Integer.toBinaryString((int) number) + ".";
                double fraction2 = number - (int) number;
                for (int i = 0; i < 8; i++) {
                    fraction2 *= 2;
                    binary += (int) fraction2;
                    fraction2 -= (int) fraction2;
                }
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("key2", binary);
                intent.putExtra("key8", octalNumber);
                intent.putExtra("key10", input);
                intent.putExtra("key16", hexNumber);
                startActivity(intent);
            }
        });
    }
}