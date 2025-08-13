package infrastructure.out.rest.proxy;

import domain.model.ExchangeRate;
import domain.port.out.rest.ExchangeRateRest;
import infrastructure.out.rest.ExchangeRateProxy;
import infrastructure.out.rest.dto.ExchangeRateDto;
import infrastructure.out.rest.mapper.ExchangeRateDtoMapper;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
@ApplicationScoped
public class ExchangeRateRestImpl implements ExchangeRateRest {
    private final ExchangeRateProxy exchangeRateProxy;

    public ExchangeRateRestImpl(@RestClient ExchangeRateProxy exchangeRateProxy) {
        this.exchangeRateProxy = exchangeRateProxy;
    }

    @Override
    public ExchangeRate getExchangeRateByDate(String date) {
        ExchangeRateDto response = exchangeRateProxy.getExchangeRateByDate(date);
        return ExchangeRateDtoMapper.INSTANCE.toDomain(response);
    }
}
