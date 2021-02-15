package com.juri.XNXGAMES.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("live")
@EnableEurekaClient
@Configuration
public class EurekaConfiguration {

}
