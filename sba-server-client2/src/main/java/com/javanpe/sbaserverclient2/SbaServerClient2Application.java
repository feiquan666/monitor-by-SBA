package com.javanpe.sbaserverclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: 第二个示例客户端
 * date: 2020-04-26 13:36:25
 * @author: 飞拳
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SbaServerClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(SbaServerClient2Application.class, args);
    }

}
