package com.clearspend.clearspend.repository;

import com.clearspend.clearspend.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Get expenses between dates (chronological order)
    List<Expense> findByDateBetweenOrderByDateAsc(
            LocalDate startDate,
            LocalDate endDate
    );
}

