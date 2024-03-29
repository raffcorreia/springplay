package com.example.springplay.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebConfigTest {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BASIC_AUTH = "Basic YWRtaW46YWRtaW4=";
    public static final String JWT_AUTH = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGhvcml0aWVzIjoiUk9MRV9BRE1JTiIsImlhdCI6MTYxNzQxOTA4MiwiZXhwIjozMjUwMzY3OTk5OX0.tMWTHmBUYIPA06H5TJMaYadF3xbHRTeGAfjb1OGcsds";

    @Autowired
    private MockMvc mvc;

    private final HttpHeaders httpHeaders;

    public WebConfigTest() {
        httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION_HEADER, BASIC_AUTH);
    }


    @Test
    public void staticContent_js_unauthorized_test() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/js/index.html");

        ResultActions resultAction = this.mvc.perform(requestBuilder);
        resultAction.andExpect(status().isUnauthorized());

        assertTrue(resultAction.andReturn().getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void staticContent_js_JWT_test() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION_HEADER, JWT_AUTH);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/js/index.html").headers(httpHeaders);

        ResultActions resultAction = this.mvc.perform(requestBuilder);
        resultAction.andExpect(status().isOk());

        String contentDirectHit = resultAction.andReturn().getResponse().getContentAsString();
        assertTrue(contentDirectHit.contains("<title>Hello WebSocket</title>"));
    }

    @Test
    public void staticContent_js_test() throws Exception {
        String contentDirectHit = getStrContentResponseFromURL("/js/index.html");
        assertTrue(contentDirectHit.contains("<title>Hello WebSocket</title>"));

        String contentHitPathWithSlash = getStrContentResponseFromURL("/js/");
        assertEquals(contentDirectHit, contentHitPathWithSlash);

        testResponseRedirectURL("/js", "/js/");
    }

    @Test
    public void staticContent_angular_test() throws Exception {
        String contentDirectHit = getStrContentResponseFromURL("/angular/index.html");
        assertTrue(contentDirectHit.contains("<title>Springplay</title>"));
        assertTrue(contentDirectHit.contains("<app-root></app-root>"));

        String contentHitAssets = getStrContentResponseFromURL("/angular/runtime.js");
        assertTrue(contentHitAssets.contains("!function(){"));

        testResponseForwardURL("/angular/xss-experience", "/angular/index.html");
        testResponseForwardURL("/angular/component-test", "/angular/index.html");
        testResponseRedirectURL("/angular/", "/angular/index.html");
        testResponseRedirectURL("/angular", "/angular/index.html");
        testResponseRedirectURL("/", "/angular/index.html");
    }

    private String getStrContentResponseFromURL(String url) throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).headers(httpHeaders);

        ResultActions resultAction = this.mvc.perform(requestBuilder);
        resultAction.andExpect(status().isOk());

        return resultAction.andReturn().getResponse().getContentAsString();
    }

    private void testResponseRedirectURL(String url, String redirectedUrl) throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).headers(httpHeaders);

        ResultActions resultAction = this.mvc.perform(requestBuilder);
        resultAction.andExpect(status().is3xxRedirection());
        resultAction.andExpect(redirectedUrl(redirectedUrl));
    }

    private void testResponseForwardURL(String url, String forwardedURL) throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).headers(httpHeaders);

        ResultActions resultAction = this.mvc.perform(requestBuilder);
        resultAction.andExpect(status().isOk());
        resultAction.andExpect(forwardedUrl(forwardedURL));
    }
}
