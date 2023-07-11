package com.yardimcepte.afet.model.enums;

public enum KisiDurumEnum {
	IYI(0, "İyi"), KAYIP(1, "Kayıp");
	private final int id;
	private final String label;

	KisiDurumEnum(int id, String label) {
		this.id = id;
		this.label = label;
	}

	public static KisiDurumEnum getKisiDurumById(int id) {
		return switch (id) {
			case 1 -> KisiDurumEnum.KAYIP;
			default -> KisiDurumEnum.IYI;
		};
	}

	public static String getLabelById(int id) {
		return switch (id) {
			case 1 -> KisiDurumEnum.KAYIP.label;
			default -> KisiDurumEnum.IYI.label;
		};
	}

}
