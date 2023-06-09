package com.example;

import com.example.marketplace.AccessingDataMysqlApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})

public class MarketplaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMysqlApplication .class, args);
    }

}
