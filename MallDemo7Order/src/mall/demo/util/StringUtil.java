package mall.demo.util;

import java.awt.PageAttributes.MediaType;

public class StringUtil {

	public StringUtil() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static String getContentTypeByFileSuffix(String name) {
		String suffix = FileUtil.getSuffix(name);
		suffix = suffix.toLowerCase();
		if (suffix.equals(".jpg") || suffix.equals(".jpeg")) {
			return "image/jpeg";
		}
		if (suffix.equals(".png")) {
			return "image/png";
		}
		if (suffix.equals(".gif")) {
			return "image/gif";
		}
		if (suffix.equals(".bmp")) {
			return "image/bmp";
		}
		return "*/*";
	}

}
