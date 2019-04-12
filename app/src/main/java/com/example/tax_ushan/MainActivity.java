package com.example.tax_ushan;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etIncome, etTax;
    Button btnCalcualte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIncome= findViewById(R.id.etIncome);
        etTax= findViewById(R.id.etTax);

        btnCalcualte= findViewById(R.id.btnCalculate);

        btnCalcualte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int income, tax;

                income = Integer.parseInt(etIncome.getText().toString()) *12;

                if (income>1 && income<200000){
                    tax = income * 15/100;
                    etTax.setText(Integer.toString(tax));
                }
                else if (income>200000 && income <350000) {
                    tax = (200000 * 1/100) +(income-200000)*15/100;
                    etTax.setText(Integer.toString(tax));
                }
                else if (income>350000) {
                    tax = 200000 * 1/100 +150000*15/100+ (income - 350000)*25/100;
                    etTax.setText(Integer.toString(tax));
                }

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btnCalcualte.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
            }
        });
    }
}
