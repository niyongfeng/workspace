package com.nyf.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nyf.dao.VolunteerActivityDao;
import com.nyf.projo.VolunteerActivity;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class manUpdateVolunteerActivityId
 */
@WebServlet("/manUpdateVolunteerActivityId")
public class manUpdateVolunteerActivityId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manUpdateVolunteerActivityId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		int id = Integer.valueOf(request.getParameter("id"));
		System.out.println("id="+id);
		SqlSession session = MybatisSessionFactory.getSession();
		VolunteerActivityDao cd = session.getMapper(VolunteerActivityDao.class);
		List<VolunteerActivity> list = cd.selectById(id);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String result = gson.toJson(list.get(0));
		response.getWriter().append(result).println();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
