package kr.onekey.dk.service;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeviceService {

    private final Logger logger = LogManager.getLogger(DeviceService.class);

    public JSONObject opnerList(){
        JSONObject jsonObject = new JSONObject();


        return jsonObject;
    }
}
