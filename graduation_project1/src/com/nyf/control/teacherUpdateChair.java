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

import com.nyf.dao.ChairDao;
import com.nyf.projo.Chair;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class teacherUpdateChair
 */
@WebServlet("/teacherUpdateChair")
public class teacherUpdateChair extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacherUpdateChair() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		SqlSession session = MybatisSessionFactory.getSession();
		ChairDao cd = session.getMapper(ChairDao.class);
		int id = Integer.valueOf(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		String description = request.getParameter("description");
		String address = request.getParameter("address");
		String dateString = request.getParameter("activity_time");
		String chair_professor = request.getParameter("chair_professor");
		int status = Integer.valueOf(request.getParameter("status"));
		Chair c = new Chair();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date activity_time = new Date();
		try {
			activity_time = df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setActivity_time(activity_time);
		c.setAddress(address);
		c.setChair_professor(chair_professor);
		c.setDescription(description);
		c.setId(id);
		c.setStatus(status);
		c.setRelease_time(new Date());
		if (!MybatisSessionFactory.isValidDate(dateString)) {
			out.print("<script>alert('时间修改失败！');window.location.href='teacherChair.jsp';</script>");
		} else {
			cd.update(c);
			session.commit();
			out.print("<script>alert('更新成功！');window.location.href='teacherChair.jsp';</script>");
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
