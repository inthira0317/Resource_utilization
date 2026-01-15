package com.example.currency.service;

import org.springframework.stereotype.Service;

import com.example.currency.Repository.CurrencyRepository;
import com.example.currency.model.Currency;

@Service
public class CurrencyService {
	private final CurrencyRepository repository;
	public CurrencyService(CurrencyRepository repository) {
		this.repository = repository;
	}
    public double convertCurrency(String from,String to,Double amount) {
    	Currency fromCurrency = repository.findByCurrencyCode(from);
    	Currency toCurrency = repository.findByCurrencyCode(to);
    	if (fromCurrency == null || toCurrency == null) {
    	}
    	
    	return amount * (toCurrency.getExchangeRate() / fromCurrency.getExchangeRate());
    	
    }
}
