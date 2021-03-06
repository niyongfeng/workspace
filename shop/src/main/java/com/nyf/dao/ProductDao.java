package com.nyf.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nyf.pojo.Product;
@Repository
public interface ProductDao {

	boolean insertProduct(Product product);
	List<Product> selectProduct(Product product);
	boolean updateProduct(Product product);
	List<Product> selectProductByString(String str);
	List<Product> selectProductByTagId(int tag_id);
	List<Product> selectProductLike(Product product);
}
