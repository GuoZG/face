package com.sft.face.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class OrderIdUtil {

	public static void main(String[] args) {
		System.out.println(getOrderId());
	}
	
	/**
	 * 
	* @Title: getOrderId  
	* @Description:生成订单编号 当前时间+6位随机数
	* @return String
	* @author GuoZG     
	* @throws
	 */
	public static String getOrderId() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String d=df.format(new Date());
		String id=d.replace("-",""); 
		String id2=id.replace(":",""); 
		String orderid1=id2.replace(" ",""); 
		Integer orderid2=(int)((Math.random()*9+1)*100000);
		return orderid1+orderid2;
	}

	public static String ImgId() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String d=df.format(new Date());
		String id=d.replace("-",""); 
		String id2=id.replace(":",""); 
		String orderid1=id2.replace(" ",""); 
		return orderid1;
	}
}
