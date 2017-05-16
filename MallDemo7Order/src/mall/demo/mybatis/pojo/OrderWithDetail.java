package mall.demo.mybatis.pojo;

import java.util.List;

public class OrderWithDetail {
	private Order order;
	private List<OrderDetail> details;

	public OrderWithDetail() {
		// TODO Auto-generated constructor stub
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}

}
