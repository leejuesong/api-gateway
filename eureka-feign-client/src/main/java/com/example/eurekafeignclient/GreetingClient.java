package com.example.eurekafeignclient;

import com.example.eurekaclient.GreetingController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("spring-cloud-eureka-client")
public interface GreetingClient extends GreetingController {
}
