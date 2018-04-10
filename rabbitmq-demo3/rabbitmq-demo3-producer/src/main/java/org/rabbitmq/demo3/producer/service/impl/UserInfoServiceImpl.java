package org.rabbitmq.demo3.producer.service.impl;

import org.rabbitmq.demo3.producer.service.UserInfoService;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public boolean sendMsgInfo2DefaultExg(Object messageObject,CorrelationData correlationdata) {
		try {
			rabbitTemplate.correlationConvertAndSend(messageObject,correlationdata);
			return true;
		} catch (AmqpException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean sendMsgInfo2Exg(String queue, Object messageObject,CorrelationData correlationdata) {
		try {
			rabbitTemplate.convertAndSend(queue, messageObject,correlationdata);
			return true;
		} catch (AmqpException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean sendmsg2exgQueue(String exchange, String queue, Object messageObject,CorrelationData correlationdata) {
		try {
			rabbitTemplate.convertAndSend(exchange, queue, messageObject,correlationdata);
			return true;
		} catch (AmqpException e) {
			e.printStackTrace();
			return false;
		}
	}
}