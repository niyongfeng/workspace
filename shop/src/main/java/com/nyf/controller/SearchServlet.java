package com.nyf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyf.pojo.Product;
import com.nyf.pojo.Tag;
import com.nyf.pojo.User;
import com.nyf.serviceImp.TagServiceImp;
import com.nyf.util.ServiceFactory;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		response.setCharacterEncoding("utf-8");
		if(user != null) {
			String str = request.getParameter("searchKey");
			int tag_id = Integer.valueOf(request.getParameter("tag_id"));
			Product product = new Product();
			product.setTitle(str);
//			Tag tag = new Tag();
//			tag.setId(tag_id);
//			product.setTag(tag);
			product.setTag_id(tag_id);
			System.out.println(product);
			List<Product> list = ServiceFactory.productServiceImp.selectByProduct(product);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/product.jsp").forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.print("<script>alert('请先登录！');window.location.href='index.html';</script>");
			//response.sendRedirect("index.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
