package com.example.springplay.validation;

import com.example.springplay.validation.ValidationResponse.ValidationResponseBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ValidationService {


    public ValidationResponse validateRequestObject(ValidationRequest requestObj) {
        ValidationResponseBuilder response = ValidationResponse.builder();
        response.timestamp(Instant.now());

        ObjectMapper om = new ObjectMapper();
        try {
            response.value(om.writeValueAsString(requestObj));
        } catch (JsonProcessingException e) {
            response.value("Error converting request to string");
            e.printStackTrace();
        }

        return response.build();
    }
}
