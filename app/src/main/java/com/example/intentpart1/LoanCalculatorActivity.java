package com.example.intentpart1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoanCalculatorActivity extends Activity {

    private double mLoanAmount=100000,
            mAnnualInterestRateInPercent=5.0;
    private long mLoanPeriodInMonths=360; // 30 years
    private String mCurrencySymbol = "$";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loan_payment);
        setInputsFromExtras();
//        setInputsFromUri();
        calculateAndSetOutputValues();
    }

    private void setInputsFromExtras() {
        Intent intent = getIntent();
        Bundle loanInfo = intent.getExtras();
        if (loanInfo != null) {
            double loanAmount = loanInfo.getDouble("loanAmount");
            double annualInterestRateInPercent =
                    loanInfo.getDouble("annualInterestRateInPercent");
            long loanPeriodInMonths =
                    loanInfo.getLong("loanPeriodInMonths");
            String currencySymbol =
                    loanInfo.getString("currencySymbol");
            setInputs(loanAmount, annualInterestRateInPercent,
                    loanPeriodInMonths, currencySymbol);
        }
    }

    private void setInputs(double loanAmount,
                           double annualInterestRateInPercent,
                           long loanPeriodInMonths,
                           String currencySymbol) {
        if (loanAmount > 0) {
            mLoanAmount = loanAmount;
        }
        if (annualInterestRateInPercent > 0) {
            mAnnualInterestRateInPercent =
                    annualInterestRateInPercent;
        }
        if (loanPeriodInMonths > 0) {
            mLoanPeriodInMonths = loanPeriodInMonths;
        }
        if (currencySymbol != null) {
            mCurrencySymbol = currencySymbol;
        }
    }

    private void calculateAndSetOutputValues() {
        PaymentInfo paymentInfo =
                new PaymentInfo(mLoanAmount, mAnnualInterestRateInPercent,
                        mLoanPeriodInMonths, mCurrencySymbol);
        TextView loanAmountDisplay = (TextView)findViewById(R.id.loan_amount);
        loanAmountDisplay.setText(paymentInfo.getFormattedLoanAmount());
        TextView interestRateDisplay =
                (TextView)findViewById(R.id.interest_rate);
        interestRateDisplay.setText
                (paymentInfo.getFormattedAnnualInterestRateInPercent());
        TextView loanPeriodDisplay = (TextView)findViewById(R.id.loan_period);
        loanPeriodDisplay.setText(paymentInfo.getFormattedLoanPeriodInMonths());
        TextView monthlyPaymentDisplay =
                (TextView)findViewById(R.id.monthly_payment);
        monthlyPaymentDisplay.setText(paymentInfo.getFormattedMonthlyPayment());
        TextView totalPaymentsDisplay =
                (TextView)findViewById(R.id.total_payments);
        totalPaymentsDisplay.setText(paymentInfo.getFormattedTotalPayments());
    }
}
