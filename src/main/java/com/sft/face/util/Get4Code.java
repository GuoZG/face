package com.sft.face.util;

import java.util.Random;

public class Get4Code {
	public static  String get4Code(){//优惠劵随机
	    StringBuffer sb = new StringBuffer();
	    String codes ="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
	    Random random = new Random();
	    for(int i=0;i<codes.length();i++){
	      char c = codes.charAt(random.nextInt(codes.length()));
	      if(sb.length()==8) {
	      	break;
		  }
	      if(!sb.toString().contains(c+"")) {
	      	sb.append(c);
		  }
	    }
    return sb.toString();
  }
	
	public static  String randomCode(int s){
	    StringBuffer sb = new StringBuffer();
	    String codes ="1234567890";
	    Random random = new Random();
	    for(int i=0;i<codes.length();i++){
	      char c = codes.charAt(random.nextInt(codes.length()));
	      if(sb.length()==s) {
	      	break;
		  }
	      if(!sb.toString().contains(c+"")) {
	      	sb.append(c);
		  }
	    }
    return sb.toString();
  }
}
