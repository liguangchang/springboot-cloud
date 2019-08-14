package com.jasmine.activemq.activemq;
 
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
/**
 * @author lgc
 */
@Component
public class Consumer {

	/**
	 * 监听队列
	 * @param text
	 */
	@JmsListener(destination = "activemq.queue")
	@SendTo("out.queue")
	public String receiveQueue(String text) {
		System.out.println("Consumer收到的消息为:"+text);
		return "return message";
	}

	@JmsListener(destination = "out.queue")
	public void consumerQueue(String text){
		System.err.println("producer 消费的消息："+text);
	}
}