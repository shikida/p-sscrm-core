package com.shikida.psscrm.core.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reference {

	private List<String> sections = new ArrayList<>();

	private String source;

	public Reference() {
		super();
	}

	public Reference(String source, String... sections) {
		super();
		this.source = source;
		this.sections.addAll(Arrays.asList(sections));
	}

	public List<String> getSections() {
		return sections;
	}

	public String getSource() {
		return source;
	}

	public void setSections(List<String> sections) {
		this.sections = sections;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
