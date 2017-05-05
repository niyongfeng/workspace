package com.pengrui.xml;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SaxService {
	public static List<Map<String,String>> readXML(String uri, String nodeName) {
		//创建一个解析XML的工厂对象
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		try {
			//创建一个解析XML的对象
			SAXParser parser = parserFactory.newSAXParser();
			//创建一个解析助手类
			SaxParserHandler myhandler = new SaxParserHandler("student");
			parser.parse(uri, myhandler);
			return myhandler.getList();
			
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
