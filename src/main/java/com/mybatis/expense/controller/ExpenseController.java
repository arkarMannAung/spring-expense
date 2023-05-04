package com.mybatis.expense.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mybatis.expense.entity.Expense;
import com.mybatis.expense.service.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("monthlyList", this.expenseService.get());
		return "screen/index";
	}

	@GetMapping("/detail")
	public String detail(Model model, @RequestParam("year") int year, @RequestParam("month") int month) {
		model.addAttribute("expenseList", this.expenseService.detail(year, month));
		return "screen/detail";
	}

	@GetMapping("/update/{id}")
	public String update(Model model, @ModelAttribute Expense expense) {
		model.addAttribute("expense", this.expenseService.index(expense));
		return "screen/update";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Expense expense) {
		String year = new SimpleDateFormat("yyyy").format(expense.getDate());
		String month = new SimpleDateFormat("MM").format(expense.getDate());
		this.expenseService.update(expense);
		return "redirect:/detail?year=" + year + "&month=" + month;
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("form",new Expense());
		return "screen/create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute Expense expense ) {
		this.expenseService.create(expense);
		return "redirect:/";
	}
}
