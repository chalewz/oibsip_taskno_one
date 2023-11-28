package com.example.unit_convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private EditText value;
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private Button convert;
    private TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value = findViewById(R.id.value);
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        convert = findViewById(R.id.convert);
        textResult = findViewById(R.id.textResult);

      convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double value1 = Double.parseDouble(value.getText().toString());
                double result = convertUnit(value1, spinnerFrom.getSelectedItem().toString(), spinnerTo.getSelectedItem().toString());
                textResult.setText(String.valueOf(result));
            }
        });
    }

    private double convertUnit(double value, String fromUnit, String toUnit) {
        double res=0.0;
           if (fromUnit.equals("Meter") && toUnit.equals("Centimeter")) {
            res = value * 100.0;
        } else if (fromUnit.equals("Centimeter") && toUnit.equals("Meter")) {
            res = value / 100.0;
        }
         else if (fromUnit.equals("Kilometer") && toUnit.equals("Meter")) {
            res = value * 1000.0;
        }else if (fromUnit.equals("Meter") && toUnit.equals("Kilometer")) {
               res = value / 1000.0;
           }

        return res;
    }
}