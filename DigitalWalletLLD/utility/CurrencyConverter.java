package DigitalWalletLLD.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import DigitalWalletLLD.enums.Currency;

public class CurrencyConverter {
    private static Map<Currency, BigDecimal> exchangeRates = new HashMap<>();
    static{
        exchangeRates.put(Currency.USD,BigDecimal.ONE);
        exchangeRates.put(Currency.EUR,new BigDecimal("1.23"));
        exchangeRates.put(Currency.JPY,new BigDecimal("110.2"));
    }

    public static BigDecimal convert(BigDecimal amount, Currency srcCurrency, Currency destCurrency){
        BigDecimal srcExchangeRate = exchangeRates.get(srcCurrency); 
        BigDecimal destExchangeRate = exchangeRates.get(destCurrency);
        return amount.multiply(srcExchangeRate).divide(destExchangeRate, RoundingMode.HALF_UP); 
    }
}
