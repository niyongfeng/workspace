package com.pengrui.xml;

import java.util.List;
import java.util.Map;

public class XmlParserSample {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		List<Map<String,String>> domList = DomService.readXML("NewFile.xml","student");
		System.out.println(domList.size());
		System.out.println("dom:" + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		List<Map<String,String>> saxList = SaxService.readXML("NewFile.xml","root");
		System.out.println(saxList.size());
		System.out.println("sax:" + (System.currentTimeMillis() - start));
	}

}
