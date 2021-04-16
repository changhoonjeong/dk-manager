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
@RequestMapping("/manager")
public class DeviceController {

    private final Logger logger = LogManager.getLogger(DeviceController.class);

    @Autowired
    DeviceService deviceService;

    @GetMapping("/openerList")
    public String openerList() {
        logger.info("openerList : ");
        return String.valueOf(deviceService);
    }

}
