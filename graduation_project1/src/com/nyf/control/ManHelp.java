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
import com.nyf.dao.QuestionDao;
import com.nyf.projo.Question;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class ManHelp
 */
@WebServlet("/ManHelp")
public class ManHelp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManHelp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String pageIndex = request.getParameter("pageIndex");
		String pageSize = request.getParameter("pageSize");
		SqlSession session = MybatisSessionFactory.getSession();
		QuestionDao vad = session.getMapper(QuestionDao.class);
		List<Question> activities = vad.selectAll();
		if(pageIndex != null && pageSize != null){
			int index = Integer.valueOf(pageIndex);
			int size = Integer.valueOf(pageSize);
			try {
				activities = activities.subList(activities.size() - index*size - size,activities.size() - index*size);
				System.out.println(activities);
			} catch(Exception e){
				e.printStackTrace();
				activities = activities.subList(0,activities.size() - (index*size));
				System.out.println(activities);
			}
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
