package com.qingke.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setCharacterEncoding("utf-8");
		String str1 = request.getParameter("data1");
		String str2 = request.getParameter("data2");
		String str;
		String str3 = request.getParameter("name");
		System.out.println(str3);
		try {
		int i1 = Integer.valueOf(str1);
		int i2 = Integer.valueOf(str2);
		int i3 = i1 + i2;	
		str = "结果是：" + i3;
		} catch(Exception e) {
			str = "输入的数字非法";
		}
		response.setHeader("content-type","text/html;charset=UTF-8");
		response.getWriter().append(str + " : url中name的值为" + str3).println();
		//response.getWriter().println(str + ":" + str3);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
