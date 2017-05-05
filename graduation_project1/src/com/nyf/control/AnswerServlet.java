package com.nyf.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.nyf.dao.QuestionDao;
import com.nyf.projo.Question;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class AnswerServlet
 */
@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		Question q = new Question();
		q.setAnswer(answer);
		q.setQuestion(question);
		SqlSession session = MybatisSessionFactory.getSession();
		QuestionDao qd = session.getMapper(QuestionDao.class);
		PrintWriter out = response.getWriter();
		if(qd.update(q)) {
			session.commit();
			out.print("<script>alert('回答成功！');window.location.href='manhelp.jsp';</script>");
		}else{
			out.print("<script>alert('回答失败！');window.location.href='manhelp.jsp';</script>");
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
