package mall.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.demo.mybatis.pojo.Product;
import mall.demo.mybatis.pojo.ProductInCart;
import mall.demo.mybatis.service.ProductService;
import mall.demo.util.SessionKeyEnum;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/servlet/addcart.do")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setContentType("application/json;charset=utf-8");
//		PrintWriter pw = response.getWriter();
		String code = "";
		String message = "";
		int number = 0;
		String productIdStr = request.getParameter("pid");
		int productId = 0;
		try {
			productId = Integer.parseInt(productIdStr);
		} catch (Exception e) {
			doResponse(response, "401", "传入的参数非整型", 0);
			return;
		}
//		Object obj = request.getSession().getAttribute(SessionKeyEnum.userObj.name());
//		if(obj == null) {
//			code = "400";
//			message = "用户未登录";
//		} else {
//			User user = (User)obj;
			Product prod = (new ProductService()).getProductById(productId);
			if(prod == null) {
				code = "402";
				message = "该id对应的商品不存在";
			} else {
	 			List<ProductInCart> carts = (List<ProductInCart>)request.getSession().getAttribute(SessionKeyEnum.cart.name());
				if (carts == null) {
					carts = new ArrayList<ProductInCart>();
				}
	//			boolean exist = false;
				ProductInCart foundProd = null;
				for(ProductInCart p : carts) {
					if(p.getProductId() == prod.getProductId()) {
						foundProd = p;
						break;
					}
				}
				if(foundProd == null) {
					ProductInCart newCart = new ProductInCart(prod, 1);
					carts.add(newCart);
				} else {
					foundProd.setAmount(foundProd.getAmount() + 1);
				}
				request.getSession().setAttribute(SessionKeyEnum.cart.name(), carts);
				code = "200";
				for(ProductInCart pCount : carts) {
					number += pCount.getAmount();
				}
				request.getSession().setAttribute("number", number);
			}
//		}
		doResponse(response, code, message, number);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void doResponse(HttpServletResponse response, String code, String msg, int num) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print("{\"code\":\"" + code + "\",\"message\":\""
				+ msg + "\",\"number\":" + num + "}");
	}

}
