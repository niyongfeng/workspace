package mall.demo.mybatis.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mall.demo.mybatis.pojo.Order;
import mall.demo.mybatis.pojo.OrderDetail;
import mall.demo.mybatis.pojo.OrderWithDetail;
import mall.demo.mybatis.pojo.ProductInCart;
import mall.demo.mybatis.pojo.User;
import mall.demo.mybatis.util.MybatisSessionUtil;
import mall.demo.util.OrderStatusEnum;

public class OrderService extends BaseService {
	private String mapper = "mall.demo.mybatis.mapper.OrderMapper.";
	private String addOrder = "addOrder";
	private String addOrderDetail = "addOrderDetail";
	private String selectByUserId = "selectByUserId";
	private String selectDetailByOrderId = "selectDetailByOrderId";
	private String selectAllOrders = "selectAllOrders";
	private String selectOrderByOrderId = "selectOrderByOrderId";
	private String updateOrderStatus = "updateOrderStatus";

	public OrderService() {
		// TODO Auto-generated constructor stub
	}
	
	public void makeOrder(User user, List<ProductInCart> carts) {
		Order order = new Order();
		order.setCode(makeOrderCode());
		order.setUserId(user.getUserId());
		order.setStatus(OrderStatusEnum.NEW.name());
		order.setLastTime(new Date());
		order.setTotalPrice(getTotalPrice(carts));
		SqlSession session = null;
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String st = this.mapper + this.addOrder;
			session.insert(st, order);
			for (ProductInCart p : carts) {
				OrderDetail detail = new OrderDetail();
				detail.setOrderId(order.getOrderId());
				detail.setProductId(p.getProductId());
				detail.setOrderPrice(p.getPrice());
				detail.setAmount(p.getAmount());
				String ost = this.mapper + this.addOrderDetail;
				session.insert(ost, detail);
			}
			session.commit();
		} catch(Exception e) {
			if(session != null) {
				session.rollback();
			}
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<OrderWithDetail> getOrdersByUserId(int uid) {
		SqlSession session = null;
		List<OrderWithDetail> ret = new ArrayList<OrderWithDetail>();
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String st = this.mapper + this.selectByUserId;
			List<Order> orders = session.selectList(st, uid);
			for (Order or : orders) {
				OrderWithDetail owd = new OrderWithDetail();
				owd.setOrder(or);
				String sql = this.mapper + this.selectDetailByOrderId;
				List<OrderDetail> details = session.selectList(sql, or.getOrderId());
				owd.setDetails(details);
				ret.add(owd);
			}
			return ret;
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<Order> getAllOrders() {
		SqlSession session = null;
		List<Order> ret = new ArrayList<Order>();
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String st = this.mapper + this.selectAllOrders;
			ret = session.selectList(st);
			
			return ret;
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public Order getOrderById(int id) {
		SqlSession session = null;
		Order ret = null;
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String st = this.mapper + this.selectOrderByOrderId;
			ret = session.selectOne(st, id);
			
			return ret;
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public void updateOrderStatus(Order order) {
		SqlSession session = null;
//		Order ret = null;
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String st = this.mapper + this.updateOrderStatus;
			session.update(st, order);
			session.commit();
			return;
		} catch(Exception e) {
			session.rollback();
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	private String makeOrderCode() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		return "O" + sdf.format(new Date());
	}
	
	private double getTotalPrice(List<ProductInCart> carts) {
		double price = 0.0;
		for(ProductInCart p : carts) {
			price += p.getPrice() * p.getAmount();
		}
		return price;
	}

}
