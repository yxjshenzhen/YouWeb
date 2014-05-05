package com.you.toolbean;

import java.io.UnsupportedEncodingException;

public class MyTools {
	/**
	 * 
	 * @功能  转换字符串中属于HTML的特殊字符（防止跨站XSS）
	 * @param sourc为要转换的字符串
	 * @return String类型值
	 */
	public static String changeHTML(String source){
		String changeStr = "";
		changeStr = source.replace("&", "&amp");
		changeStr = changeStr.replace(" ", "&nbsp;");
		changeStr = changeStr.replace("<", "&lt;");
		changeStr = changeStr.replace(">", "&gt;");
		changeStr = changeStr.replace("/r/n", "<br>");
		return changeStr;
	}
	
	/**
	 * 
	 * @功能 解决通过表单产生的中文乱码
	 * @param value为要转换的字符串
	 * @return String类型
	 */
	public static String toChinese(String str){
		if(str==null){
			str = "";
		}
		try{
			str = new String(str.getBytes("ISO-8859-1"),"utf-8");
		}catch(UnsupportedEncodingException e){
			str = "";
			e.printStackTrace();
		}
		return str;
	}
}
