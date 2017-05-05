package com.pengrui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pengrui.functions.Login;
import com.pengrui.functions.Orders;
import com.pengrui.object.Customers;
import com.pengrui.object.Products;
import com.pengrui.object.Sellers;
import com.pengrui.object.Users;

public class Dao {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet res = null;
	private static Users user = null;
	private static Customers customer = null;
	private static Sellers seller = null;
	private static JDBConnection jdbc = null;
	private static Products product = null;
	private static Orders order = null;

	static {
		jdbc = JDBConnection.getInstance();
		con = jdbc.getConnection();
	}

	public static boolean insertUser(Users u) {
		String sql = "insert into users(name,pwd,sellers_sellers_id,customers_customers_id) value (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPwd());
			ps.setInt(3, u.getSellersId());
			ps.setInt(4, u.getCustomersId());
			return !ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean insertCustomer(Customers cus) {
		// CALL `orders_manage_system`.`customers_count`(<{in pwd varchar(45)}>,
		// <{in name varchar(45)}>,
		// <{in phone varchar(11)}>,
		// <{in address varchar(200)}>,
		// <{in email varchar(45)}>,
		// <{in postcode int(6)}>);
		String sql = "call customers_count(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cus.getPwd());
			ps.setString(2, cus.getName());
			ps.setString(3, cus.getPhone());
			ps.setString(4, cus.getAddress());
			ps.setString(5, cus.getEmail());
			ps.setInt(6, cus.getPostcode());
			if(!ps.execute()) {
				user = new Users();
				//System.out.println(searchCustomer(cus).get(0).getId());
				user.setCustomersId(searchCustomer(cus).get(0).getId());
				user.setName(searchCustomer(cus).get(0).getName());
				user.setPwd(searchCustomer(cus).get(0).getPwd());
				return insertUser(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean insertSeller(Sellers sel) {
//		CALL `orders_manage_system`.`sellers_count`(<{in name varchar(45)}>, 
//													<{in address varchar(200)}>, 
//													<{in phone varchar(11)}>, 
//													<{in email varchar(45)}>,
//													<{in pwd varchar(45)}>);
		String sql = "call sellers_count(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sel.getName());
			ps.setString(2, sel.getAddress());
			ps.setString(3, sel.getPhone());
			ps.setString(4, sel.getEmail());
			ps.setString(5, sel.getPwd());
			if(!ps.execute()) {
				user = new Users();
				user.setSellersId(searchSeller(sel).get(0).getId());
				user.setName(searchSeller(sel).get(0).getName());
				user.setPwd(searchSeller(sel).get(0).getPwd());
				return insertUser(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static List<Customers> searchCustomer(Customers cus) {
		List<Customers> list = new ArrayList<Customers>();
		try {
			if (cus.getId() != 0) {
				ps = con.prepareStatement("select * from customers where customers_id = ?");
				ps.setInt(1, cus.getId());
			}else if(!"".equals(cus.getPhone())) {
				ps = con.prepareStatement("select * from customers where phone = ?");
				ps.setString(1, cus.getPhone());
			}else if(!"".equals(cus.getEmail())) {
				ps = con.prepareStatement("select * from customers where email = ?");
				ps.setString(1, cus.getEmail());
			}else if(!"".equals(cus.getName())){
				ps = con.prepareStatement("select * from customers where name = ?");
				ps.setString(1, cus.getName());
			}else if(!"".equals(cus.getAddress())) {
				ps = con.prepareStatement("select * from customers where address = ?");
				ps.setString(1, cus.getAddress());
			}else if(!"".equals(cus.getPostcode())) {
				ps = con.prepareStatement("select * from customers where postcode = ?");
				ps.setInt(1, cus.getId());
			}
			ps.execute();
			res = ps.getResultSet();
			while(res.next()) {
				customer = new Customers();
				customer.setId(res.getInt("customers_id"));
				customer.setName(res.getString("name"));
				customer.setPwd(res.getString("pwd"));
				customer.setAddress(res.getString("address"));
				customer.setPhone(res.getString("phone"));
				customer.setPostcode(res.getInt("postcode"));
				customer.setEmail(res.getString("email"));
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Sellers> searchSeller(Sellers sel) {
		List<Sellers> list = new ArrayList<Sellers>();
		try {
			if(sel.getId() != 0) {
				ps = con.prepareStatement("select * from sellers where sellers_id = ?");
				ps.setInt(1, sel.getId());
			}else if(!"".equals(sel.getName())) {
				ps = con.prepareStatement("select * from sellers where name = ?");
				ps.setString(1, sel.getName());
			}else if(!"".equals(sel.getPhone())) {
				ps = con.prepareStatement("select * from sellers where phone = ?");
				ps.setString(1, sel.getPhone());
			}else if(!"".equals(sel.getEmail())) {
				ps = con.prepareStatement("select * from sellers where email = ?");
				ps.setString(1, sel.getEmail());
			}else if(!"".equals(sel.getAddress())){
				ps = con.prepareStatement("select * from sellers where address = ?");
				ps.setString(1, sel.getAddress());
			}
			ps.execute();
			res = ps.getResultSet();
			while(res.next()) {
				seller = new Sellers();
				seller.setAddress(res.getString("address"));
				seller.setId(res.getInt("sellers_id"));
				seller.setName(res.getString("name"));
				seller.setPhone(res.getString("phone"));
				seller.setEmail(res.getString("email"));
				seller.setPwd(res.getString("pwd"));
				list.add(seller);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Users> searchUser(Users u) {
		List<Users> list = new ArrayList<Users>();
		String sql = "select * from users where name = ? and pwd = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPwd());
			ps.execute();
			res = ps.getResultSet();
			while(res.next()) {
				user = new Users();
				user.setId(res.getInt("id"));
				user.setName(res.getString("name"));
				user.setCustomersId(res.getInt("customers_customers_id"));
				user.setSellersId(res.getInt("sellers_sellers_id"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
//	CALL `orders_manage_system`.`products_count`(<{in products_name varchar(45)}>, 
//												<{in description varchar(200)}>, 
//												<{in price int(11)}>, 
//												<{in number int(11)}>, 
//												<{in sellers_sellers_id int(11)}>,
//												<{in status int(11)}>);
	public static boolean insertProduct(Products pro) {
		String sql = "call products_count(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pro.getName());
			ps.setString(2, pro.getDescription());
			ps.setInt(3, pro.getPrice());
			ps.setInt(4, pro.getNumber());
			ps.setInt(5, pro.getSellersId());
			ps.setInt(6, pro.getStatus());
			return !ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static List<Products> searchProductsAll() {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from products";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
			res = ps.getResultSet();
			while(res.next()) {
				if(res.getInt("status") == 0) {
					break;
				}
				product = new Products();
				product.setProductsId(res.getInt("products_id"));
				product.setName(res.getString("products_name"));
				product.setDescription(res.getString("description"));
				product.setPrice(res.getInt("price"));
				product.setNumber(res.getInt("numbers"));
				product.setSellersId(res.getInt("sellers_sellers_id"));
				product.setStatus(res.getInt("status"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Products> searchProducts(Sellers sel) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from products where sellers_sellers_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, sel.getId());
			ps.execute();
			res = ps.getResultSet();
			while(res.next()) {
				if(res.getInt("status") == 0) {
					break;
				}
				product = new Products();
				product.setProductsId(res.getInt("products_id"));
				product.setName(res.getString("products_name"));
				product.setDescription(res.getString("description"));
				product.setPrice(res.getInt("price"));
				product.setNumber(res.getInt("numbers"));
				product.setSellersId(res.getInt("sellers_sellers_id"));
				product.setStatus(res.getInt("status"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static boolean updateProductSeller(Products pro) {
		String sql = "update products set products_name = ?, description = ?, price = ?, numbers = ? where products_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pro.getName());
			ps.setString(2, pro.getDescription());
			ps.setInt(3, pro.getPrice());
			ps.setInt(4, pro.getNumber());
			ps.setInt(5, pro.getProductsId());
			int n = ps.executeUpdate();
			if(n != 0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteProductSeller(int id) {
		String sql = "update products set status = ? where products_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setInt(2, id);
			int n = ps.executeUpdate();
			if(n != 0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//CALL `orders_manage_system`.`orders_count`(<{in status int}>, <{in customers_customers_id int}>, <{in products_products_id int}>);

	public static boolean insertOrder(int productid) {
		String sql = "call orders_count(?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, Login.customer.getId());
			ps.setInt(3, productid);
			return !ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static List<Orders> searchOrder(Customers cus) {
		List<Orders> list = new ArrayList<Orders>();
		String sql = "select * from orders where customers_customers_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cus.getId());
			res = ps.executeQuery();
			while(res.next()) {
				order = new Orders();
				order.setId(res.getInt(1));
				order.setStatus(res.getInt(2));
				order.setDatetime(res.getDate(3) + "");
				order.setCustomerId(res.getInt(4));
				order.setProductId(res.getInt(5));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static boolean deleteOrder(int id) {
		String sql = "delete from orders where orders_number = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			return !ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
