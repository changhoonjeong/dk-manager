package kr.onekey.dk.service;

import kr.onekey.dk.constant.Constant;
import kr.onekey.dk.constant.MessageConstant;
import kr.onekey.dk.domain.DkManager.DkManager;
import kr.onekey.dk.domain.DkManager.DkManagerRepository;
import kr.onekey.dk.dto.DkManagerLoginDto;
import kr.onekey.dk.util.TimeFormatUtil;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class ManagerService {

    private final Logger logger = LogManager.getLogger(ManagerService.class);

    @Autowired
    private DkManagerRepository managerRepository;

    private HttpSession session;

    public Map<String, Object> login(DkManagerLoginDto dto) {
        Map<String, Object> result = new HashMap<>();

        DkManager manager = managerRepository.findByLoginId(dto.getLoginId());

        if (manager == null) {
            logger.info(MessageConstant.ERROR_MSG_NO_ID);
            throw new RuntimeException(MessageConstant.ERROR_MSG_NO_ID);
        }
        if (manager.getLoginFailCount() >= Constant.LOGIN_FAIL_COUNT){
            logger.info(MessageConstant.ERROR_MSG_BLOCK_LOGIN_COUNT);
            throw new RuntimeException(MessageConstant.ERROR_MSG_BLOCK_LOGIN_COUNT);
        }

        if (manager.getStatus() == Constant.MANAGER_STATUS_REST || manager.getStatus() == Constant.MANAGER_STATUS_STOP){
            logger.info(MessageConstant.ERROR_MSG_BLOCK_LOGIN);
            throw new RuntimeException(MessageConstant.ERROR_MSG_BLOCK_LOGIN);
        }

        // todo :: hash값 추가 하면 수정
        if (!dto.getPassword().equals(manager.getPasswordHash())){
            int failCount = manager.getLoginFailCount();
            manager.setLoginFailCount(failCount + 1);
            if (manager.getLoginFailCount() >= Constant.LOGIN_FAIL_COUNT){
                manager.setStatus(Constant.MANAGER_STATUS_STOP);
            }
            managerRepository.save(manager);

            logger.info(MessageConstant.ERROR_MSG_WRONG_PASSWORD + " 틀린 횟수 " + manager.getLoginFailCount() + " 회");
            throw new RuntimeException(MessageConstant.ERROR_MSG_WRONG_PASSWORD + " 틀린 횟수 " + manager.getLoginFailCount() + " 회");
        }
        updateSession(manager);

        manager.setLastLoginAt(TimeFormatUtil.currentTime());
        manager.setLoginFailCount(0);
        managerRepository.save(manager);

        if(dto.isKeepMeLogin()) {
            String authToken = manager.getLoginId() + "_keepMeLogin";
            result.put("authToken", authToken);
        }

        return result;
    }

    public void updateSession(DkManager manager){
        session.removeAttribute(Constant.LOGIN_SESSION_OBJ);
        session.setAttribute(Constant.LOGIN_SESSION_OBJ, manager);
    }

    public void logout() {
        session.invalidate();
    }
}
