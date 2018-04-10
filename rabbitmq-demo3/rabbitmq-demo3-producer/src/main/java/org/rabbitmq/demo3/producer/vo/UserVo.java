package org.rabbitmq.demo3.producer.vo;

import java.util.UUID;

/**
 * 消息体
 * @author itw_wangzhao
 */
public class UserVo {
	
	private String userName;
	
	private String userAge;
	
	private String userAdress;
	
	private String userId;
	
	public UserVo(){
		userId = UUID.randomUUID().toString();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getUserAdress() {
		return userAdress;
	}

	public void setUserAdress(String userAdress) {
		this.userAdress = userAdress;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
