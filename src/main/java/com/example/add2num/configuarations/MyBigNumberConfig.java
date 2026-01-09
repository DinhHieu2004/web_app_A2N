package com.example.add2num.configuarations;


import add2Num.MyBigNumber; // Import class từ file JAR
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBigNumberConfig {
    @Bean
    public MyBigNumber myBigNumber() {
        return new MyBigNumber();
    }

}
