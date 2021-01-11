package com.mawen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author mw118
 * @version 1.0
 * @date 2021/1/10 22:44
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerPeerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerPeerApplication.class, args);
    }
}
