package com.example.springplay.banner;

import com.example.springplay.banner.metadata.BannerMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/api/experience/banner")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @RequestMapping(value = "/postBanner", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public BannerMetadata postBanner(@RequestBody Map<String, Object> parameters) {
        return bannerService.postBanner(parameters);
    }
}
