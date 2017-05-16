package mall.demo.util;

public class FileUtil {

	public FileUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getSuffix(String filename) {
		if(filename == null || "".equals(filename.trim())) {
			return "";
		}
		filename = filename.trim();
		int rindex = filename.lastIndexOf(".");
		if (rindex < 0) {
			return "";
		}
		return filename.substring(rindex);
	}

}
