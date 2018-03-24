package org.lanqiao.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.lanqiao.Model.Goods;
import org.lanqiao.Service.SelectGoods1Service;
@WebServlet("/SelectProdoctServlet")
public class SelectGoods1Servlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");
		
		System.out.println("查询展示商品servlet1");
		
		try {
			
			int kind_id=Integer.valueOf(request.getParameter("kind_id"));
			SelectGoods1Service sgs=new SelectGoods1Service();
			ArrayList<Goods> goods=sgs.selectproduct(kind_id);
			
			request.setAttribute("Goods", goods);
			request.getRequestDispatcher("jsp/Main.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
