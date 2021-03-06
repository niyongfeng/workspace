package com.qingke.tianqi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;
import com.qing.pojo.Results;

import com.qing.pojo.ResultsNext;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class weather {

	String urlStr = "https://api.seniverse.com/v3/weather/now.json?key=6yrlyav3ao24qlop&language=zh-Hans&unit=c&location=";
	String urlStr1 = "https://api.seniverse.com/v3/weather/daily.json?key=6yrlyav3ao24qlop&language=zh-Hans&unit=c&start=0&days=5&location=";


	public String getWeather(String city) {

		StringBuffer sb = new StringBuffer();
		try {
			String city1 = URLEncoder.encode(city, "utf-8");
			URL url = new URL(urlStr + city1);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			InputStream is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);
				sb.append("\r\n");
			}
			return sb.toString();
		} catch (MalformedURLException e) {
			System.out.println("城市输入有误！");
		} catch (IOException e) {
			System.out.println("城市输入有误！");
		}
		return "";
	}

	public String getWeather2(String city) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(urlStr1 + city).build();
		Response response;
		try {
			response = client.newCall(request).execute();
			return response.body().string();
		} catch (IOException e) {
			System.out.println("城市输入有误！");
		}
		return "";
	}
	
	public Results getResult(String city) {
		Gson gson = new Gson();
		String str = getWeather(city);
		if (!("".equals(str))) {
			return gson.fromJson(str, Results.class);
		} else {
			return null;
		}
	}

	public ResultsNext getResultNext(String city) {
		Gson gson = new Gson();
		String str = getWeather2(city);
		System.out.println(str);
		if (!("".equals(str))) {
			System.out.println(gson.fromJson(str, ResultsNext.class));
			return gson.fromJson(str, ResultsNext.class);
		} else {
			return null;
		}
	}

}
