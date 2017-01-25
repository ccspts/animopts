package org.animopts.bean;

import java.util.HashMap;
import java.util.Map;

public enum Time {
	_730(1), _915(2), _1100(3), _1245(4), _215(5), _400(6), _600(7);

	private final int value;

	Time(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	private static final Map<Integer, Time> intToTypeMap = new HashMap<Integer, Time>();
	static {
		for (Time type : Time.values()) {
			intToTypeMap.put(type.value, type);
		}
	}

	public static Time valueOf(int i) {
		Time type = intToTypeMap.get(Integer.valueOf(i));
		if (type == null)
			return Time._730;
		return type;
	}
}
