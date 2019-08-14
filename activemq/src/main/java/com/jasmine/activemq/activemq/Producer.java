package com.jasmine.activemq.activemq;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
 
/**
 * @author lgc
 */
@Service("producer")
public class Producer {
	@Autowired
	private JmsMessagingTemplate jmsTemplate;

	public void sendMessage(Destination destination, final String message){
		jmsTemplate.convertAndSend(destination, message);
	}
}