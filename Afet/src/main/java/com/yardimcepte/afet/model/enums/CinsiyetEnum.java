package com.yardimcepte.afet.model.enums;

import lombok.Getter;

@Getter
public enum CinsiyetEnum {
	KADIN(0, "Kadın"), ERKEK(1, "Erkek");

	private final int id;
	private final String label;

	CinsiyetEnum(int id, String label) {
		this.id = id;
		this.label = label;
	}

	public static String getLabelById(int id) {
		return switch (id) {
			case 1 -> CinsiyetEnum.ERKEK.label;
			default -> CinsiyetEnum.KADIN.label;
		};
	}
}
