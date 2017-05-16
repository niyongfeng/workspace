package mall.demo.util;

public class OrderUtil {

	public OrderUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static OrderStatusEnum nextOrderStatus(OrderStatusEnum status) {
		if (OrderStatusEnum.NEW.equals(status)){
			return OrderStatusEnum.PAYED;
		}
		if (OrderStatusEnum.PAYED.equals(status)){
			return OrderStatusEnum.SHIPPING;
		}
		if (OrderStatusEnum.SHIPPING.equals(status)
				|| OrderStatusEnum.SHIPPED.equals(status)){
			return OrderStatusEnum.SHIPPED;
		}
		return OrderStatusEnum.SHIPPED;
	}

}
