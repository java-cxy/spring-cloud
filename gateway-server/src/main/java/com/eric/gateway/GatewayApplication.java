package com.eric.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description API网关zuul启动类
 * SpringCloudApplication这里是spring cloud实现的网关
 * EnableZuulProxy开启zuul代理
 * @Date 2019/4/3 16:14
 * @Author LSM
 **/
@SpringCloudApplication
@EnableZuulProxy
public class GatewayApplication {

    public static void main(String[] args) {

        SpringApplication.run(GatewayApplication.class,args);
    }
}
