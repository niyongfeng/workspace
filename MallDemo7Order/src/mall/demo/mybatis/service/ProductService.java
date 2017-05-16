package mall.demo.mybatis.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mall.demo.mybatis.pojo.Product;
import mall.demo.mybatis.util.MybatisSessionUtil;

public class ProductService extends BaseService {
	private String productNamespace = "mall.demo.mybatis.mapper.ProductMapper.";
	private String getAllProducts = "getAllProducts";
	private String getProductById = "getProductById";
	private String addNewProduct = "addNewProduct";
	private String deleteById = "deleteById";
	private String updateById = "updateById";
	private String searchNameDesc = "searchNameDesc";

	public ProductService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Product> getAllProducts() {
		SqlSession session = null;
		List<Product> list = new ArrayList<Product>();
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String statement = this.productNamespace + this.getAllProducts;
			list = session.selectList(statement);
			return list;
		} catch (Exception e) {
			//很可能那里出错了，先简单一点直接作为运行时错误抛出去
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<Product> searchProducts(String key) {
		SqlSession session = null;
		List<Product> list = new ArrayList<Product>();
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String statement = this.productNamespace + this.searchNameDesc;
			list = session.selectList(statement, key);
			return list;
		} catch (Exception e) {
			//很可能那里出错了，先简单一点直接作为运行时错误抛出去
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public Product getProductById(int id) {
		SqlSession session = null;
		Product product = null;
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String statement = this.productNamespace + this.getProductById;
			product = session.selectOne(statement, id);
			return product;
		} catch (Exception e) {
			//很可能那里出错了，先简单一点直接作为运行时错误抛出去
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public void addNewProduct(Product product) {
		SqlSession session = null;
//		Product product = null;
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String statement = this.productNamespace + this.addNewProduct;
			session.insert(statement, product);
			session.commit();
			return;
		} catch (Exception e) {
			//很可能那里出错了，先简单一点直接作为运行时错误抛出去
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public void deleteProduct(int id) {
		SqlSession session = null;
//		Product product = null;
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String statement = this.productNamespace + this.deleteById;
			session.delete(statement, id);
			session.commit();
			return;
		} catch (Exception e) {
			//很可能那里出错了，先简单一点直接作为运行时错误抛出去
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public void updateProduct(Product prod) {
		SqlSession session = null;
//		Product product = null;
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String statement = this.productNamespace + this.updateById;
			session.update(statement, prod);
			session.commit();
			return;
		} catch (Exception e) {
			//很可能那里出错了，先简单一点直接作为运行时错误抛出去
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}

}
