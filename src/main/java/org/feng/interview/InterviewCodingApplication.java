package org.feng.interview;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.feng.interview.transaction.mapper")
public class InterviewCodingApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterviewCodingApplication.class, args);
    }

}
