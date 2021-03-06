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
import com.nyf.serviceImp.ProductServiceImp;
import com.nyf.serviceImp.TagServiceImp;
import com.nyf.util.ServiceFactory;

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
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	User user = (User)req.getSession().getAttribute("user");
    	resp.setCharacterEncoding("utf-8");
		if(user != null) {
			int id = Integer.valueOf(req.getParameter("id"));
	    	ProductServiceImp psi = ServiceFactory.productServiceImp;
	    	List<Product> product = psi.selectById(id);
	    	req.setAttribute("product", product);
	    	req.getRequestDispatcher("/add.jsp").forward(req, resp);
		}else {
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('请先登录！');window.location.href='index.html';</script>");
			//response.sendRedirect("index.html");
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		if(user != null) {
			if(!("".equals(request.getParameter("type")))) {
				updateProduct(request,response);
			}else {
				addProduct(request,response);
			}
		}else {
			PrintWriter out = response.getWriter();
			out.print("<script>alert('请先登录！');window.location.href='index.html';</script>");
			//response.sendRedirect("index.html");
		}
	}
	//添加商品
	public void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Product product = new Product();
		PrintWriter out = response.getWriter();
		try {
		String title = request.getParameter("title");
		String code = request.getParameter("code");
		String description = request.getParameter("description");
		System.out.println("description" + description);
		int tag_id = Integer.valueOf(request.getParameter("tag_id"));
		double price = Double.valueOf(request.getParameter("price"));
		int number = Integer.valueOf(request.getParameter("number"));
		String picture = request.getParameter("picture");
		product.setCode(code);
		product.setDescription(description);
		product.setNumber(number);
		product.setPicture(picture);
		product.setPrice(price);
		product.setTag_id(tag_id);
		product.setTitle(title);
		System.out.println(product);
		ProductServiceImp psi = ServiceFactory.productServiceImp;
		boolean b = psi.insert(product);
		if(b) {
			out.print("<script>alert('添加成功！');window.location.href='product';</script>");
		}else {
			out.print("<script>alert('添加失败！');history.back();</script>");
		}
		}catch (NumberFormatException e){
			out.print("<script>alert('添加失败！');history.back();</script>");
		}
	}
	//修改商品
	public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Product product = new Product();
		PrintWriter out = response.getWriter();
		try {
		int id = Integer.valueOf(request.getParameter("type"));
		String title = request.getParameter("title");
		String code = request.getParameter("code");
		String description = request.getParameter("description");
		System.out.println("description" + description);
		int tag_id = Integer.valueOf(request.getParameter("tag_id"));
		double price = Double.valueOf(request.getParameter("price"));
		int number = Integer.valueOf(request.getParameter("number"));
		String picture = request.getParameter("picture");
		product.setId(id);
		product.setCode(code);
		product.setDescription(description);
		product.setNumber(number);
		product.setPicture(picture);
		product.setPrice(price);
		product.setTag_id(tag_id);
		product.setTitle(title);
		System.out.println(product);
		ProductServiceImp psi = ServiceFactory.productServiceImp;
		boolean b = psi.update(product);
		if(b) {
			out.print("<script>alert('修改成功！');window.location.href='product';</script>");
		}else {
			out.print("<script>alert('修改失败！');history.back();</script>");
		}
		}catch (NumberFormatException e){
			out.print("<script>alert('修改失败！');history.back();</script>");
		}
	}
}
