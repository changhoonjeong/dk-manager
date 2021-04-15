package kr.onekey.dk.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TestPushController {

    private final Logger logger = LogManager.getLogger(TestPushController.class);

    @PostMapping("/test")
    public String test() {
        logger.info("/test");
        return "test";
    }
}