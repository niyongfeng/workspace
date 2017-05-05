package com.pengrui.xmltest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomService {
	public static List<Map<String,String>> readXML(String uri, String nodeName) throws Exception {
		List<Map<String,String>> result = new ArrayList<Map<String,String>>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(uri);
		
		Element root = document.getDocumentElement();
		NodeList nodeList = root.getChildNodes();
		
		System.out.println(root.getNodeName());
		
		if(root != null) {
			for(int i = 0; i < nodeList.getLength(); i++) {
				Map<String,String> student = new HashMap<String,String>();
				Node child = nodeList.item(i);
				
				if(!nodeName.equals(child.getNodeName())) {
					continue;
				}
				
				String id = child.getAttributes().getNamedItem("id").getNodeName();
				student.put("id", id);
				
				for(Node node = child.getFirstChild(); node != null; node.getNextSibling()) {
					if(node.getNodeType() == Node.ELEMENT_NODE) {
						if("name".equals(node.getNodeName())) {
							student.put("name", node.getFirstChild().getNodeValue());
						}else if("gender".equals(node.getNodeName())) {
							student.put(node.getNodeName(), node.getFirstChild().getNodeName());
						}else if("age".equals(node.getNodeName())) {
							student.put(node.getNodeName(), node.getFirstChild().getNodeValue());
						}
					}
				}
				result.add(student);
			}
		}
		return result;
		
		
	}
}
