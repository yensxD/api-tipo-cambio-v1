package domain.port.in;

import domain.model.ExchangeRate;

import java.time.LocalDate;

public interface GetExchangeRateUseCase {
    ExchangeRate execute(String dni, LocalDate date);
}
