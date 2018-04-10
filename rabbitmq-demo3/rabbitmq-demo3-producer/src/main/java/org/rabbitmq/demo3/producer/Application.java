package org.rabbitmq.demo3.producer;

import java.io.IOException;

import org.rabbitmq.demo3.producer.service.UserInfoService;
import org.rabbitmq.demo3.producer.vo.UserVo;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:springmvc.xml");
        context.start();

        System.out.println("rabbitmq-producer start...");
       
        UserInfoService userInfoService = context.getBean(UserInfoService.class);

		UserVo user = new UserVo();
		user.setUserAdress("111");
		user.setUserName("222");
		user.setUserAge("33");
		
		userInfoService.sendMsgInfo2DefaultExg(user,new CorrelationData("111"));

        try {
            System.in.read();   // 按任意键退出
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
	
}
