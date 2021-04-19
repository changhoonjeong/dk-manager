package kr.onekey.dk.controllers;

import kr.onekey.dk.service.ManagerService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping("/manager")
@Controller
public class ManagerController {

    private final Logger logger = LogManager.getLogger(getClass());

    private ManagerService managerService;

    @GetMapping("/userList")
    public String userList(){
        logger.info("userList : ");
        return String.valueOf("");
    }
}
