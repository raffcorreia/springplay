package com.example.springplay.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/experience/validation")
public class ValidationController {

    @Autowired
    ValidationService validationService;

    @RequestMapping(value = "/requestObject", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ValidationResponse validateRequestObject(@Valid  @RequestBody ValidationRequest requestObj) {
        return validationService.validateRequestObject(requestObj);
    }
}
