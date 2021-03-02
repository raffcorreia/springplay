package com.example.springplay.xss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static org.springframework.web.client.HttpClientErrorException.*;

@Service
public class XssService {

    @Autowired
    XssRepository xssRepository;

    public List<XssEntity> getList() {

        List<XssEntity> resp = xssRepository.findAll();

        return resp;
    }

    public XssEntity getById(Long id) {
        return xssRepository.findById(id).orElse(null);
    }

    public XssEntity postXSS(XssEntity xssEntity) {
        xssEntity.setId(null);
        return xssRepository.save(xssEntity);
    }

    public XssEntity putXSS(XssEntity xssEntity) {

        if(isNull(xssEntity) || isNull(xssEntity.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required fields");
        }

        if(xssRepository.findById(xssEntity.getId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found to be updated");
        }

        return xssRepository.save(xssEntity);
    }

    public void deleteById(Long id) {
        xssRepository.deleteById(id);
    }

}
