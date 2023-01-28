package com.abdillah.catalog.service.impl;

import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.abdillah.catalog.config.ApplicationProperties;
import com.abdillah.catalog.config.CloudProperties;
import com.abdillah.catalog.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

    private ApplicationProperties appProperties;

    private CloudProperties cloudProperties;

    public GreetingServiceImpl(ApplicationProperties appProperties, CloudProperties cloudProperties) {
        super();
        this.appProperties = appProperties;
        this.cloudProperties = cloudProperties;
    }

    @Override
    public String sayGreeting() {
        System.out.println("CLOUD API KEY " + cloudProperties.getApiKey());

        TimeZone timezone = TimeZone.getTimeZone(appProperties.getTimezone());

        return appProperties.getWelcomeText() + ", our timezone = " + timezone.getDisplayName() + ", our currency = "
                + appProperties.getCurrency();
    }

}
