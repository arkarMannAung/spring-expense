package com.mybatis.expense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.expense.entity.Expense;
import com.mybatis.expense.form.ExpenseForm;
import com.mybatis.expense.form.MonthlyExpenseForm;
import com.mybatis.expense.helper.Helper;
import com.mybatis.expense.repository.ExpenseMapper;

@Service
public class ExpenseService {
	@Autowired
	ExpenseMapper expenseMapper;

	@Autowired
	Helper helper;

	public List<MonthlyExpenseForm> get() {
		return this.helper.monthlyExpenseMapToForm(this.expenseMapper.get());
	}

	public List<ExpenseForm> detail(int year, int month) {
		return this.helper.expenseMapToForm(this.expenseMapper.detail(year, month));
	}

	public Expense index(Expense expense) {
		return this.expenseMapper.index(expense);
	}

	public void update(Expense expense) {
		this.expenseMapper.update(expense.getId(), expense.getTitle(), expense.getDate(), expense.getExpense());
	}
	
	public void create(Expense expense) {
		this.expenseMapper.create(expense);
	}
}
