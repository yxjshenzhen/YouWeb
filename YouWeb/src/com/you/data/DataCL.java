package com.you.data;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

import sun.awt.image.IntegerInterleavedRaster;



public class DataCL {
	
	private byte[] bu=null;
	
	private int msg;
	
	public DataCL(){
		
	}
	
	public void Send(String ip,int port,byte[] b){
		Socket socket = null;
		try {
			socket = new Socket(ip,port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取输出流
		OutputStream os = null;
		try {
			System.out.println("xxxxxxxxxxxxx");
			os = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		try {
//			bu = query.getBytes("UTF-16LE");
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		//在输出流中写入执行命令
		try {
		
			os.write(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int Rechive(String ip,int port){
	
		Socket socket = null;
		try {
			socket = new Socket(ip,port);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		DataInputStream dis = null;
		try {
			dis  = new DataInputStream(socket.getInputStream());

		} catch (IOException e1) {
			// TODO Auto-generated catch block 
			e1.printStackTrace();
		}
		try {
			while(true){
				
//				int i = dis.readInt();
				

				byte [] buf = new byte[1024]; 
	            int len = dis.read(buf); 
	            msg = FormatTransfer.lBytesToInt(buf);
	            System.out.println(msg);
//	            String msg1 = new String(buf,0,len,"UTF-8");
//	            System.out.println("msg1"+msg1);
//	            msg = Integer.parseInt(msg1,16);
//	            //十进制打印出来
//	            System.out.println(msg);
	           
//	            UTF-16分为UTF-16LE和UTF-16BE，其实就是Unicode16；
//	                                简单记录UTF-8与Unicode的转换；
//	            BOM：FE FF 表示大端；
//	            BOM：FF FE表示小端；
//	            UTF-8都是大端；FE FF转换为UTF-8就是EF BB BF；

				break;
			}
			
			dis.close();
			socket.close();


		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return msg;
	}
}
