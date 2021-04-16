package kr.onekey.dk.publishers;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.firebase.messaging.Message.Builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class PushPublisher {

  private final Logger logger = LogManager.getLogger(PushPublisher.class);

  public String sendFCMMesage(String registrationToken, String title, String body) {
    String response = "";

    try{
      Builder msgBuilder = Message.builder();
      msgBuilder.setNotification(Notification.builder()
        .setTitle(title)
        .setBody(body)
        .build());
      Message msg = msgBuilder.setToken(registrationToken).build();
      response = FirebaseMessaging.getInstance().send(msg);
      return response;
    } catch (FirebaseMessagingException e) {
      logger.error(e.getMessage());
    }

    return response;
  }
}
