package model;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Group implements Comparable<Group> {

	private String description;
	private String id;
	private String name;
	private Set<Practice> practices = new TreeSet<>();

	public Group() {
		super();
	}

	public Group(String id, String name, String description, Practice... practices) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.practices.addAll(Arrays.asList(practices));
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

	public Set<Practice> getPractices() {
		return practices;
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

	public void setPractices(Set<Practice> practices) {
		this.practices = practices;
	}

	@Override
	public int compareTo(Group o) {
		return this.id.compareTo(o.id);
	}

}
