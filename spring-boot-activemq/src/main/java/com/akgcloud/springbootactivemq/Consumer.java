package com.akgcloud.springbootactivemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer{

	@JmsListener(destination = "test.queue")
	public void consume(String message) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Message received : " + message);
	}

//	@Override
//	public void onMessage(Message message) {
//		try {
//			Thread.sleep(10000);
//			TextMessage msg = (TextMessage) message;
//			System.out.println("Message Recieved : " + msg.getText());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
