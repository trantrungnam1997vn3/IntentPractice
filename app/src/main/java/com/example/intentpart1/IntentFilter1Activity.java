package com.example.intentpart1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntentFilter1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_filter1);


    }

    public void showLoanPayments1(View clickedButton) {
        Intent activityIntent =
                new Intent(this, LoanCalculatorActivity.class);
        startActivity(activityIntent);
    }

    public void showLoanPayments2(View view) {
        Intent activityIntent =
                new Intent(this, LoanCalculatorActivity.class);
        activityIntent.putExtras
                (LoanBundler.makeRandomizedLoanInfoBundle());
        startActivity(activityIntent);
    }
}
