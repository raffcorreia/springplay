package com.example.springplay.xss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class XssController {

    @Autowired
    XssService xssService;

    @RequestMapping(value = "/getXSS", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public List<XssEntity> getList() {
        return xssService.getList();
    }

    @RequestMapping(value = "/getXSS/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public XssEntity getById(@PathVariable Long id) {
        return xssService.getById(id);
    }

    @RequestMapping(value = "/postXSS", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public XssEntity postXSS(@RequestBody XssEntity xssEntity) {
        return xssService.postXSS(xssEntity);
    }

    @RequestMapping(value = "/putXSS", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public XssEntity putXSS(@RequestBody XssEntity xssEntity) {
        return xssService.putXSS(xssEntity);
    }

    @RequestMapping(value = "/delXSS/{id}", method = RequestMethod.DELETE
    )
    @ResponseBody
    public void putXSS(@PathVariable Long id) {
        xssService.deleteById(id);
    }
}
