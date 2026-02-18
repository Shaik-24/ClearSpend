package com.clearspend.clearspend.controller;

import com.clearspend.clearspend.dto.MonthlySummaryDto;
import java.util.List;
import com.clearspend.clearspend.entity.Expense;
import com.clearspend.clearspend.service.ExpenseService;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin("*")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // Add Expense
    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    // Get Monthly Summary
    @GetMapping("/summary")
    public MonthlySummaryDto getMonthlySummary(
            @RequestParam int year,
            @RequestParam int month) {

        return expenseService.getMonthlySummary(year, month);
    }
    
    // Get Monthly Transactions
    @GetMapping("/list")
    public List<Expense> getMonthlyExpenses(
            @RequestParam int year,
            @RequestParam int month) {

        return expenseService.getMonthlyExpenses(year, month);
    }

    // Clear All Data
    @DeleteMapping("/clear")
    public String clearAllExpenses() {
        expenseService.deleteAllExpenses();
        return "All expenses deleted successfully!";
    }

}


