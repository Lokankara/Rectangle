package com.test.horstmann.io;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class RegExp {


	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Pattern pattern = Pattern.compile("\\pL{4,}");
		Matcher matcher = pattern.matcher("Mary had a little lamb");
		String replaceAll = matcher.replaceAll(m -> m.group().toUpperCase());
		System.out.println(replaceAll);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		File file = new File("c:\\Users\\PPoliak\\eclipse-workspace\\lab\\pom.xml");
		Document doc = builder.parse(file);
		Element root = doc.getDocumentElement();
		NodeList children = root.getChildNodes();

		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (child instanceof Element) {
				var childElement = (Element) child;
				var textNode = (Text) childElement.getFirstChild();
				String text = textNode.getData().trim();
				if (childElement.getTagName().equals("artifactId"))
					System.out.println(text);
				else if (childElement.getTagName().equals("version"))
					System.out.println(Integer.parseInt(text));
			}
		}
//			URL u = . . .;
//			Document doc = builder.parse(u.toString());
//
//			InputStream in = . . .;
//			Document doc = builder.parse(in);

	}
}
