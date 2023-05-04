package com.mybatis.expense.entity;

import lombok.Data;

@Data
public class MonthlyExpense {
	private int year;
	private int month;
	private int total;
}
