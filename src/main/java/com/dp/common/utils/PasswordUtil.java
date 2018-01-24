package com.dp.common.utils;

import java.util.Random;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 密码相关的工具类
 * 
 * @author j01441
 *
 */
public class PasswordUtil {
	/**
	 * 加密参数与shiro配置文件一一对应 加密循环次数
	 */
	public static final int hashIterations = 1;
	/**
	 * 加密参数与shiro配置文件一一对应 加密方式
	 */
	public static final String hashAlgorithmName = "MD5";

	/**
	 * 盐值加密
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	public static Object encrypt(String password, String salt) {
		Object salts = null;
		if(salt != null){
			salts = ByteSource.Util.bytes(salt);
		}
		return new SimpleHash(hashAlgorithmName, password, salts, hashIterations);
	}

	public static String getPassword() {
		return genRandomNum(8);
	}

	/**
	 * 生成随机密码
	 *
	 * @param pwd_len
	 *            生成的密码的总长度
	 * @return 密码的字符串
	 */
	public static String genRandomNum(int pwd_len) {
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'w', 'x', 'y', 'z', '2', '3', '4', '5', '6', '7', '8', '9' };
		int maxNum = str.length;
		StringBuffer pwd = new StringBuffer();
		Random r = new Random();
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，
			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1
			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}
}
