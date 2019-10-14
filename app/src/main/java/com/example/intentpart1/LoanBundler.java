package com.example.intentpart1;

import android.os.Bundle;

import java.util.Random;

class LoanBundler {

    public static Bundle makeRandomizedLoanInfoBundle() {
        Random randomizer = new Random();
        double loanAmount = 25000 * (1 + randomizer.nextInt(10));
        double interestRate = 0.25 * (1 + randomizer.nextInt(60));
        long loanPeriod = 12 * (1 + randomizer.nextInt(30));
        return(LoanBundler.makeLoanInfoBundle(loanAmount, interestRate, loanPeriod));
    }


    public static Bundle makeLoanInfoBundle(double loanAmount,
                                            double annualInterestRateInPercent,
                                            long loanPeriodInMonths) {
        Bundle loanInfo = new Bundle();
        loanInfo.putDouble("loanAmount", loanAmount);
        loanInfo.putDouble("annualInterestRateInPercent",
                annualInterestRateInPercent);
        loanInfo.putLong("loanPeriodInMonths", loanPeriodInMonths);
        return(loanInfo);
    }




}
