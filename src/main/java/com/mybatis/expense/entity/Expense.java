package com.mybatis.expense.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Expense {
	public int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date date;
	public int expense;
	public String title;
}
