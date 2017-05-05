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

import com.nyf.dao.VolunteerActivityDao;
import com.nyf.projo.VolunteerActivity;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class manUpdateVolunteerActivity
 */
@WebServlet("/manUpdateVolunteerActivity")
public class manUpdateVolunteerActivity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manUpdateVolunteerActivity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		SqlSession session = MybatisSessionFactory.getSession();
		VolunteerActivityDao cd = session.getMapper(VolunteerActivityDao.class);
		PrintWriter out = response.getWriter();
		int id = Integer.valueOf(request.getParameter("id"));
		String description = request.getParameter("description");
		String address = request.getParameter("address");
		int status = Integer.valueOf(request.getParameter("status"));
		int number = 0;
		try{
			number = Integer.valueOf(request.getParameter("number"));
			String dateString = request.getParameter("activity_time");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date activity_time = new Date();
			try {
				activity_time = df.parse(dateString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			VolunteerActivity va = new VolunteerActivity();
			va.setActivity_time(activity_time);
			va.setDescription(description);
			va.setAddress(address);
			va.setNumber(number);
			va.setId(id);
			va.setStatus(status);
			va.setRelease_time(new Date());
			if (!MybatisSessionFactory.isValidDate(dateString)) {
				out.print("<script>alert('时间修改失败！');window.location.href='manVolunteerActivity.jsp';</script>");
			} else {
				cd.update(va);
				session.commit();
				out.print("<script>alert('更新成功！');window.location.href='manVolunteerActivity.jsp';</script>");
			}
		}catch(NumberFormatException e) {
			out.print("<script>alert('人数修改失败！');window.location.href='manVolunteerActivity.jsp';</script>");
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
