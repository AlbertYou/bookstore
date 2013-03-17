package com.albert.bs.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 订单号生成器
 * 
 * @author Albert
 * @version V1.0 2012-04-19
 * @since JDK5.0
 */
public class OrderNumberCreator {

	public String produce() {
		StringBuffer number = new StringBuffer("A");
		SimpleDateFormat y = new SimpleDateFormat("yy");
		SimpleDateFormat m = new SimpleDateFormat("MM");
		SimpleDateFormat d = new SimpleDateFormat("dd");
		Random r = new Random();
		Date now = new Date();
		int i;
		i = r.nextInt(9);
		number.append(i);
		number.append(y.format(now));
		i = r.nextInt(9);
		number.append(i);
		number.append(m.format(now));
		i = r.nextInt(9);
		number.append(i);
		number.append(d.format(now));
		i = r.nextInt(9999);
		number.append(i);
		return number.toString();
	}
	
}
