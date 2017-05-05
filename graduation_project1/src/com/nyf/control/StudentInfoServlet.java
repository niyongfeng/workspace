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
import com.nyf.dao.LoginDao;
import com.nyf.dao.UserDao;
import com.nyf.projo.User;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class StudentInfoServlet
 */
@WebServlet("/StudentInfoServlet")
public class StudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String name = request.getSession().getAttribute("userName").toString();
		System.out.println(name);
		SqlSession session = MybatisSessionFactory.getSession();
		LoginDao ld = session.getMapper(LoginDao.class);
		int login_id = ld.selectByNameA(name).get(0).getId();
		UserDao ud = session.getMapper(UserDao.class);
		List<User> lu = ud.selectByLogin_id(login_id);
		Gson gson = new Gson();
		String result = gson.toJson(lu);
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
