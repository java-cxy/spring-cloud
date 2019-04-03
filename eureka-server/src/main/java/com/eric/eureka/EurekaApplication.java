package com.eric.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description eureka服务注册与发现启动
 * EnableEurekaServer使用这个注解标注为eureka的服务
 *
 * @Date 2019/4/2 16:51
 * @Author LSM
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {

        SpringApplication.run(EurekaApplication.class,args);
    }
}
