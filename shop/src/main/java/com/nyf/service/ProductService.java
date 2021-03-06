package com.nyf.service;

import java.util.List;

import com.nyf.pojo.Product;
import com.nyf.pojo.Tag;

public interface ProductService {
	
	List<Product> selectAll();
	List<Product> selectByString(String str);
	List<Product> selectByProduct(Product product);
	boolean insert(Product product);
	boolean update(Product product);
	List<Product> selectById(int id);
}
