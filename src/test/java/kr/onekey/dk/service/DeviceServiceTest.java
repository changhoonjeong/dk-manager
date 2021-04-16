package kr.onekey.dk.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeviceServiceTest {

    private final Logger logger = LogManager.getLogger(DeviceServiceTest.class);

    @Test
    void opnerListTest() {
        int a = 3;
        int b = 4;
        assertEquals(7, a + b);
    }
}