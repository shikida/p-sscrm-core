package com.shikida.psscrm.core.persistence;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shikida.psscrm.core.model.Model;

public class PersistenceUtil {
	
	private static final File DATA_DIR = new File("data");
	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static void save(Model model, String fileName) throws IOException {
		
		File file = new File(PersistenceUtil.DATA_DIR,fileName);
		FileWriter fw = new FileWriter(file);
		gson.toJson(model, fw);
		fw.flush();
		fw.close();

	}
	
	public static Model load(String fileName) throws IOException {
		
		File file = new File(PersistenceUtil.DATA_DIR,fileName);
		FileReader fr = new FileReader(file);
		Model model = gson.fromJson(fr, Model.class);
		fr.close();

		return model;
	}
	
	
	
}
