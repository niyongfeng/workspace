package mall.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mall.demo.mybatis.pojo.ProductInCart;
import mall.demo.mybatis.pojo.User;
import mall.demo.util.SessionKeyEnum;
import mall.demo.mybatis.service.OrderService;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/servlet/makeorder.do")
public class MakeOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(MakeOrderServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		User user = (User)request.getSession().getAttribute(SessionKeyEnum.userObj.name());
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		List<ProductInCart> productInCart = (List<ProductInCart>)request.getSession().getAttribute(SessionKeyEnum.cart.name());
		if (productInCart == null || productInCart.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/cart.jsp");
			return;
		}
		try {
			(new OrderService()).makeOrder(user, productInCart);
			request.getSession().removeAttribute(SessionKeyEnum.cart.name());
			response.sendRedirect(request.getContextPath() + "/order.jsp");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			response.sendRedirect(request.getContextPath() + "/cart.jsp");
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
