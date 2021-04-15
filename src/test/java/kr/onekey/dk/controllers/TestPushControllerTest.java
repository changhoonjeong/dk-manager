package kr.onekey.dk.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
public class TestPushControllerTest {
    
    @Autowired
    private TestPushController testPushController;

    private final Logger logger = LogManager.getLogger(TestPushControllerTest.class);

    private MockMvc mockMvc;

    @Test
    public void push() {
      logger.info(testPushController.test());
      
      assertEquals("test", testPushController.test());
    }
}

