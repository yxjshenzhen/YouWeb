package com.you.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.servlet.ServletUtilities;

import com.you.jfreechart.ChartUtil;
import com.you.jfreechart.RealTimeChart;

/**
 * Servlet implementation class RealTimeServlet
 */
@WebServlet("/RealTimeServlet")
public class RealTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public RealTimeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RealTimeChart rtcp=new RealTimeChart("Random Data","随机数","数值");
		 (new Thread(rtcp)).start();
		 //获取生成图片的名称 
		 String fileName = ServletUtilities.saveChartAsJPEG(rtcp.getChart(), 910, 455, request.getSession()); 
		 //获取图片的路径 
		 String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName; 
		  
		 //将路径放到request对象中 
		 request.setAttribute("graphURL", graphURL); 
		 System.out.println(graphURL);
		 
		 //页面转发到result.jsp 
		 request.getRequestDispatcher("chart_result.jsp").forward(request, response);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
