package mall.demo.mybatis.pojo;
/**
 * 购物车类
 * @author Administrator
 *
 */
public class ProductInCart extends Product {
	private int amount;//数量

	public ProductInCart() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductInCart(Product p, int amount) {
		this.setProductId(p.getProductId());
		this.setAmount(amount);
		this.setCode(p.getCode());
		this.setDescription(p.getDescription());
		this.setName(p.getName());
		this.setPrice(p.getPrice());
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
