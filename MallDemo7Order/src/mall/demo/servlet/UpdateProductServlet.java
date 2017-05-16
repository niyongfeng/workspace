package mall.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mall.demo.mybatis.pojo.Product;
import mall.demo.util.SessionKeyEnum;
import mall.demo.mybatis.service.AdminService;
import mall.demo.mybatis.service.ProductService;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/servlet/updateproduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(UpdateProductServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String pid = request.getParameter("pid");
		Product p = (new ProductService()).getProductById(
				Integer.parseInt(pid));
		logger.info("pid=" + pid + ",p=" + p);
		if (p == null) {
			response.sendRedirect(request.getContextPath() + "/admin/product.jsp");
			return;
		}
		
		logger.info("code=" + request.getParameter("code"));
		logger.info("name=" + request.getParameter("name"));
		p.setCode(request.getParameter("code"));
		p.setName(request.getParameter("name"));
		p.setDescription(request.getParameter("desc"));
		p.setPrice(Double.parseDouble(request.getParameter("price")));
		(new ProductService()).updateProduct(p);
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
