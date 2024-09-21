package com.shikida.psscrm.renderer.html;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.shikida.psscrm.core.model.Answer;
import com.shikida.psscrm.core.model.Group;
import com.shikida.psscrm.core.model.Model;
import com.shikida.psscrm.core.model.Practice;
import com.shikida.psscrm.core.model.Question;
import com.shikida.psscrm.core.model.Reference;
import com.shikida.psscrm.core.model.Task;
import com.shikida.psscrm.core.persistence.PersistenceUtil;

public class HTMLRenderer {

	private static final File HTML_DIR = new File("html");
	private static final File HTML_FILE = new File(HTML_DIR,"p-sscrm-1_0.html");

	private static Document doc = Document.createShell("");
	
	public static void main(String[] args) throws IOException {

		Model model = PersistenceUtil.load("p-sscrm-1_0.json");
		render(model);

	}
	
	public static void render(Model m) throws IOException {

		doc.head().appendElement("title").text("P-SSCRM "+m.getVersion());
		
		Element md = createUnorderedList(doc.body());
		createListItems(md,m.getMetadata());
		
		for(Group group:m.getGroups()) {
			
			Element g = createUnorderedList(doc.body(),group);
		
			for(Practice practice:group.getPractices()) {
				
				Element p = createUnorderedList(g,practice);
				
				for(Task task:practice.getTasks()) {
					
					Element t = createUnorderedList(p,task);
					
					for(Question question:task.getQuestions()) {
						
						Element q = createUnorderedList(t,question);
						
						for(Answer answer:question.getAnswers()) {
							
							Element a = createUnorderedList(q,answer);	
							
						}
						
					}
					
					for(Reference reference:task.getReferences()) {
						
						Element r = createUnorderedList(t,reference);
						
						for(String section:reference.getSections()) {
							
							createUnorderedList(r,section);
							
						}
						
					}
					
				}
				
			}
			
		}

		FileWriter fw = new FileWriter(HTML_FILE);
		fw.write(doc.toString());
		fw.flush();
		fw.close();


	}

	private static Element createUnorderedList(Element ul, Answer answer) {
		Element el = createUnorderedList(ul);
		createListItem(el,answer.getId());
		createListItem(el,answer.getText());
		createListItem(el,answer.getWeight());
		return el;
	}

	private static Element createUnorderedList(Element ul, String s) {
		Element el = createUnorderedList(ul);
		createListItem(el,s);
		return el;
	}

	private static Element createUnorderedList(Element ul, Reference reference) {
		Element el = createUnorderedList(ul);
		createListItem(el,reference.getSource());
		return el;
	}

	private static Element createUnorderedList(Element ul, Question question) {
		Element el = createUnorderedList(ul);
		createListItem(el,question.getId());
		createListItem(el,question.getText());
		return el;
	}

	private static Element createUnorderedList(Element ul, Task task) {
		Element el = createUnorderedList(ul);
		createListItem(el,task.getId());
		createListItem(el,task.getName());
		createListItem(el,task.getDefinition());
		return el;
	}

	private static void createListItems(Element md, Map<String, String> map) {
		for(Entry<String,String> m:map.entrySet()) {
			createListItem(md,m.getKey()+":"+m.getValue());	
		}
	}

	private static Element createUnorderedList(Element ul, Practice practice) {
		Element el = createUnorderedList(ul);
		createListItem(el,practice.getId());
		createListItem(el,practice.getName());
		createListItem(el,practice.getDescription());
		return el;
	}

	private static Element createUnorderedList(Element ul, Group group) {
		Element el = createUnorderedList(ul);
		createListItem(el,group.getId());
		createListItem(el,group.getName());
		createListItem(el,group.getDescription());	
		return el;
	}

	private static Element createUnorderedList(Element el) {
		Element ul = el.appendElement("ul");
		return ul;
	}

	private static Element createListItem(Element el, String text) {
		Element li = el.appendElement("li");
		li.text(text);
		return li;
	}

	private static Element createListItem(Element el, double d) {
		Element li = el.appendElement("li");
		li.text(String.valueOf(d));
		return li;
	}


}
