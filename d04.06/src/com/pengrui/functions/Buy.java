package com.pengrui.functions;

import com.pengrui.dao.Dao;
import com.pengrui.object.Products;

public class Buy {
	public static void buy() {
		//System.out.println("1");
		for(Products p : Dao.searchProductsAll()) {
			System.out.println(p.toString());
		}
	}
}
