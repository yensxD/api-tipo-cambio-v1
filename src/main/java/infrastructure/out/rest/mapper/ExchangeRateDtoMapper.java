package infrastructure.out.rest.mapper;

import domain.model.ExchangeRate;
import infrastructure.out.rest.dto.ExchangeRateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExchangeRateDtoMapper {
    ExchangeRateDtoMapper INSTANCE = Mappers.getMapper(ExchangeRateDtoMapper.class);
    @Mapping(source = "fecha", target = "date")
    @Mapping(source = "compra", target = "buy")
    @Mapping(source = "venta", target = "sell")
    ExchangeRate toDomain(ExchangeRateDto dto);
}
