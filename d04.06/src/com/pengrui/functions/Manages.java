package com.pengrui.functions;

import com.pengrui.dao.Dao;
import com.pengrui.object.Products;
import com.pengrui.object.Sellers;

public class Manages {
	public static void manages(Sellers sel) {
		for(Products p : Dao.searchProducts(sel)) {
			System.out.println(p.toString());
		}
	} 
}
