package com.abdillah.catalog.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abdillah.catalog.service.GreetingService;

@RestController
public class HelloResource {
    Logger log = LoggerFactory.getLogger(HelloResource.class);

    private GreetingService greetingService;

    @Autowired
    public HelloResource(GreetingService greetingService) {
        super();
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        log.info("this is log INFO");
        log.debug("this is log DEBUG");
        log.warn("this is log WARN");
        log.error("this is log ERROR");
        log.trace("this is log TRACE");
        return greetingService.sayGreeting();
    }
}
