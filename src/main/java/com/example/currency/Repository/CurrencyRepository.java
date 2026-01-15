package com.example.currency.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.currency.model.Currency;

@Repository
public class CurrencyRepository {
	private JdbcTemplate jdbcTemplate;

	public CurrencyRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;	
	}
	@SuppressWarnings("deprecation")
    public Currency findByCurrencyCode(String currencyCode) {
        String sql = "SELECT * FROM currency WHERE currency_code = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{currencyCode},
                this::mapRowToCurrency
        );
    }

    private Currency mapRowToCurrency(ResultSet rs, int rowNum) throws SQLException {
        return new Currency(
                rs.getString("currency_code"),
                rs.getDouble("exchange_rate")
        );
    }
}