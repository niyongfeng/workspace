package com.nyf.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.nyf.dao.ChairDao;
import com.nyf.dao.QuestionDao;
import com.nyf.projo.Question;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class ManDeleteHelp
 */
@WebServlet("/ManDeleteHelp")
public class ManDeleteHelp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManDeleteHelp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		System.out.println("id="+id);
		SqlSession session = MybatisSessionFactory.getSession();
		QuestionDao cd = session.getMapper(QuestionDao.class);
		String flag = "";
		if(cd.delete(id)) {
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
