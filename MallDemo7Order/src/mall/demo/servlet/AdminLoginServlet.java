package mall.demo.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.demo.mybatis.pojo.Admin;
import mall.demo.mybatis.service.AdminService;
import mall.demo.util.SessionKeyEnum;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/servlet/admin_login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		Admin requestAdmin = new Admin();
		requestAdmin.setLoginName(loginName);
		requestAdmin.setPassword(password);
		Admin loginAdmin = (new AdminService()).getByNamePassword(requestAdmin);
		if (loginAdmin == null) {
			String key = "用户名或者密码不正确";
			request.getSession().setAttribute(
					SessionKeyEnum.message.name(), key);
			response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
		}else {
			request.getSession().setAttribute(SessionKeyEnum.isAdminIn.name(), true);
			request.getSession().setAttribute(SessionKeyEnum.adminObj.name(), loginAdmin);
			response.sendRedirect(request.getContextPath() + "/admin/product.jsp");
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
