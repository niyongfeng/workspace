package com.pengrui.jdom;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jTest {
	public static void main(String[] args) throws DocumentException {
		for(Object obj : new SAXReader().read("/Users/niyongfeng/Documents/workspace/d03.20/NewFile.xml").getRootElement().elements()) {
			Element element = (Element) obj;
			if(!"student".equals(element.getName())) {
				continue;
			}
			
			System.out.println("------student" + element.attributeValue("id") + "------");
			System.out.println("id:" + element.attributeValue("id"));
			System.out.println("name:" + element.elementText("name"));
			System.out.println("gender:" + element.elementText("gender"));
			System.out.println("age:" + element.elementText("age"));
		}
	}
}
