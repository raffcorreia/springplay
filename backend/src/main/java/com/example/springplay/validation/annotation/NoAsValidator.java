package com.example.springplay.validation.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class NoAsValidator implements ConstraintValidator<NoAs, String> {

    @Override
    public void initialize(NoAs contactNumber) {
    }

    @Override
    public boolean isValid(String message, ConstraintValidatorContext cxt) {
        return isNull(message) || !message.toLowerCase().contains("a");
    }

}
