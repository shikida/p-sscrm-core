package com.shikida.psscrm.core.model;

public class Answer {
	private String id;
	private String text;
	private double weight;
	
	public Answer(String id, String text, double weight) {
		super();
		this.id = id;
		this.text = text;
		this.weight = weight;
	}
	public Answer() {
		super();
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
