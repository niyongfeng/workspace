package com.nyf.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.nyf.dao.CompetitionDao;
import com.nyf.projo.Competition;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class manUpdateCompetition
 */
@WebServlet("/manUpdateCompetition")
public class manUpdateCompetition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public manUpdateCompetition() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		SqlSession session = MybatisSessionFactory.getSession();
		CompetitionDao cd = session.getMapper(CompetitionDao.class);
		int id = Integer.valueOf(request.getParameter("id"));
		int status = Integer.valueOf(request.getParameter("status"));
		String description = request.getParameter("description");
		String address = request.getParameter("address");
		String dateString = request.getParameter("activity_time");

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Competition c = new Competition();
		try {
			c.setActivity_time(df.parse(dateString));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.setAddress(address);
		c.setDescription(description);
		c.setId(id);
		c.setApply_time(new Date());
		c.setStatus(status);
		PrintWriter out = response.getWriter();
		if (!MybatisSessionFactory.isValidDate(dateString)) {
			out.print("<script>alert('时间修改失败！');window.location.href='manCompetition.jsp';</script>");
		} else {
			cd.update(c);
			session.commit();
			out.print("<script>alert('更新成功！');window.location.href='manCompetition.jsp';</script>");
		}
		//response.sendRedirect("manCompetition.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
