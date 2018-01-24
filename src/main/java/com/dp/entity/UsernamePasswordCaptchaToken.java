package com.dp.entity;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.hibernate.validator.constraints.NotEmpty;

public class UsernamePasswordCaptchaToken extends UsernamePasswordToken{
	
	private static final long serialVersionUID = -6485016369306971600L;
	
	/**
	 * 验证码
	 */
	@NotEmpty(message="{error.captcha}")
	private String captcha;

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public UsernamePasswordCaptchaToken() {
		super();

	}
	
	public UsernamePasswordCaptchaToken(String username ,String password ,String captcha){
		super(username, password);
		this.captcha = captcha;
	}

}
