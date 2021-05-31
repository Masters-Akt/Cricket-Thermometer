package com.masters_akt.cricketthermometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etChirps;
    Button btnCalc;
    TextView tvResult;
    DecimalFormat Formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChirps = findViewById(R.id.etChirps);
        btnCalc = findViewById(R.id.btnCalc);
        tvResult = findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);
        Formatter = new DecimalFormat("#0.00");

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etChirps.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter All Fields!", Toast.LENGTH_SHORT).show();
                }else{
                    int chirps = Integer.parseInt(etChirps.getText().toString().trim());
                    double temp = (chirps/3.0) + 4;
                    double tempf = ((temp*5)/9.0) + 32;
                    String res = "The approximate temperature outside is "+Formatter.format(temp)+" degrees celcius or "+Formatter.format(tempf)+" degrees fahrenheit";
                    tvResult.setText(res);
                    tvResult.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
