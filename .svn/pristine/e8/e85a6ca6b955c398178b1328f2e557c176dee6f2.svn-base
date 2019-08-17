package cn.com.infosec;

import java.io.File;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlFile {

	private Document document;
	private String filename;

	public XmlFile() {
		super();
	}

	public Document getDocument() {
		return this.document;
	}

	public XmlFile(String filename) {
		this.filename = filename;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getFilename() {
		return this.filename;
	}

	public void printXmlFile(String filename) throws Exception {
		SAXReader reader = new SAXReader();
		this.document = reader.read(new File(filename != null ? filename : this.filename));
		System.out.println(this.document.asXML());
	}

	public Document readXmlFile(String filename) throws Exception {
		SAXReader reader = new SAXReader();
		this.document = reader.read(new File(filename != null ? filename : this.filename));
		return this.document;
	}

	public String getXmlContentValue(String xpath) throws Exception {
		Node node = this.document.selectSingleNode(xpath);
		if (node == null) {
			return null;
		}

		return node.getText();
	}

	public String getXmlAttrValue(String xpath, String attrName) throws Exception {
		Node node = this.document.selectSingleNode(xpath);
		if (node == null) {
			return null;
		}

		return node.valueOf("@" + attrName);
	}

	public boolean setXmlContentValue(String xpath, String contentValue, boolean cdata) throws Exception {
		Element element = (Element) this.document.selectSingleNode(xpath);
		if (element == null) {
			return false;
		}

		if (cdata) {
			element.clearContent();
			element.addCDATA(contentValue);
		} else {
			element.setText(contentValue);
		}
		return true;
	}

	public boolean setXmlAttrValue(String xpath, String attrName, String attrValue) throws Exception {
		Element element = (Element) this.document.selectSingleNode(xpath);
		if (element == null) {
			return false;
		}

		element.addAttribute(attrName, attrValue);
		return true;
	}

	public void writeXmlFile(String filename) throws Exception {
		XMLWriter writer = new XMLWriter(new FileWriter(filename != null ? filename : this.filename));
		writer.write(this.document);
		writer.close();
	}

}
