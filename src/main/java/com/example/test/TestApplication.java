package com.example.test;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages={"com.example.test"})
@MapperScan("com.example.test.*.*.dao")
@ServletComponentScan
public class TestApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(TestApplication.class, args);
    }

}
