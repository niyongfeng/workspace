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
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/servlet/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(AddProductServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!(new AdminService()).isAdminLogged(request.getSession())) {
			response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
			return;
		}
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//中文乱码问题
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
//		System.out.println("name=" + name);
		logger.info("name=" + name);
		String desc = request.getParameter("desc");
//		System.out.println("desc=" + desc);
		String price = request.getParameter("price");
		//这里要稍微做一些检查，数据验证
		Product product = new Product();
		product.setCode(code);
		product.setName(name);
		product.setDescription(desc);
		product.setPrice(Double.parseDouble(price));
		(new ProductService()).addNewProduct(product);
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
