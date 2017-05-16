package com.qingke.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qingke.pojo.Dictionary;
import com.qingke.service.SearchService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Dictionary> list = SearchService.search(request.getParameter("word"));
		//List<Dictionary> result=CiDianSeacher.seacher(request.getParameter("word"));
		/*request.setAttribute("result",result);
		request.getRequestDispatcher("result.jsp").forward(request, response);*/
		Gson gson=new Gson();
		String str=gson.toJson(list);
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(str);
		
		
		
//		String result = "";
//		for(Dictionary d : list) {
//			result = result + d.getWord() + " : <br/>" + d.getDescription() + "<hr/>";
//		}
//		request.setAttribute("result",result); 
//		RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
//		rd.forward(request,response); 
	}


}
