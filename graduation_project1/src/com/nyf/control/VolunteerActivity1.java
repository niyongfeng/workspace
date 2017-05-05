package com.nyf.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.nyf.dao.ApplicationFormDao;
import com.nyf.dao.LoginDao;
import com.nyf.dao.VolunteerActivityDao;
import com.nyf.projo.ApplicationForm;
import com.nyf.projo.Login;
import com.nyf.projo.VolunteerActivity;
import com.nyf.util.MybatisSessionFactory;
/**
 * Servlet implementation class VolunteerActivity
 */
@WebServlet("/VolunteerActivity1")
public class VolunteerActivity1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerActivity1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		int volunteer_id = Integer.valueOf(request.getParameter("id"));
		SqlSession session = MybatisSessionFactory.getSession();
		VolunteerActivityDao vad = session.getMapper(VolunteerActivityDao.class);
		String userName = request.getSession().getAttribute("userName").toString();
		LoginDao loginDao = MybatisSessionFactory.getSession().getMapper(LoginDao.class);
		List<Login> list = loginDao.selectByName(userName);
		int student_id = list.get(0).getId();
		ApplicationFormDao af = session.getMapper(ApplicationFormDao.class);
		ApplicationForm app = new ApplicationForm();
		PrintWriter out = response.getWriter();
		app.setStudent_id(student_id);
		app.setVolunteer_id(volunteer_id);
		int i = af.selectByVolunteer(app).size();
		if(i == 0) {
			af.insert(app);
			Object obj = vad.selectById(volunteer_id).get(0);
			System.out.println(obj);
			if(obj instanceof VolunteerActivity) {
				VolunteerActivity va = (VolunteerActivity)obj;
				int number = va.getCount() + 1;
				va.setCount(number);
				vad.updateCount(va);
			}
			session.commit();
			out.print("<script>alert('报名成功！');window.location.href='studentVolunteerActivity.jsp';</script>");
		}else {
			out.print("<script>alert('你已经参加过报名了！');window.location.href='studentVolunteerActivity.jsp';</script>");
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
