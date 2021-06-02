package com.example.springplay.validation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ValidationService {


    public ValidationResponse validateRequestObject(ValidationRequest requestObj) {
        ValidationResponse response = new ValidationResponse();
        response.setTimestamp(Instant.now());

        ObjectMapper om = new ObjectMapper();
        try {
            response.setValue(om.writeValueAsString(requestObj));
        } catch (JsonProcessingException e) {
            response.setValue("Error converting request to string");
            e.printStackTrace();
        }

        return response;
    }
}
