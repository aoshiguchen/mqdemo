package org.rabbitmq.demo3.producer.common;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
/**
 * 实现此方法在basicpublish失败时回调
 * 相当于 ReturnListener的功能。
 * 在发布消息时设置mandatory等于true，
 * 监听消息是否有相匹配的队列，没有时ReturnCallback将执行returnedMessage方法，消息将返给发送者 
 */
public class MyReturnCallback implements ReturnCallback {

	public void returnedMessage(Message message, int replyCode, String replyText, 
			String exchange, String routingKey) {
		System.out.println("------------");
		try {
			System.out.println("消息发送进指定队列失败：失败原因（+replyText）："+replyText
					+";错误代码（replyCode）："+replyCode
					+";消息对象："+new String(message.getBody(),"UTF-8")
					+"exchange:"+exchange
					+"routingKey:"+routingKey);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("------------");
	}

}
