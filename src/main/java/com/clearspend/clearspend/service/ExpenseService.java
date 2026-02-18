package com.clearspend.clearspend.service;

import com.clearspend.clearspend.dto.MonthlySummaryDto;
import com.clearspend.clearspend.entity.Expense;
import com.clearspend.clearspend.entity.ExpenseType;
import com.clearspend.clearspend.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Add Expense
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Monthly Summary
    public MonthlySummaryDto getMonthlySummary(int year, int month) {

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        List<Expense> expenses =
                expenseRepository.findByDateBetweenOrderByDateAsc(startDate, endDate);

        double totalIncome = expenses.stream()
                .filter(e -> e.getType() == ExpenseType.INCOME)
                .mapToDouble(Expense::getAmount)
                .sum();

        double totalExpense = expenses.stream()
                .filter(e -> e.getType() == ExpenseType.EXPENSE)
                .mapToDouble(Expense::getAmount)
                .sum();

        double netBalance = totalIncome - totalExpense;

        return new MonthlySummaryDto(
                totalIncome,
                totalExpense,
                netBalance
        );
    }
    
    // Get Monthly Transactions
    public List<Expense> getMonthlyExpenses(int year, int month) {

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        return expenseRepository
                .findByDateBetweenOrderByDateAsc(startDate, endDate);

    }

    // Delete All Expenses
    public void deleteAllExpenses() {
        expenseRepository.deleteAll();
    }

}

