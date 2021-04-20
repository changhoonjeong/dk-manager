package kr.onekey.dk.service;

import kr.onekey.dk.constant.Constant;
import kr.onekey.dk.domain.DkManager.DkManager;
import kr.onekey.dk.domain.DkManager.DkManagerRepository;
import kr.onekey.dk.dto.DkManagerLoginDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ManagerServiceTest {

    private final Logger logger = LogManager.getLogger(DeviceServiceTest.class);

    @Autowired
    ManagerService managerService;

    @Autowired
    DkManagerRepository managerRepository;

    @Autowired
    private HttpSession session;

    @Test
    void managerLoginTest(){

        DkManagerLoginDto dto = new DkManagerLoginDto();
        dto.setLoginId("jaja3");
        dto.setPassword("password123");

        DkManager manager = managerRepository.findByLoginId(dto.getLoginId());
        logger.info("manager... : " + (manager == null));

        try {
            Map<String, Object> loginResult = managerService.login(dto);
            logger.info("로그인 성공");
        } catch ( Exception e ) {
            logger.info("로그인 실패");
        }

        assertTrue(checkSession());

        logoutTest();

        assertFalse(checkSession());
    }


    boolean checkSession(){
        DkManager manager = (DkManager) session.getAttribute(Constant.LOGIN_SESSION_OBJ);
        if (manager == null){
            logger.info("session is null...");
            return false;
        } else {
            logger.info("manager is : " + manager);
            return true;
        }
    }

    void logoutTest(){
        managerService.logout();
    }
}