package com.nyf.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nyf.dao.ApplicationFormDao;
import com.nyf.dao.UserDao;
import com.nyf.dao.VolunteerActivityDao;
import com.nyf.projo.ApplicationForm;
import com.nyf.projo.User;
import com.nyf.projo.VolunteerActivity;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class UserVolunteerServlet
 */
@WebServlet("/UserVolunteerServlet")
public class UserVolunteerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserVolunteerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		SqlSession session = MybatisSessionFactory.getSession();
		
		int id = Integer.valueOf(request.getParameter("id"));
		ApplicationFormDao af = session.getMapper(ApplicationFormDao.class);
		List<ApplicationForm> laf = af.selectByVolunteer_id(id);
		
		UserDao ud = session.getMapper(UserDao.class);
		List<User> lu = new ArrayList<User>();
		
		VolunteerActivityDao vad = session.getMapper(VolunteerActivityDao.class);
		
		
		for(ApplicationForm l : laf) {
			System.out.println(l.getStudent_id());
			//System.out.println(ud.selectByLogin_id(l.getStudent_id()));
			User u = (User)(ud.selectByLogin_id(l.getStudent_id())).get(0);
			List<VolunteerActivity> lva = vad.selectById(l.getVolunteer_id());
			System.out.println(u);
			u.setVolunteer_id(l.getId());
			u.setDesc(lva.get(0).getDescription());
			lu.add(u);
		}
		System.out.println(lu);
		Gson gson = new Gson();
		String str = gson.toJson(lu);
		response.getWriter().append(str).println();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
