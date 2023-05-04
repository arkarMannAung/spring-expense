package com.mybatis.expense.form;

import lombok.Data;

@Data
public class MonthlyExpenseForm {
	private String title;
	private int year;
	private int month;
	private int total;
}
