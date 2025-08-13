package infrastructure.out.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class RequestLogEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String dni;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "http_method")
    private String httpMethod;
    @Column(name = "endpoint_path")
    private String endpointPath;

    public RequestLogEntity() {
    }

    public RequestLogEntity(Long id, String dni, LocalDate createdAt, String httpMethod, String endpointPath) {
        this.id = id;
        this.dni = dni;
        this.createdAt = createdAt;
        this.httpMethod = httpMethod;
        this.endpointPath = endpointPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getEndpointPath() {
        return endpointPath;
    }

    public void setEndpointPath(String endpointPath) {
        this.endpointPath = endpointPath;
    }
}
