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
import com.nyf.dao.LoginDao;
import com.nyf.projo.Login;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class searchManUser
 */
@WebServlet("/searchManUser")
public class searchManUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchManUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String info = request.getParameter("info");
		SqlSession session = MybatisSessionFactory.getSession();
		LoginDao vad = session.getMapper(LoginDao.class);
		List<Login> activities = new ArrayList<>();
		int i = 9;
		if(info.equals("可用") || info.equals("已注销")){
			if(info.equals("可用")){
				i = 1;
			}else {
				i = 0;
			}
			activities = vad.selectByStatus(i);
		}else if("管理员学生老师".contains(info)){
			if("管理员".contains(info)){
				i = 3;
			}
			if("学生".contains(info)){
				i = 1;
			}
			if("老师".contains(info)){
				i = 2;
			}
			activities = vad.selectByCode(i);
		}else {
			activities = vad.selectByString(info);
		}
		Gson gson = new Gson();
		String str = gson.toJson(activities);
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
