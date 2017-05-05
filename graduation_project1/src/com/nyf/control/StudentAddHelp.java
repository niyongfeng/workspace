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

import com.nyf.dao.LoginDao;
import com.nyf.dao.QuestionDao;
import com.nyf.dao.TeacherProjectDao;
import com.nyf.projo.Login;
import com.nyf.projo.Question;
import com.nyf.projo.TeacherProject;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class StudentAddHelp
 */
@WebServlet("/StudentAddHelp")
public class StudentAddHelp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAddHelp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String question = request.getParameter("question");
		String userName = request.getSession().getAttribute("userName").toString();
		SqlSession s = MybatisSessionFactory.getSession();
		LoginDao loginDao = s.getMapper(LoginDao.class);
		QuestionDao qd = s.getMapper(QuestionDao.class);
		List<Login> list = loginDao.selectByName(userName);
		PrintWriter out = response.getWriter();
		int login_id = list.get(0).getId();
		Question q = new Question();
		q.setId(10);
		q.setQuestion(question);
		q.setLogin_id(login_id);
		System.out.println(q);
		boolean b = qd.insert(q);
		if(b) {
			s.commit();
			out.print(
					"<script>alert('提问成功！');window.location.href='studenthelp.jsp';</script>");
		}else {
			out.print(
					"<script>alert('提问失败！');window.location.href='studenthelp.jsp';</script>");
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
