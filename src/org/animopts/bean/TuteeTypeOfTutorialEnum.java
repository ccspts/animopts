package org.animopts.bean;

import java.util.HashMap;
import java.util.Map;

public enum TuteeTypeOfTutorialEnum {
	ONE_ON_ONE(1), WITH_OTHER(2), WITH_FRIEND(3);

	private final int value;

	TuteeTypeOfTutorialEnum(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	private static final Map<Integer, TuteeTypeOfTutorialEnum> intToTypeMap = new HashMap<Integer, TuteeTypeOfTutorialEnum>();
	static {
		for (TuteeTypeOfTutorialEnum type : TuteeTypeOfTutorialEnum.values()) {
			intToTypeMap.put(type.value, type);
		}
	}

	public static TuteeTypeOfTutorialEnum valueOf(int i) {
		TuteeTypeOfTutorialEnum type = intToTypeMap.get(Integer.valueOf(i));
		if (type == null)
			return TuteeTypeOfTutorialEnum.ONE_ON_ONE;
		return type;
	}
}
