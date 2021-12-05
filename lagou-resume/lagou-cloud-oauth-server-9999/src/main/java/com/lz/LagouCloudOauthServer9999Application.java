package com.lz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LagouCloudOauthServer9999Application {

    public static void main(String[] args) {
        SpringApplication.run(LagouCloudOauthServer9999Application.class, args);
    }

}
