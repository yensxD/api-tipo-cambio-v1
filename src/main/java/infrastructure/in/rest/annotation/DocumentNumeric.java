package infrastructure.in.rest.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = DocumentNumericValidator.class)
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface DocumentNumeric {
    String message() default "El formato del DNI es inválido. Por favor, ingrese un DNI válido de 8 dígitos numéricos.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
