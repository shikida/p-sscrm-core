package com.shikida.psscrm.core.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Question {
	private String id;
	private String text;
	private Set<Answer> answers = new LinkedHashSet<>();
	
	public Question() {
		super();
	}

	public Question(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
	
}
