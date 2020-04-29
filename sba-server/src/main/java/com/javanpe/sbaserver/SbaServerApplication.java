package com.javanpe.sbaserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: 微服务监控中心
 * date: 2020-04-26 12:54:48
 * @author: 飞拳
 */
@SpringBootApplication
@EnableAdminServer
@Slf4j
public class SbaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbaServerApplication.class, args);
        log.info("微服务监控中心启动成功");
    }

}
