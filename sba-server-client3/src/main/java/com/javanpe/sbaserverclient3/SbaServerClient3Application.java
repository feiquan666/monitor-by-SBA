package com.javanpe.sbaserverclient3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: 第三个示例客户端
 * date: 2020-04-26 13:40:43
 * @author: 飞拳
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SbaServerClient3Application {

    public static void main(String[] args) {
        SpringApplication.run(SbaServerClient3Application.class, args);
    }

}
