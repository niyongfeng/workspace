package mall.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.demo.mybatis.pojo.Notification;
import mall.demo.mybatis.service.NotificationService;
import mall.demo.mybatis.service.UserService;
import mall.demo.util.NotificationTypeEnum;

/**
 * Servlet implementation class NotifyServlet
 */
@WebServlet("/servlet/notify")
public class NotifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String token = request.getParameter("token");
		if(token == null || token.trim().equals(""))
		{
			response.getWriter().println("no token");
			return;
		}
		Notification notify = (new NotificationService()).getByToken(token);
		if (notify == null || !notify.isExpired()) {
			response.getWriter().println("invalid/expired token");
			return;
		}
		if(NotificationTypeEnum.registerNewUser.name().equals(notify.getnType())) {
			//handle register new user
			(new NotificationService()).expireNotification(notify);
			String userName = notify.getInfo();
			(new UserService()).activeUserByName(userName);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		} else {
			response.getWriter().println("no support for this type");
			
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
