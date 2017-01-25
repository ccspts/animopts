package org.animopts.bean;

import java.util.HashMap;
import java.util.Map;

public enum AccountLevel {
	GUEST(0), TUTEE(1), TUTOR(2), OFFICER(3), ADMIN(255);

	private final int value;

	AccountLevel(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	private static final Map<Integer, AccountLevel> intToTypeMap = new HashMap<Integer, AccountLevel>();
	static {
		for (AccountLevel type : AccountLevel.values()) {
			intToTypeMap.put(type.value, type);
		}
	}

	public static AccountLevel valueOf(int i) {
		AccountLevel type = intToTypeMap.get(Integer.valueOf(i));
		if (type == null)
			return AccountLevel.GUEST;
		return type;
	}
}
