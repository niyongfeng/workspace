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

import mall.demo.mybatis.pojo.Product;
import mall.demo.mybatis.service.ProductService;
import mall.demo.util.RequestKeyEnum;

/**
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/servlet/ProductSearchServlet")
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ProductSearchServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String searchKey = request.getParameter("searchKey");
		if (searchKey == null) {
			searchKey = "";
		}
		logger.debug("searchKey=" + searchKey);
		List<Product> products = (new ProductService()).searchProducts(searchKey);
		//slf4j-simple 默认log级别是info
		logger.info("search result size=" + products.size());
		//放入request，以便index.jsp可以读取
		request.setAttribute(RequestKeyEnum.productList.name(), products);
		request.setAttribute(RequestKeyEnum.searchKey.name(), searchKey);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
