package com.albert.bs.util;

import java.util.Random;

/**
 * 密码生成器
 * 
 * @author Albert
 * @version V1.0 2012-04-19
 * @since JDK5.0
 */
public class PasswordCreator {

	private static final Integer PASSWORD_AMOUNT = 6;
	private static final char[] randomSequence = new char[] {
		'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};

	public static String newPassword() {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < PASSWORD_AMOUNT; i++) {
			int index = random.nextInt(35);
			String strRand = String.valueOf(randomSequence[index]);
			sb.append(strRand);
		}
		return sb.toString();
	}
	
}
