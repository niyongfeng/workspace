package com.nyf.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.nyf.dao.ChairDao;
import com.nyf.dao.LoginDao;
import com.nyf.projo.Chair;
import com.nyf.projo.Login;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class ChariManageServlet
 */
@WebServlet("/ChariManageServlet")
public class ChariManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChariManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String dateString = request.getParameter("activity_time1");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date activity_time = new Date();
		try {
			activity_time = df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String chair_professor = request.getParameter("chair_professor1");
		String description = request.getParameter("description1");
		String address = request.getParameter("address1");
		Chair c = new Chair();
		c.setActivity_time(activity_time);
		c.setChair_professor(chair_professor);
		c.setDescription(description);
		c.setAddress(address);
		String userName = request.getSession().getAttribute("userName").toString();
		LoginDao loginDao = MybatisSessionFactory.getSession().getMapper(LoginDao.class);
		List<Login> list = loginDao.selectByName(userName);
		c.setLogin_id(list.get(0).getId());
		
		System.out.println(c);
		SqlSession s = MybatisSessionFactory.getSession(); 
		ChairDao cd = s.getMapper(ChairDao.class);
		PrintWriter out = response.getWriter();
		if (!MybatisSessionFactory.isValidDate(dateString)) {
			if(list.get(0).getCode() == 2) {
				out.print("<script>alert('发布失败！(时间格式错误)');window.location.href='teacherChair.jsp';</script>");
			}else {
				out.print("<script>alert('发布失败！(时间格式错误)');window.location.href='manChair.jsp';</script>");
			}
			
		} else {
			try{
			cd.insert(c);
			s.commit();
			if(list.get(0).getCode() == 2) {
				out.print("<script>alert('发布成功！');window.location.href='teacherChair.jsp';</script>");
			}else {
				out.print("<script>alert('发布成功！');window.location.href='manChair.jsp';</script>");
			}
			}catch(Exception e) {
				if(list.get(0).getCode() == 2) {
					out.print("<script>alert('发布失败！(不能为空)');window.location.href='teacherChair.jsp';</script>");
				}else {
					out.print("<script>alert('发布失败！(不能为空)');window.location.href='manChair.jsp';</script>");
				}
			}
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
