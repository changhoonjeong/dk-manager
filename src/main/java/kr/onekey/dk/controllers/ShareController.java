package kr.onekey.dk.controllers;

import kr.onekey.dk.service.DeviceService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/share")
public class ShareController {

    private final Logger logger = LogManager.getLogger(ShareController.class);

    @Autowired
    DeviceService deviceService;

    @GetMapping("/create")
    public String create() {
        logger.info("create : ");
        return "";
    }

}
