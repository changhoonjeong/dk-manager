package kr.onekey.dk.service;

import kr.onekey.dk.domain.DkUser.DkUser;
import kr.onekey.dk.domain.DkUser.DkUserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DeviceServiceTest {

    private final Logger logger = LogManager.getLogger(DeviceServiceTest.class);

    @Autowired
    DkUserRepository userRepository;

    @Test
    void opnerListTest() {
//        String userId = "us0000000001";
//        List<DkUser> list = userRepository.getUserAll();
        List<DkUser> list = userRepository.findByStatus(1);

        for (DkUser obj : list){
            System.out.println("DkUser... : " + obj);
        }
    }
}