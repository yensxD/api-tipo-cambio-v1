package infrastructure.out.rest;

import infrastructure.out.rest.dto.ExchangeRateDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "api-tipo-cambio-proxy")
@Path("/tipo-cambio")
public interface ExchangeRateProxy {
    @GET
    @Path("/{date}.json")
    ExchangeRateDto getExchangeRateByDate(@PathParam("date") String date);
}
