package org.rabbitmq.demo3.consumer.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import com.rabbitmq.client.Channel;


/**
 * 消息到达消费者监听类
 */
public class MessageConsumer implements ChannelAwareMessageListener {
	/**
	 * 处理收到的rabbit消息的回调方法。
	 * @param message AMQP封装消息对象
	 * @param channel 信道对象，可以进行确认回复
	 * @throws Exception Any.
	 */
	public void onMessage(Message message, Channel channel) throws Exception {
		try {
			String srt2=new String(message.getBody(),"UTF-8");
			System.out.println("消费者收到消息："+srt2);
			//成功应答
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		} catch (Exception e) {
			e.printStackTrace();
			//失败应答
			channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
		}
	}
}
