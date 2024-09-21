package com.shikida.psscrm.core.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Model {
	private Set<Group> groups = new LinkedHashSet<>();
	private Map<String, String> metadata = new LinkedHashMap<>();
	private String version;

	public Model() {
		super();
	}

	public Model(String version, Group... groups) {
		super();
		this.version = version;
		this.groups.addAll(Arrays.asList(groups));
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public String getVersion() {
		return version;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
