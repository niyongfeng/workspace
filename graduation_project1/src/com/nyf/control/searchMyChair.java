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
import com.nyf.dao.ChairDao;
import com.nyf.dao.LoginDao;
import com.nyf.projo.Chair;
import com.nyf.projo.Login;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class searchMyChair
 */
@WebServlet("/searchMyChair")
public class searchMyChair extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchMyChair() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String name = request.getSession().getAttribute("userName").toString();
		String info = request.getParameter("info");
		SqlSession session = MybatisSessionFactory.getSession();
		ChairDao vad = session.getMapper(ChairDao.class);
		List<Chair> activities = vad.selectByStringAndLoginId(info);
		LoginDao ld = session.getMapper(LoginDao.class);
		List<Login> login = ld.selectByName(name);
		int login_id =login.get(0).getId();
		List<Chair> list = new ArrayList<>();
		for(Chair c : activities) {
			if(c.getLogin_id() == login_id) {
				list.add(c);
			}
		}
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String str = gson.toJson(list);
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
