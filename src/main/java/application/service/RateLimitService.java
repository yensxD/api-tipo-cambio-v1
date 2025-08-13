package application.service;

import application.exceptions.TooManyRequestsException;
import application.utils.Constants;
import domain.port.out.repository.RequestLogRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;

@ApplicationScoped
public class RateLimitService {
    private final RequestLogRepository requestLogRepository;

    public RateLimitService(RequestLogRepository requestLogRepository) {
        this.requestLogRepository = requestLogRepository;
    }

    public void check(String dni) {
        long countRequestByUser = requestLogRepository.countRequestsByDni(dni, LocalDate.now());
        if (countRequestByUser >= Constants.MAX_DAILY_QUERIES) {
            throw new TooManyRequestsException(Constants.MAX_DAILY_QUERIES_EXCEEDED_MESSAGE);
        }
    }
}
