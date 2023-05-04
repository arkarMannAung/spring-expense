package com.mybatis.expense.form;

import lombok.Data;

@Data
public class ExpenseForm {
	public int id;
	public String date;
	public int expense;
	public String title;
}
