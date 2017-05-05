package com.spring.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class BeanFactory {
	//private static List<Definition> defs;
	private static Map<String,Object> map = new TreeMap<String, Object>();
	private static Map<String,Object> simMap = new TreeMap<String, Object>();
	public static void main(String[] args) {
		try {
			pareXML();
			System.out.println(map.size());
			System.out.println(simMap.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static void pareXML() throws FileNotFoundException, JDOMException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		SAXBuilder sb = new SAXBuilder();
		Document dc = sb.build(new FileInputStream("src/main/resources/applicationContext.xml"));
		Element element = dc.getRootElement();
		List<Element> elements = element.getChildren();
		for(Element e : elements) {
			//System.out.println(e);
			String id = e.getAttributeValue("id");
			String clazzName = e.getAttributeValue("class");
			String singleton = e.getAttributeValue("singleton");
			//System.out.println(id+":"+clazzName+":"+singleton);
			boolean isTrue = true;
			if(!"true".equals(singleton)){
				isTrue = false;
			}
//			Definition def = new Definition();
//			def.setId(id);
//			def.setClazzName(clazzName);
//			def.setTrue(isTrue);
			Class<?> c = Class.forName(clazzName);
			Object in = c.newInstance();
			//defs.add(def);
			if(isTrue) {
				map.put(id, in);
			}else {
				simMap.put(id, in);
			}
		}
	}
	
	public static Object getBean(String id) {
		if(map.containsKey(id)) {
			return map.get(id);
		}
		if(simMap.containsKey(id)) {
			return simMap.get(id);
		}
		return null;
	}

}
