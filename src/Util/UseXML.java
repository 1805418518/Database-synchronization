package Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import Model.Database;

public class UseXML {
	/*
	 * public Document parse(File file) throws DocumentException { SAXReader reader
	 * = new SAXReader(); Document document = reader.read(file); return document; }
	 */

	private static String pass = "gancheng";
	
	public static void addDatabase(File file, String type, Database db) {
		Document document = readXML(file);
		addDatabase(document, type, db);
		saveXML(document, file);
	}

	public static void removeDatabase(File file, String type, Database db) {
		Document document = readXML(file);
		removeDatabase(document, type, db);
		saveXML(document, file);
	}

	public static List<Database> getDatabases(File file, String type) {
		Document document = readXML(file);
		return getDatabases(document, type);
	}

	private static Document readXML(File file) {
		if (!file.exists()) {
			Document document = createXML();
			saveXML(document, file);
		}
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}

	private static void saveXML(Document document, File file) {
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(file), format);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Document createXML() {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("databases");

		// Element author1 = root.addElement("author").addAttribute("name",
		// "James").addAttribute("location", "UK").addText("James Strachan");

		return document;
	}

	private static void addDatabase(Document document, String type, Database db) {
		Element root = document.getRootElement();
		root.addElement(type).addAttribute("address", db.getAddress())
				.addAttribute("dbname", db.getDatabaseName()).addAttribute("username", db.getUsername())
				.addAttribute("password", DESUtil.encrypt(pass, db.getPassword()));
	}

	private static void removeDatabase(Document document, String type, Database db) {
		Element root = document.getRootElement();
		for (Iterator<Element> it = root.elementIterator(type); it.hasNext();) {
			Element element = it.next();
			if (element.attributeValue("address").equals(db.getAddress())
					&& element.attributeValue("dbname").equals(db.getDatabaseName())
					&& element.attributeValue("username").equals(db.getUsername())
					&& DESUtil.decrypt(pass, element.attributeValue("password")).equals(db.getPassword())) {
				root.remove(element);
			}
		}
	}

	private static List<Database> getDatabases(Document document, String type) {
		Element root = document.getRootElement();
		List<Database> dbs = new ArrayList<>();
		for (Iterator<Element> it = root.elementIterator(type); it.hasNext();) {
			Element element = it.next();
			dbs.add(new Database(element.attributeValue("address"), element.attributeValue("username"),
					DESUtil.decrypt(pass, element.attributeValue("password")), element.attributeValue("dbname")));
		}
		return dbs;
	}
}
