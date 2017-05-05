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

import com.nyf.dao.LoginDao;
import com.nyf.dao.TeacherProjectDao;
import com.nyf.dao.VolunteerActivityDao;
import com.nyf.projo.Login;
import com.nyf.projo.TeacherProject;
import com.nyf.projo.VolunteerActivity;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class TeacherProjectManageServlet
 */
@WebServlet("/TeacherProjectManageServlet")
public class TeacherProjectManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherProjectManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String teacher = request.getParameter("teacher");
		String userName = request.getSession().getAttribute("userName").toString();
		LoginDao loginDao = MybatisSessionFactory.getSession().getMapper(LoginDao.class);
		List<Login> list = loginDao.selectByName(userName);
		PrintWriter out = response.getWriter();
		try{
		int number = Integer.valueOf(request.getParameter("number"));
		TeacherProject c = new TeacherProject();
		c.setName(name);
		c.setTeacher(teacher);
		c.setDescription(description);
		c.setNumber(number);
		c.setLogin_id(list.get(0).getId());
		System.out.println(c);
		SqlSession s = MybatisSessionFactory.getSession(); 
		TeacherProjectDao cd = s.getMapper(TeacherProjectDao.class);
		cd.insert(c);
		s.commit();
		if (list.get(0).getCode() == 2) {
			out.print(
					"<script>alert('发布成功！');window.location.href='teacherTeacherProject.jsp';</script>");
		} else {
			out.print("<script>alert('发布成功！');window.location.href='manTeacherProject.jsp';</script>");
		}
		}catch(NumberFormatException e) {
			if (list.get(0).getCode() == 2) {
				out.print(
						"<script>alert('发布失败！(人数格式不正确)');window.location.href='teacherTeacherProject.jsp';</script>");
			} else {
				out.print("<script>alert('发布失败！(人数格式不正确)');window.location.href='manTeacherProject.jsp';</script>");
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
