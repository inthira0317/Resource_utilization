package com.example.currency.model;

public class Currency {
	private String currencycode;
	private double exchangeRate;
	public Currency(String currencyCode, double exchangeRate) {
		this.setCurrencycode(currencyCode);
		this.setExchangeRate(exchangeRate);		
	}
	public String getCurrencycode() {
		return currencycode;
	}
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}
	public double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
}
	