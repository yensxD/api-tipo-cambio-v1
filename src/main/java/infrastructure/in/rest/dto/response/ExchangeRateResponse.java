package infrastructure.in.rest.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class ExchangeRateResponse {
    private String fecha;
    private BigDecimal compra;
    private BigDecimal venta;
}
