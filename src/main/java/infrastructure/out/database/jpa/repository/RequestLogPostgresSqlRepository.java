package infrastructure.out.database.jpa.repository;

import domain.port.out.repository.RequestLogRepository;
import infrastructure.out.database.entity.RequestLogEntity;
import infrastructure.out.database.jpa.RequestLogJpaAdapterRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

@ApplicationScoped
public class RequestLogPostgresSqlRepository implements RequestLogRepository {
    private final RequestLogJpaAdapterRepository requestLogJpaAdapterRepository;

    public RequestLogPostgresSqlRepository(RequestLogJpaAdapterRepository requestLogJpaAdapterRepository) {
        this.requestLogJpaAdapterRepository = requestLogJpaAdapterRepository;
    }

    @Override
    public long countRequestsByDni(String dni, LocalDate date) {
        return requestLogJpaAdapterRepository.countByDni(dni, date);
    }

    @Override
    @Transactional
    public void create(String dni, String date) {
        RequestLogEntity requestLogEntity = new RequestLogEntity();
        requestLogEntity.setDni(dni);
        requestLogEntity.setCreatedAt(LocalDate.now());
        requestLogEntity.setEndpointPath("exchange-rate/" + dni + "?date=" + date);
        requestLogEntity.setHttpMethod("GET");

        requestLogJpaAdapterRepository.persist(requestLogEntity);
    }
}
