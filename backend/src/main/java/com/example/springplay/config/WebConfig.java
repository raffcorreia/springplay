package com.example.springplay.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;

/**
 * With this WebMvcConfigurer there are multiple types of redirection for your tasting
 *
 * addViewControllers -> adding redirect view and forwarding the controller
 *
 * addResourceHandlers -> Custom handle all reuqest to a folder
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers (ViewControllerRegistry registry) {
        registry.addRedirectViewController("/js", "/js/");
        registry.addRedirectViewController("/", "/angular/index.html");
        registry.addRedirectViewController("/angular", "/angular/index.html");
        registry.addRedirectViewController("/angular/", "/angular/index.html");
        registry.addViewController("/angular/{path:[^.]*}").setViewName("forward:/angular/index.html");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/js/", "/js/**")
                .addResourceLocations("classpath:/static/js/")
                .resourceChain(true)
                .addResolver(new PathResourceResolver() {
                    @Override
                    protected Resource getResource(String resourcePath, Resource location) throws IOException {
                        Resource requestedResource = location.createRelative(resourcePath);
                        return requestedResource.exists() && requestedResource.isReadable()
                                ? requestedResource
                                : new ClassPathResource("/static/js/index.html");
                    }
                });
    }
}
