package br.com.genesiscode.messaging.jms;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JmsConsumer implements MessageListener {

	@Override
	@JmsListener(destination = "${active-mq.topic}")
	public void onMessage(Message message) {
		try {
			ObjectMessage objMessage = (ObjectMessage) message;
			String messageString = (String) objMessage.getObject();
			
			log.info("Message received succefully = {}", messageString);
		} catch (Exception e) {
			log.error("Error on receive message = {}", e);
		}
	}

}
