package org.rabbitmq.demo3.producer.common;

import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
/**
 * confirm确认回调方法
 */
public class ConfirmReturnBack implements ConfirmCallback{

	/**
	 * Confirmation callback.
	 * @param correlationData 回调的相关数据.
	 * @param ack true for ack, false for nack
	 * @param cause 专门给NACK准备的一个可选的原因，其他情况为null。
	 */
	public void confirm(CorrelationData correlationdata, boolean ack, String cause) {
		/**
		 * CorrelationData 是在发送消息时传入回调方法的参数，可以用于区分消息对象。
		 * CorrelationData对象中只有一个属性 String id。
		 * 通过这个参数，我们可以区分当前是发送哪一条消息时的回调，并通过ack参数来进行失败重发功能。
		 */
		 System.out.println("Exchange接收是否成功（ack）: " + ack + "。 返回的用户参数（correlationData）: " + correlationdata + "。NACK原因（cause） : " + cause);
	}
}
