package domain.port.out.rest;

import domain.model.ExchangeRate;

public interface ExchangeRateRest {
    ExchangeRate getExchangeRateByDate(String date);
}
