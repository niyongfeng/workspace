package com.nyf.test;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nyf.pojo.Product;
import com.nyf.service.ProductService;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:mybatis_config.xml"})
public class ProductServiceImpTest {
	@Resource
	private ProductService productService;
	@Test
	public void testSelectAll() {
		List<Product> list = productService.selectAll();
		System.out.println(list);
	}

}
