package com.example.springplay.validation;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ValidationRequest {

    @NotBlank(message = "Name can't be blank")
    private String name;

    @NotNull(message = "Role can't be null")
    private String role;

    @Email(message = "Email is not valid")
    private String email;

    @Min(value = 18, message = "Age should not be less than 18")
    private Integer age;

    @Size(min = 10, max = 200, message = "Message should be between 10 and 200 characters")
    private String message;

    @AssertTrue(message = "This resource is exclusive for FTEs")
    private boolean fullTimeEmloyee;

    @Min(value = 100_000, message = "You have to make at lease $100.000 to access this resource")
    @Max(value = 500_000, message = "You can't make more then $500.000 to access this resource")
    private Integer wage;

    @Past(message = "Birth date must be in the past")
    private Date birthDate;

    @Future(message = "Expire date must be in the future")
    private Date expireDate;

    @NotNull(message = "Project names can't be null")
    private List<String> projectNames;

    @Valid
    @NotNull(message = "Contacts can't be null")
    private List<@NotNull Contact> contacts;
}
