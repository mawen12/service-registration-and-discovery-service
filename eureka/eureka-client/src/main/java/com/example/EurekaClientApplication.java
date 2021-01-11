package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mw118
 * @version 1.0
 * @date 2021/1/8 22:29
 */

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}

@RestController
@Slf4j
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @GetMapping("/serviceUrl")
    public String serviceUrl() {
        List<String> services = discoveryClient.getServices();
        log.info("services is {}", services);

        services.forEach(applicationName -> {
            List<ServiceInstance> serviceInstances = this.serviceInstancesByApplicationName(applicationName);
            log.info("Uri is {}" , serviceInstances.get(0).getUri());
        });

        return "OK";
    }

}
