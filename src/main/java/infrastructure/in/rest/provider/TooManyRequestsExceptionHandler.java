package infrastructure.in.rest.provider;

import application.exceptions.TooManyRequestsException;
import application.utils.Constants;
import infrastructure.in.rest.dto.ApiException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class TooManyRequestsExceptionHandler implements ExceptionMapper<TooManyRequestsException> {
    @Override
    public Response toResponse(TooManyRequestsException exception) {
        String errorMessage = "Too many requests";

        ApiException apiException = ApiException.builder()
                .type(Constants.MAX_DAILY_QUERIES_CODE)
                .error(errorMessage)
                .message(exception.getMessage())
                .build();

        return Response.status(Response.Status.TOO_MANY_REQUESTS)
                .entity(apiException)
                .build();

    }
}
