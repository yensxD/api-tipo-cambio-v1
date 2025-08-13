package application.usecase;

import application.service.RateLimitService;
import application.utils.Constants;
import domain.model.ExchangeRate;
import domain.port.in.GetExchangeRateUseCase;
import domain.port.out.repository.RequestLogRepository;
import domain.port.out.rest.ExchangeRateRest;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;

@ApplicationScoped
public class GetExchangeRateUseCaseImpl implements GetExchangeRateUseCase {
    private final ExchangeRateRest exchangeRateRest;
    private final RequestLogRepository requestLogRepository;
    private final RateLimitService rateLimitService;

    public GetExchangeRateUseCaseImpl(ExchangeRateRest exchangeRateRest, RequestLogRepository requestLogRepository, RateLimitService rateLimit) {
        this.exchangeRateRest = exchangeRateRest;
        this.requestLogRepository = requestLogRepository;
        this.rateLimitService = rateLimit;
    }

    @Override
    public ExchangeRate execute(String dni, LocalDate date) {

        String dateAsString = (date != null) ? date.toString() : Constants.DATE_TODAY ;

        rateLimitService.check(dni);

        var exchangeRate = exchangeRateRest.getExchangeRateByDate(dateAsString);

        requestLogRepository.create(dni, dateAsString);

        return exchangeRate;
    }
}
