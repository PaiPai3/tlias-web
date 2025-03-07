package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class TliasWebApplicationTests {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
    }
    @Test
    void contextLoads() {
    }

}
