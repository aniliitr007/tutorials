package com.akgcloud.springbootjms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consumer implements MessageListener {
	private Logger log = LoggerFactory.getLogger(Consumer.class);

	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage msg = (TextMessage) message;
				log.info("Received text message: " + msg.getText());
			} else {
				log.info("Received customer message: " + message.getBody(Customer.class));
			}
		} catch (JMSException ex) {
			ex.printStackTrace();
		}
	}
}