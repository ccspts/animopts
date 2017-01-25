package org.animopts.bean;

import java.util.HashMap;
import java.util.Map;

public enum PageSection {
	NONE(""), DASHBOARD("dashboard/");

	private final String value;

	PageSection(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	private static final Map<String, PageSection> intToTypeMap = new HashMap<String, PageSection>();
	static {
		for (PageSection type : PageSection.values()) {
			intToTypeMap.put(type.value, type);
		}
	}
}
