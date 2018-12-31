package com.example.eurekaclient;

import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;
import sun.security.krb5.internal.HostAddress;

import javax.annotation.PostConstruct;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableDiscoveryClient
public class EurekaClientApplication implements GreetingController {

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    private static final Logger logger = LoggerFactory.getLogger(EurekaClientApplication.class);

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String portNumber;

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }


    @Override
    public String greeting() {
        String hostIp;
        try {
            HostAddress hostAddress = new HostAddress();
            hostIp = hostAddress.getInetAddress().toString();
            return String.format("Hello from '%s with Port Number %s on ip addr %s'!", eurekaClient.getApplication(appName)
                    .getName(), portNumber, hostIp);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return String.format("Hello from '%s with Port Number %s on ip addr %s'!", eurekaClient.getApplication(appName)
                .getName(), portNumber, "-1");
    }
}

