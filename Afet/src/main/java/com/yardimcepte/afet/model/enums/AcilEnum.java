package com.yardimcepte.afet.model.enums;

public enum AcilEnum {
    NORMAL(0, "Normal"), ACIL(1, "Acil");
    private final int id;
    private final String label;

    AcilEnum(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public static String getLabelById(int id) {
        return switch (id) {
            case 1 -> ACIL.label;
            default -> NORMAL.label;
        };
    }
}
