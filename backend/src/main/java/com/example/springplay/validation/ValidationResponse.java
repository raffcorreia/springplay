package com.example.springplay.validation;

import lombok.Builder;

import java.time.Instant;

@Builder
public record ValidationResponse(Instant timestamp, String value) {
}
