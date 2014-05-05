package com.you.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.you.DBUtil.SQLUtil;
import com.you.bean.ControlModel;
import com.you.data.DataCL;
import com.you.data.FormatTransfer;

/**
 * Servlet implementation class controlServlet
 */
@WebServlet("/controlServlet")
public class controlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public controlServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
		String ControlModelId = request.getParameter("ControlModelId");
		String ControlModelCode = request.getParameter("ControlModelCode");
		String shuaxin = request.getParameter("control");
		
		int id = 0;
		int code = 0;
		
		if(ControlModelId!=null&&ControlModelCode!=null){
			id = Integer.parseInt(ControlModelId);
			code = Integer.parseInt(ControlModelCode);
		}
		
		DataCL data = null;
		try{
			data = new DataCL();
		}catch(Exception e){
			response.sendRedirect("erro.jsp");
		}
		
		SQLUtil sql = new SQLUtil();
		
		if (id!=0&&code!=0) {
			//获取控制器的Id，将其转化为byte数组
			byte[] a = FormatTransfer.toLH(id);
			//获取控制器的状态指令（1：开；2：关），将其转化为byte数组
			byte[] b = FormatTransfer.toLH(code);
			//将转化得到的byte数组有效数据部分拆解并合并到新byte数组中    例如byte[] d = {(byte)0x71,(byte)0x01};：
			byte[] c = {a[0],b[0]};
			
			System.out.println("*****"+FormatTransfer.lBytesToInt(a));
			System.out.println("*****"+a[0]+"XXXX"+a[2]);
//			System.out.println("*****"+c[0]+"XXXX"+c[2]);
//			data.Send("192.168.1.11", 5000, c);

			data.Send("192.168.1.160", 8800 ,c);

			int rec = data.Rechive("192.168.1.160", 8800);
			byte[] f = FormatTransfer.toLH(rec);
			System.out.println(f[0]);
			System.out.println(f[1]);
			if(f[1]==1){
				sql.updateControlModelStatuById(f[0], 0);
			}else if(f[1]==2){
				sql.updateControlModelStatuById(f[0], 1);
			}
			byte[] g = {f[0],f[1]};
			data.Send("192.168.1.160", 8800 ,g);

			response.sendRedirect("righttable.jsp");
		} else if(shuaxin.equals("shuaxin")){
			byte[] all = {0x01,0x11};
			data.Send("192.168.1.160", 8800 ,all);
			int recall = data.Rechive("192.168.1.160", 8800);
			byte[] f = FormatTransfer.toLH(recall);
			System.out.println(f[2]);
			System.out.println(f[3]);
			System.out.println(f[4]);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
