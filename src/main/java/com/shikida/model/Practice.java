package com.shikida.model;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Practice implements Comparable<Practice>{

	private String description;
	private String id;
	private String name;
	private Set<Task> tasks = new LinkedHashSet<>();

	public Practice() {
		super();
	}

	public Practice(String id, String name, String description, Task... tasks) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.tasks.addAll(Arrays.asList(tasks));
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public int compareTo(Practice o) {
		return this.id.compareTo(o.id);
	}

}
