package com.nyf.serviceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nyf.dao.ProductDao;
import com.nyf.pojo.Product;
import com.nyf.service.ProductService;

@Service("productService")
public class ProductServiceImp implements ProductService{

	@Resource
	private ProductDao productDao;
	//private ProductDao productDao = GetSqlSessionFactory.getSession().getMapper(ProductDao.class);

	@Override
	public List<Product> selectAll() {
		System.out.println(productDao);
		//productDao = GetSqlSessionFactory.getSession().getMapper(ProductDao.class);
		return productDao.selectProduct(new Product());
	}

	@Override
	public List<Product> selectByString(String str) {
		return productDao.selectProductByString(str);
	}

	@Override
	public List<Product> selectByProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.selectProductLike(product);
	}

	@Override
	public boolean insert(Product product) {
		return productDao.insertProduct(product);
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
	public List<Product> selectById(int id) {
		Product p = new Product();
		p.setId(id);
		return productDao.selectProduct(p);
	}

	
	
}
