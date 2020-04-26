package com.javanpe.sbaserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: 微服务监控中心
 * date: 2020-04-26 12:54:48
 * @author: 飞拳
 */
@SpringBootApplication
@EnableAdminServer
public class SbaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbaServerApplication.class, args);
    }

}
