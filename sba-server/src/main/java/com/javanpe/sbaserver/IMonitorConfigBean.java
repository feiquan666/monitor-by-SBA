package com.javanpe.sbaserver;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * description: 监控程序配置
 * date: 2020-04-28 14:21:11
 * @author: 飞拳
 */
@Data
@Component
@ConfigurationProperties("imonitor")
public class IMonitorConfigBean {
    private boolean stop;
    private String user;
}
