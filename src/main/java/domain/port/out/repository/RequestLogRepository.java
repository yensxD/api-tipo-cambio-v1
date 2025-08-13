package domain.port.out.repository;

import java.time.LocalDate;

public interface RequestLogRepository {
    long countRequestsByDni(String dni, LocalDate date);
    void create(String dni, String date);
}
