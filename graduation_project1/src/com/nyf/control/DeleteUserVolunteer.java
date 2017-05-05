package com.nyf.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.nyf.dao.ApplicationFormDao;
import com.nyf.dao.VolunteerActivityDao;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class DeleteUserVolunteer
 */
@WebServlet("/DeleteUserVolunteer")
public class DeleteUserVolunteer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserVolunteer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int volunteer_id = Integer.valueOf(request.getParameter("volunteer_id"));
		System.out.println("volunteer_id="+ volunteer_id);
		SqlSession session = MybatisSessionFactory.getSession();
		ApplicationFormDao cd = session.getMapper(ApplicationFormDao.class);
		String flag = "";
		if(cd.delete(volunteer_id)) {
			flag = "OK";
		}
		session.commit();
		response.getWriter().append(flag).println();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
