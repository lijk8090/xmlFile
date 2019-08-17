package cn.com.infosec;

public class XmlMain {

	public static void main(String[] args) throws Exception {
		String filename = "src/cfg/caServer.xml";
		String filename1 = "src/cfg/caServer1.xml";
		String xpath = "/caServer/signKey[1]";
		String attr = "passwd";

		XmlFile xmlFile = new XmlFile(filename);

		xmlFile.printXmlFile(filename);

		xmlFile.readXmlFile(filename);

		xmlFile.setXmlContentValue(xpath, "key.pem", false);
		System.out.println(xmlFile.getXmlContentValue(xpath));

		xmlFile.setXmlAttrValue(xpath, attr, "123456");
		System.out.println(xmlFile.getXmlAttrValue(xpath, attr));

		xmlFile.writeXmlFile(filename1);
	}

}
