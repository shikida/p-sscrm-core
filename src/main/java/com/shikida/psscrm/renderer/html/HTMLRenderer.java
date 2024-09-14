package com.shikida.psscrm.renderer.html;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.shikida.psscrm.core.model.Model;
import com.shikida.psscrm.core.persistence.PersistenceUtil;

public class HTMLRenderer {

	private static final File HTML_DIR = new File("html");
	private static final File HTML_FILE = new File(HTML_DIR,"p-sscrm-1_0.html");

	public static void main(String[] args) throws IOException {

		Model model = PersistenceUtil.load("p-sscrm-1_0.json");
		render(model);

	}
	
	public static void render(Model m) throws IOException {

		Document doc = Document.createShell("");

		Element h1 = doc.body().appendElement("h1").text("P-SSCRM");

		FileWriter fw = new FileWriter(HTML_FILE);
		
		fw.write(doc.toString());
		
		fw.flush();
		fw.close();


	}

}
