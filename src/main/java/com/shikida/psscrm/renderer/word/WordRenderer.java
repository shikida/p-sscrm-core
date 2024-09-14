package com.shikida.psscrm.renderer.word;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.shikida.psscrm.core.model.Model;
import com.shikida.psscrm.core.persistence.PersistenceUtil;

public class WordRenderer {
	
	private static final File WORD_DIR = new File("word");
	private static final File WORD_FILE = new File(WORD_DIR,"p-sscrm-1_0.docx");

	public static void main(String[] args) throws IOException {

		Model model = PersistenceUtil.load("p-sscrm-1_0.json");
		render(model);

	}
	
	public static void render(Model m) throws IOException {
		
		XWPFDocument doc = new XWPFDocument();
		XWPFParagraph title = doc.createParagraph();
		XWPFRun run = title.createRun();
		run.setText("P-SSCRM");
		
		FileOutputStream out = new FileOutputStream(WORD_FILE);
		doc.write(out);
		out.close();
		doc.close();
	}

}
