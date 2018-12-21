package com.april.house.cloud.monitor.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MonitorEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorEurekaServerApplication.class, args);
    }

}

