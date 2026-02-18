package com.clearspend.clearspend.dto;

public class MonthlySummaryDto {

    private double totalIncome;
    private double totalExpense;
    private double netBalance;

    public MonthlySummaryDto(double totalIncome,
                             double totalExpense,
                             double netBalance) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.netBalance = netBalance;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public double getNetBalance() {
        return netBalance;
    }
}

