package com.javanpe.sbaserverclient1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: 第一个示例客户端
 * date: 2020-04-26 13:01:07
 * @author: 飞拳
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SbaServerClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(SbaServerClient1Application.class, args);
    }

}
