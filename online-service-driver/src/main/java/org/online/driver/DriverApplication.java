package org.online.driver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"org.online.common","org.online.driver"})
@EnableDiscoveryClient
@MapperScan("org.online.driver.mapper")
@EnableFeignClients(basePackages = {"org.online.api.feign"})
public class DriverApplication {
    public static void main(String[] args) {
        SpringApplication.run(DriverApplication.class);
    }
}
