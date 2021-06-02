package com.example.springplay.validation;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ValidationResponse {
    private Instant timestamp;
    private String value;
}
