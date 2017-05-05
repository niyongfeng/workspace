package com.pengrui.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserHandler extends DefaultHandler{
	//存储正在解析的元素的数据
	private Map<String,String> map = null;
	//存储所有解析的元素的数据
	private List<Map<String,String>> list = null;
	//正在解析的元素的名字
	String currentTag = null;
	//正在解析的元素的元素值
	String currentValue = null;
	//开始解析的元素
	String nodeName = null;
	
	public SaxParserHandler(String nodeName) {
		this.nodeName = nodeName;
	}
	
	public List<Map<String,String>> getList() {
		return list;
	}
	
	//开始解析文档，即开始解析XML根元素时调用该方法
	public void startDocument() throws SAXException {
		//初始化Map
		list = new ArrayList<Map<String,String>>();
	}
	
	//开始解析每个元素时会调用该方法
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		//判断正在解析的元素是不是开始解析的元素
		if(qName.equals(nodeName)) {
			map = new HashMap<String,String>();
		}
		
		//判断正在解析的元素是否有属性值，如果有则将其全部取出并保存到Map对
		if(attributes != null && map != null) {
			for(int i = 0; i < attributes.getLength(); i++) {
				map.put(attributes.getQName(i), attributes.getValue(i));
			}
		}
		currentTag = qName; //正在解析的元素
	}
	//解析到每个元素的内容时会调用此方法
	public void characters(char[] ch, int start, int length) throws SAXException{
		if(currentTag != null && map != null) {
			currentValue = new String(ch,start,length);
			
			//如果内容不为空和空格，也不是换行符则钙元素名和值和存入Map中
			if(currentValue != null && !currentValue.trim().equals("") && !currentValue.trim().equals("\n")) {
				 map.put(currentTag, currentValue);
			}
			
			currentTag = null;
			currentValue = null;
		}
	}
	
	//每个元素结束时都会调用这个方法
	@Override
	public void endElement(String uri,String localName,String qName) {
		//判断是否为一个节点结束的元素标签
		if(qName.equals(nodeName)) {
			list.add(map);
			map = null;
		}
	}
	
	//结束解析文档，即解析根元素结束标签时调用该方法
	public void endDocument() throws SAXException {
		super.endDocument();
	}
}
