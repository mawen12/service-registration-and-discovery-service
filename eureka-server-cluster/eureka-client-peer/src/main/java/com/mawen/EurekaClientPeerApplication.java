package com.mawen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author mw118
 * @version 1.0
 * @date 2021/1/11 8:09
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientPeerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientPeerApplication.class, args);
    }
}
