package infrastructure.in.rest.controller;

import domain.port.in.GetExchangeRateUseCase;
import infrastructure.in.rest.annotation.DocumentNumeric;
import infrastructure.in.rest.dto.response.ExchangeRateResponse;
import infrastructure.in.rest.mapper.ExchangeRateMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;

@Path("exchange-rate")
@Produces(MediaType.APPLICATION_JSON)
public class ExhangeRateController {
    private final GetExchangeRateUseCase exchangeRateUseCase;

    public ExhangeRateController(GetExchangeRateUseCase exchangeRateUseCase) {
        this.exchangeRateUseCase = exchangeRateUseCase;
    }

    @GET
    @Path("/{dni}")
    public ExchangeRateResponse getExchangeRateByDni(
            @PathParam("dni") @DocumentNumeric String dni,
            @QueryParam("date") LocalDate date) {

        return ExchangeRateMapper.INSTANCE
                .toResponse(exchangeRateUseCase.execute(dni, date));
    }

}
