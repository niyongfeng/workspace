package mall.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mall.demo.util.SessionKeyEnum;
import mall.demo.mybatis.service.AdminService;
import mall.demo.mybatis.service.ProductService;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/servlet/delproduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		if(!(new AdminService()).isAdminLogged(request.getSession())) {
			response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
			return;
		}
		String pidStr = request.getParameter("pid");
		
		(new ProductService()).deleteProduct(Integer.parseInt(pidStr));
		response.sendRedirect(request.getContextPath() + "/admin/product.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
