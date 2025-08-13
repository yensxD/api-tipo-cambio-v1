package infrastructure.in.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiException {
    private String error;
    private String type;
    private String message;
}
