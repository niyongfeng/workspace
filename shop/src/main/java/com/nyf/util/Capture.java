package com.nyf.util;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Capture {

	public static void main(String[] args) throws IOException {
		String http = "https://search.jd.com/Search?keyword=";
		String keyWord = "阿迪达斯";
		String url = http + keyWord + "&enc=utf-8&suggest=1.def.0.T05&wq=add&pvid=402a1913e1b644b28588f69ca568db16";
		Document doc = Jsoup.connect(url).get();
		//System.out.println(doc);
		List<Element> element = doc.select("#J_main ul.gl-warp li.gl-item div.gl-i-wrap");
		int i = 1;
		for(Element e : element) {
			System.out.println("商品"+ i + "：");
			System.out.println("商品描述:" + e.select("div.p-name").text() + ";商品价格:" + e.select("div.p-price").text() + ";卖家:" + e.select("div.p-shop"));
			i++;
		}
	}
}
