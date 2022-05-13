package com.example.springplay.validation;

import com.example.springplay.validation.annotation.NoAs;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public record ValidationRequest(
    @NotBlank(message = "Name can't be blank")
    String name,

    @NotNull(message = "Role can't be null")
    String role,

    @Email(message = "Email is not valid")
    String email,

    @Min(value = 18, message = "Age should not be less than 18")
    Integer age,

    @Size(min = 10, max = 200, message = "Message should be between 10 and 200 characters")
    String message,

    @AssertTrue(message = "This resource is exclusive for FTEs")
    boolean fullTimeEmloyee,

    @Min(value = 100_000, message = "You have to make at lease $100.000 to access this resource")
    @Max(value = 500_000, message = "You can't make more then $500.000 to access this resource")
    Integer wage,

    @Past(message = "Birth date must be in the past")
    Date birthDate,

    @Future(message = "Expire date must be in the future")
    Date expireDate,

    @NotNull(message = "Project names can't be null")
    List<String> projectNames,

    @Valid
    @NotNull(message = "Contacts can't be null")
    List<@NotNull Contact> contacts,

    @NoAs
    String noLetterAmessage,

    @NotNull(message = "You have to choose a valid prime number.")
    BigInteger primeNumber
) {
    public ValidationRequest {
        PrimeNumberUtil primeNumberUtil = new PrimeNumberUtil();
        if(!primeNumberUtil.isPrime(primeNumber)) {
            throw new IllegalArgumentException("The number (" + primeNumber + ") is not prime.");
        }
    }


}
