package com.pengrui.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomService {
	public static List<Map<String,String>> readXML(String uri, String nodeName) {
		List<Map<String,String>> result = new ArrayList<Map<String,String>>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(uri);
			//1.获得文档根元素对对象
			Element root = document.getDocumentElement();
			//获得文档根元素下一级子元素所有元素
			NodeList nodeList = root.getChildNodes();
			
			System.out.println(root.getNodeName());
			
			//System.out.println(nodeList.getLength());
			if(null != root) {
				for(int i = 0; i < nodeList.getLength(); i++) {
					Map<String,String> student = new HashMap<String,String>();
					Node child = nodeList.item(i);
					//System.out.println(child);
					if(!nodeName.equals(child.getNodeName())) {
						continue;
					}
					//输出child属性
					String id = child.getAttributes().getNamedItem("id").getNodeValue();
					System.out.print(child.getAttributes().getNamedItem("id").getNodeName() + ":" + id + " ");
					
					student.put("id", id);
					for(Node node = child.getFirstChild(); node != null; node = node.getNextSibling()) {
						if(node.getNodeType() == Node.ELEMENT_NODE) {
							if("name".equals(node.getNodeName())) { 
								System.out.print(node.getNodeName() + ":" + node.getFirstChild().getNodeValue() + " ");
								student.put(node.getNodeName(), node.getFirstChild().getNodeValue());
							}else if("gender".equals(node.getNodeName())) {
								System.out.print(node.getNodeName() + ":" + node.getFirstChild().getNodeValue() + " ");
								student.put("gender", node.getFirstChild().getNodeValue());
							}else if("age".equals(node.getNodeName())) {
								System.out.print(node.getNodeName() + ":" + node.getFirstChild().getNodeValue() + "\n");
								student.put("age", node.getFirstChild().getNodeValue());
							}
						}
					}
					result.add(student);
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
