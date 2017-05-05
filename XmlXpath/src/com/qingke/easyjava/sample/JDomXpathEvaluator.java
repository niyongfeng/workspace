package com.qingke.easyjava.sample;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.jdom2.xpath.jaxen.JaxenXPathFactory;

public class JDomXpathEvaluator {

    public static void main(String[] args) {
        try {
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build("sample.xml");
            
            Element root = document.getRootElement();
            
            XPathFactory factory = JaxenXPathFactory.instance();
            XPathExpression<Object> xPathExp = factory.compile("//student[./gender='Male']");
            
            List<Object> objectLists = xPathExp.diagnose(root, false).getResult();
            
            for (Object obj : objectLists) {
                Element element = (Element)obj;
                System.out.println(element);
            }
        } catch (JDOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
