package com.example.intentpart1;

import java.text.NumberFormat;

public class PaymentInfo {
    private final double mLoanAmount, mAnnualInterestRateInPercent,
            mMonthlyPayment, mTotalPayments;
    private final long mLoanPeriodInMonths;
    private final String mCurrencySymbol;

    public PaymentInfo(double loanAmount, double annualInterestRateInPercent,
                       long loanPeriodInMonths, String currencySymbol) {
        mLoanAmount = loanAmount;
        mAnnualInterestRateInPercent = annualInterestRateInPercent;
        mLoanPeriodInMonths = loanPeriodInMonths;
        mCurrencySymbol = currencySymbol;
        mMonthlyPayment = LoanUtils.monthlyPayment(loanAmount,
                annualInterestRateInPercent,
                loanPeriodInMonths);
        mTotalPayments = mMonthlyPayment * mLoanPeriodInMonths;
    }

    public String getFormattedLoanAmount() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        return numberFormat.format(mLoanAmount);
    }

    public String getFormattedAnnualInterestRateInPercent() {
        return mAnnualInterestRateInPercent + "%";
    }

    public String getFormattedLoanPeriodInMonths() {
        return mLoanPeriodInMonths + "";
    }

    public String getFormattedMonthlyPayment() {
        return "$" + mMonthlyPayment;
    }

    public String getFormattedTotalPayments() {
        return "$" + mTotalPayments;
    }

    public double getFormatAnnualInterestRateInPercent() {
        return mAnnualInterestRateInPercent;
    }

    public double getmLoanAmount() {
        return mLoanAmount;
    }

    public double getmMonthlyPayment() {
        return mMonthlyPayment;
    }

    public double getmTotalPayments() {
        return mTotalPayments;
    }

    public long getmLoanPeriodInMonths() {
        return mLoanPeriodInMonths;
    }

    public String getmCurrencySymbol() {
        return mCurrencySymbol;
    }

}
