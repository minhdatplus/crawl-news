package com.bkhn.crawl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class CrawlApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrawlApplication.class, args);
    }

}
