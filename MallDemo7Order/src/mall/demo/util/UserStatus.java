package mall.demo.util;

public class UserStatus {
	public static final int ACTIVE = 0;
	public static final int NEW = 1;
	public static final int DISABLE = 2;

	public UserStatus() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getDisplay(int status) {
		String ret = "";
		switch(status) {
		case NEW:
			ret = "新建，等待激活";
			break;
		case ACTIVE:
			ret = "正常";
			break;
		case DISABLE:
			ret = "被禁止了";
			break;
		default:
			ret = "未知异常状态";
		}
		return ret;
	}

}
