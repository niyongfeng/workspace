package com.xiaohoo.api.common.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CommonUtil {


	public static int randomString(int length) {
		StringBuilder str=new StringBuilder();//定义变长字符串
		Random random=new Random();
		//随机生成数字，并添加到字符串
		for(int i=0;i<length;i++){
			str.append(random.nextInt(10));
		}
		//将字符串转换为数字并输出
		return Integer.parseInt(str.toString());
	}

	public static String initialSequenceId(String prefix)
	{
		long sequenceNum =Long.valueOf(randomString(8));
		return initialSequenceId(prefix, sequenceNum);
	}
	
	private static String initialSequenceId(String prefix, long id)
	{
		String prefixToAdd = prefix == null ? "" : prefix;
		String sequenceNumFormatted = formatSequence(id);
		return getIntervalDate(new Date(), "yyyyMMddHH", 0) + prefixToAdd + sequenceNumFormatted;
	}
	
	/**
	 * 
	 * 对序列号进行初始化，如果>8位则不管，如果<8位，则左补0
	 * 
	 * @param numberToFormat
	 * @return
	 */
	public static String formatSequence(long numberToFormat)
	{
		DecimalFormat format = new DecimalFormat("00000000");
		return format.format(numberToFormat);
	}
	
	
	/**
	 * 
	 * @param date2Get
	 *            将日期按照指定的天数增加或者减少，并转换为需要的日期格式
	 * @param format
	 *            需要转换为的格式
	 * @param days
	 *            时间间隔
	 * @return date2Get 成功：转换后的日期，失败：can't format your input
	 */
	public static String getIntervalDate(Date date2Get, String format, int days)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date2Get);
		c.add(Calendar.DAY_OF_YEAR, days); // 增加天数(如果days为负数,则为减少天数)
		String dateToGet = new SimpleDateFormat(format).format(c.getTime());
		return dateToGet;
	}
	
	public static void main(String[] args) {
		
		System.out.println(initialSequenceId("JY"));
		}
}
