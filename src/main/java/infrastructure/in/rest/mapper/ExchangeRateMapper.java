package infrastructure.in.rest.mapper;

import domain.model.ExchangeRate;
import infrastructure.in.rest.dto.response.ExchangeRateResponse;
import infrastructure.out.rest.mapper.ExchangeRateDtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExchangeRateMapper {
    ExchangeRateMapper INSTANCE = Mappers.getMapper(ExchangeRateMapper.class);
    @Mapping(source = "date", target = "fecha")
    @Mapping(source = "buy", target = "compra")
    @Mapping(source = "sell", target = "venta")
    ExchangeRateResponse toResponse(ExchangeRate exchangeRate);
}
