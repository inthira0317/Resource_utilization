package com.example.currency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.currency.service.CurrencyService;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {
	private final CurrencyService currencyService;
	public CurrencyController(CurrencyService currencyService) {
		this.currencyService = currencyService;
		
	}
	@GetMapping("/convert")
	public Double convertCurrency(
		 @RequestParam String from,
		 @RequestParam String to,
		 @RequestParam Double amount) {
		return currencyService.convertCurrency(from,to,amount);
	}
}
