package mall.demo.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mall.demo.mybatis.pojo.User;
import mall.demo.mybatis.service.UserService;
import mall.demo.util.SessionKeyEnum;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/servlet/login.do")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(UserLoginServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
		User user = new User();
		user.setLoginName(loginName);
		user.setPassword(password);
		User logUser = null;
		try {
			logUser = (new UserService()).getByLoginNamePassword(user);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String url = "数据库查询错误";
			request.getSession().setAttribute(SessionKeyEnum.message.name(), url);
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		if (logUser == null) {
			//登录失败
			String url = "用户名或者密码不正确";
			request.getSession().setAttribute(SessionKeyEnum.message.name(), url);
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute(SessionKeyEnum.isUserLoggedIn.name(), true);
			session.setAttribute(SessionKeyEnum.userObj.name(), logUser);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
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
