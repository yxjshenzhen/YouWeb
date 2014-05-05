package com.you.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.you.DBUtil.SQLUtil;
import com.you.bean.ChuanGanModel;
import com.you.toolbean.MyTools;

/**
 * Servlet implementation class managerServlet
 */
@WebServlet("/managerServlet")
public class managerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public managerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		int chuanGanId = Integer.parseInt(MyTools.toChinese(request.getParameter("chuanGanId")));
		String chuanGanName = MyTools.toChinese(request.getParameter("chuanGanName"));
		String chuanGanDataType = MyTools.toChinese(request.getParameter("chuanGanDataType"));
		String chuanGanWhere = MyTools.toChinese(request.getParameter("chuanGanWhere"));
		
		ChuanGanModel chuanGanModel = new ChuanGanModel();
		chuanGanModel.setChuanGanId(chuanGanId);
		chuanGanModel.setChuanGanName(chuanGanName);
		chuanGanModel.setChuanGanDataType(chuanGanDataType);
		chuanGanModel.setChuanGanWhere(chuanGanWhere);
		
		SQLUtil sql = new SQLUtil();
		if(sql.addChuanGanModel(chuanGanModel)){
			out.print("<script>alert('Insert Success!')</script>");
		}else{
			out.print("<script>alert('Insert Fail!')</script>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
