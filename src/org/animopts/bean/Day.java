package org.animopts.bean;

import java.util.HashMap;
import java.util.Map;

public enum Day {
	MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6);

	private final int value;

	Day(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	private static final Map<Integer, Day> intToTypeMap = new HashMap<Integer, Day>();
	static {
		for (Day type : Day.values()) {
			intToTypeMap.put(type.value, type);
		}
	}

	public static Day valueOf(int i) {
		Day type = intToTypeMap.get(Integer.valueOf(i));
		if (type == null)
			return Day.MON;
		return type;
	}

	public String toString() {
		return "banana";
	}
}
