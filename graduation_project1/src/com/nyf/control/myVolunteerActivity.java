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
import com.nyf.dao.LoginDao;
import com.nyf.dao.VolunteerActivityDao;
import com.nyf.projo.ApplicationForm;
import com.nyf.projo.Login;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class myVolunteerActivity
 */
@WebServlet("/myVolunteerActivity")
public class myVolunteerActivity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myVolunteerActivity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		SqlSession session = MybatisSessionFactory.getSession();
		SqlSession session1 = MybatisSessionFactory.getSession();
		String pageIndex = request.getParameter("pageIndex");
		String pageSize = request.getParameter("pageSize");
		VolunteerActivityDao vad = session.getMapper(VolunteerActivityDao.class);
		String userName = request.getSession().getAttribute("userName").toString();
		LoginDao loginDao = MybatisSessionFactory.getSession().getMapper(LoginDao.class);
		List<Login> list = loginDao.selectByName(userName);
		int student_id = list.get(0).getId();
		ApplicationFormDao af = session1.getMapper(ApplicationFormDao.class);
		List<ApplicationForm> l = af.selectByLogin_id(student_id);
		System.out.println(l);
		List<Object> lva = new ArrayList<>();
//		for(ApplicationForm a : l) {
//			System.out.println(a);
//			int i = a.getVolunteer_id();
//			System.out.println(vad.selectById(i).get(0));
//			lva.add((VolunteerActivity)(vad.selectById(i).get(0)));
//		}
		for(int i = 0; i < l.size();i++) {
			int x = l.get(i).getVolunteer_id();
			Object v = vad.selectById(x).get(0);
			System.out.println(v);
			lva.add(v);
		}
		System.out.println(lva);
		
		if(pageIndex != null && pageSize != null){
			int index = Integer.valueOf(pageIndex);
			int size = Integer.valueOf(pageSize);
			try {
				lva = lva.subList(lva.size() - index*size - size,lva.size() - index*size);
				System.out.println(lva);
			} catch(Exception e){
				e.printStackTrace();
				lva = lva.subList(0,lva.size() - (index*size));
				System.out.println(lva);
			}
		}
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String str = gson.toJson(lva);
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
