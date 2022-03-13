package br.com.genesiscode.messaging.producer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.genesiscode.messaging.jms.JmsProducer;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@NoArgsConstructor
@Slf4j
public class ProduceMessageController {

	private JmsProducer jmsProducer;
	
	@PostMapping(value = "/api/message")
	public String sendMessage(@RequestBody String message) {
		jmsProducer.sendMessage(message);
		log.info("Receiving message = {}", message);
		return message;
	}
	
}
