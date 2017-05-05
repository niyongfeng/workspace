package com.qingke.tianqi;

import java.util.Scanner;

import com.qing.pojo.LocationNext;
import com.qing.pojo.LocationNow;
import com.qing.pojo.Results;
import com.qing.pojo.ResultsNext;

public class TestWeather {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		weather w = new weather();
		while (true) {
			System.out.println("请输入需要查询的城市天气(exit退出程序)：");
			String str = sc.next();
			if ("exit".equals(str)) {
				break;
			}
			System.out.println("1.当前天气情况");
			System.out.println("2.今天及未来三天天气");
			System.out.println("请选择：");
			int i = sc.nextInt();
			if(i == 1 || i == 2) {
				if(i == 1) {
					print(w.getResult(str));
				}else {
					print2(w.getResultNext(str));
				}
			}else {
				System.out.println("您的输入有误！请重新输入！");
			}

		}

	}

	public static void print(Results results) {
		if (results != null) {
			LocationNow ln = results.getResult().get(0);
			System.out.println("城市：" + ln.getLocation().getName());
			System.out.println("国家：" + ln.getLocation().getCountry());
			System.out.println("地点：" + ln.getLocation().getPath());
			System.out.println("时区：" + ln.getLocation().getTimezone_offset());
			System.out.println("天气：" + ln.getNow().getText());
			System.out.println("温度：" + ln.getNow().getTemperature());
			String str = ln.getLast_update();
			String str1 = str.replace("T", " ");
			System.out.println("最近更新：" + str1);
		}
	}
	public static void print2(ResultsNext resultsNext) {
		if (resultsNext != null) {
			LocationNext ln = resultsNext.getResult().get(0);
			System.out.println("城市：" + ln.getLocation().getName());
			System.out.println("国家：" + ln.getLocation().getCountry());
			System.out.println("地点：" + ln.getLocation().getPath());
			System.out.println("时区：" + ln.getLocation().getTimezone_offset());
			for(int i = 0; i < ln.getDaily().size(); i++) {
				System.out.println("日期" + ln.getDaily().get(i).getDate());
				System.out.println("白天天气：" + ln.getDaily().get(i).getText_day());
				System.out.println("夜晚天气：" + ln.getDaily().get(i).getText_night());
				System.out.println("最高温度：" + ln.getDaily().get(i).getHigh());
				System.out.println("最低温度：" + ln.getDaily().get(i).getLow());
				//System.out.println("降雨量：" + ln.getDaily().get(i).getPrecip());
				System.out.println("风速：" + ln.getDaily().get(i).getWind_speed());
				System.out.println("");
			}


		}
	}
}
