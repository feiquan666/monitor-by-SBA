package com.javanpe.eurekaserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * description: Eureka注册中心
 * date: 2020-04-26 11:52:38
 * @author: 飞拳
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
        log.info("Eureka注册中心启动成功");
    }

}
