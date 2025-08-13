package infrastructure.out.database.jpa;

import infrastructure.out.database.entity.RequestLogEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;

@ApplicationScoped
public class RequestLogJpaAdapterRepository implements PanacheRepository<RequestLogEntity> {
    public long countByDni(String dni, LocalDate date) {
        return count("createdAt = ?1 and dni = ?2", date, dni);
    }
}
