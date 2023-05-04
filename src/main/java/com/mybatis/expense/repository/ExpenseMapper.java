package com.mybatis.expense.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mybatis.expense.entity.Expense;
import com.mybatis.expense.entity.MonthlyExpense;

@Mapper
public interface ExpenseMapper {

	// get Monthly Expense By Month
	List<MonthlyExpense> get();

	// get Detail Expense By Month
	List<Expense> detail(@Param("year") int year, @Param("month") int month);

	// get Expense By Id
	Expense index(Expense expense);

	// update Expense By Id
	void update(@Param("id") int id, @Param("title") String title, @Param("date") Date date,
			@Param("expense") int expense);

	// create Expense
	void create(Expense expense);

}
