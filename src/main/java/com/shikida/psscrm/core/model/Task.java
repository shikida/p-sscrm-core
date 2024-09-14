package com.shikida.psscrm.core.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Task {

	private String definition;
	private String id;
	private String name;
	private String objective;
	private Set<String> questions = new LinkedHashSet<>();
	private Set<Reference> references = new LinkedHashSet<>();

	public Task() {
		super();
	}

	public Task(String id, String name, String objective, String definition) {
		super();
		this.id = id;
		this.name = name;
		this.objective = objective;
		this.definition = definition;
	}

	public void addReference(String source, String... sections) {
		this.references.add(new Reference(source, sections));
	}

	public void addQuestion(String question) {
		this.questions.add(question);
	}

	public String getDefinition() {
		return definition;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getObjective() {
		return objective;
	}

	public Set<String> getQuestions() {
		return questions;
	}

	public Set<Reference> getReferences() {
		return references;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public void setQuestions(Set<String> questions) {
		this.questions = questions;
	}

	public void setReferences(Set<Reference> references) {
		this.references = references;
	}

}
