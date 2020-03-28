package com.akgcloud.activemq.springbootactivemq;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

	@Autowired
	JmsTemplate jmsTemplate;

	@Autowired
	Queue queue;

	@RequestMapping("/{message}")
	public String publish(@PathVariable("message") final String message) {
		System.out.println("Message published : " + message);
		jmsTemplate.convertAndSend(queue, message);
		System.out.println("Done");
		return "message published";
	}
}
