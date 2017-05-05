package cn.itcast.bos.util;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * 拼音工具类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月20日 下午2:41:33
 * @version 1.0
 */
public final class PinyinUtil {
	/**
	 * 中文汉字转拼音的方法
	 * @param str  中文汉字
	 * @return 拼音
	 */
	public static String toPinyin(String str) {
		/** 定义变量存放最后结果 */
		String res = "";
		for (int i = 0; i < str.length(); i++){
			/** 取一个中文 */
			char temp = str.charAt(i);
			String[] arr = PinyinHelper.toHanyuPinyinStringArray(temp);
			res += arr[0];
		}
		return res.replaceAll("\\d+", "");
	}
	/**
	 * 取每个中文汉字拼音的首字母方法
	 * @param pcd 中文
	 * @return 拼音
	 */
	public static String toHeadPinyin(String str) {
		/** 定义变量存放最后结果 */
		String res = "";
		for (int i = 0; i < str.length(); i++){
			/** 取一个中文 */
			char temp = str.charAt(i);
			String[] arr = PinyinHelper.toHanyuPinyinStringArray(temp);
			res += arr[0].substring(0, 1);
		}
		return res.toUpperCase();
	}
	
	public static void main(String[] args) {
		System.out.println(toHeadPinyin("广州"));
		System.out.println(Integer.toHexString('李'));
		System.out.println('\u674e');
	}
}
