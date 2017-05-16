package mall.demo.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mall.demo.mybatis.pojo.User;
import mall.demo.mybatis.service.UserService;
import mall.demo.util.SessionKeyEnum;
import mall.demo.util.UserStatus;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/servlet/register.do")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(UserRegisterServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//设置request端的字符编码，解决中文乱码问题
		request.setCharacterEncoding("UTF-8");
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		//一般总是要对参数做一些检查，这里先算了
		User user = new User();
		user.setLoginName(loginName);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setEmail(email);
		user.setStatus(UserStatus.NEW);
		try {
			(new UserService()).addNewUser(user);
		
		//如果没有报错，添加成功。直接设置好session，回首页。
			request.getSession().setAttribute(SessionKeyEnum.isUserLoggedIn.name(), true);
			request.getSession().setAttribute(SessionKeyEnum.userObj.name(), user);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String msg = "数据库新增用户时出错了";
			request.getSession().setAttribute(SessionKeyEnum.message.name(), msg);
			response.sendRedirect(request.getContextPath() + "/register.jsp");
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
