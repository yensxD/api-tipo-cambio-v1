package infrastructure.in.rest.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class DocumentNumericValidator implements ConstraintValidator<DocumentNumeric, String> {
    private static final Pattern DNI_PATTERN = Pattern.compile("\\d{8}");

    @Override
    public boolean isValid(String dni, ConstraintValidatorContext constraintValidatorContext) {
        if (dni == null) {
            return true;
        }
        return DNI_PATTERN.matcher(dni).matches();
    }
}
