package org.rabbitmq.demo3.producer.service;

import org.springframework.amqp.rabbit.support.CorrelationData;

public interface UserInfoService {

	/**
	 * 发送消息到默认的交换机和队列
	* @param messageObject 消息对象
	* @return boolean 返回类型 
	 */
	public boolean sendMsgInfo2DefaultExg(Object messageObject,CorrelationData correlationdata);
	
	/**
	 * 发送消息到指定的队列
	* @param queue           队列名称
	* @param messageObject   消息对象
	* @return boolean 返回类型 
	 */
	public boolean sendMsgInfo2Exg(String queue,Object messageObject,CorrelationData correlationdata);

	/**
	 * 发送消息到指定的交换机和队列
	* @param exchange       交换机名称
	* @param queue          队列名称
	* @param messageObject  消息对象
	* @return void 返回类型 
	 */
	public boolean sendmsg2exgQueue(String exchange,String queue,Object messageObject,CorrelationData correlationdata);
}