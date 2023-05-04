package com.mybatis.expense.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mybatis.expense.entity.Expense;
import com.mybatis.expense.entity.MonthlyExpense;
import com.mybatis.expense.form.ExpenseForm;
import com.mybatis.expense.form.MonthlyExpenseForm;

@Service
public class Helper {
	
	public List<MonthlyExpenseForm> monthlyExpenseMapToForm(List<MonthlyExpense> monthlyExpenses){
		List<MonthlyExpenseForm> monthlyExpenseFroms = new ArrayList<MonthlyExpenseForm>();
		
		for(MonthlyExpense monthlyExpense : monthlyExpenses) {
			MonthlyExpenseForm newForm = new MonthlyExpenseForm();
			newForm.setTitle( monthlyExpense.getYear() +"/"+ monthlyExpense.getMonth() );
			newForm.setYear( monthlyExpense.getYear() );
			newForm.setMonth( monthlyExpense.getMonth() );
			newForm.setTotal( monthlyExpense.getTotal() );
			
			monthlyExpenseFroms.add(newForm);
		}
		
		return monthlyExpenseFroms;
	}
	
	public List<ExpenseForm> expenseMapToForm(List<Expense> expenses){
		List<ExpenseForm> expenseFroms = new ArrayList<ExpenseForm>();
		
		for (Expense e : expenses) {
			ExpenseForm newForm = new ExpenseForm();
			newForm.setId( e.getId());
			newForm.setExpense( e.getExpense() );
			newForm.setTitle( e.getTitle() );
			// Date Format
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			newForm.setDate( dateFormat.format( e.getDate()));
			
			expenseFroms.add(newForm);
		}
		return expenseFroms;
	}
}
