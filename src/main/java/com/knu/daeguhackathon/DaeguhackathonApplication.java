package com.knu.daeguhackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DaeguhackathonApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaeguhackathonApplication.class, args);
    }

}
