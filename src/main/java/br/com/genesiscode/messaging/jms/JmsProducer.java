package br.com.genesiscode.messaging.jms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class JmsProducer {

	public JmsTemplate jmsTemplate;
	
	@Value("${active-mq.topic}")
	private String topic;
	
	public void sendMessage(String message) {
		
		try {
			log.info("Sending message...");
			jmsTemplate.send(topic, s  -> s.createTextMessage(message));
		} catch (Exception e) {
			log.error("Error = ${}", e);
		}
	}
}
