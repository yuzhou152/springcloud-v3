package com.example.springcloudclientfeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.example.springcloudserviceapi.feignservice.HelloService;

/**
 * Feign继承特性
 */
@FeignClient(value = "consumerserver")
public interface RefactorHelloService extends HelloService{

}
