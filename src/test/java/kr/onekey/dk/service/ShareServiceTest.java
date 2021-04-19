package kr.onekey.dk.service;

import kr.onekey.dk.domain.DkDevice.DkDevice;
import kr.onekey.dk.domain.DkDevice.DkDeviceRepository;
import kr.onekey.dk.domain.DkShare.DkShare;
import kr.onekey.dk.domain.DkShare.DkShareRepository;
import kr.onekey.dk.domain.DkShareOpener.DkShareOpener;
import kr.onekey.dk.domain.DkShareOpener.DkShareOpenerRepository;
import kr.onekey.dk.util.TimeFormatUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ShareServiceTest {

    private final Logger logger = LogManager.getLogger(DeviceServiceTest.class);

    @Autowired
    DkShareRepository shareRepository;
    @Autowired
    DkDeviceRepository deviceRepository;
    @Autowired
    DkShareOpenerRepository shareOpenerRepository;

    @Test
    void createShareTest() {
        int status = 1;

        String deviceId = "dv0000000001";

        DkDevice dkDevice = deviceRepository.findByIdAndStatus(deviceId, status);
        if (dkDevice == null) {
            logger.info("사용가능한 opener가 아닙니다.");
        }

        String sender = "us0000000001";
        String receiver = "us0000000002";
        Date startAt = TimeFormatUtil.stringToDateTime("2021-04-19 15:30:00");
        Date endAt = TimeFormatUtil.stringToDateTime("2021-04-20 15:30:00");

        DkShare dkShare = shareRepository.findBySenderAndReceiverAndStatus(sender, receiver, status);
        //없으면 생성, 있으면 삭제하고 새로 create
        if (dkShare == null){
            dkShare = DkShare.builder()
                    .id("sh0000000001") // id 관련 테이블을 가져와서 get 할 수 있게 처리 해야함 우선 임시로 데이터 넣기
                    .sender("us0000000001")
                    .receiver("us0000000002")
                    .startAt(startAt)
                    .endAt(endAt)
                    .status(status)
                    .build();
            shareRepository.save(dkShare);

            createShareOpener(dkShare.getId(), dkDevice.getId());

            logger.info("share create... :");
        } else {
            dkShare.setStatus(2);
            shareRepository.save(dkShare);

            logger.info("share update...");
            createShareTest();
        }

        logger.info("dkShare... : " + dkShare);
    }

    @Test
    void createShareOpener(String shareId, String openerId){

        int status = 1;

        DkShareOpener shareOpener = DkShareOpener.builder()
                .id("so0000000001")
                .openerId(openerId)
                .shareId(shareId)
                .status(status)
                .build();
        shareOpenerRepository.save(shareOpener);

        logger.info("createShareOpener create... : " + shareOpener);
    }
}