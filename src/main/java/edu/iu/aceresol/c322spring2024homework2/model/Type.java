package edu.iu.aceresol.c322spring2024homework2.model;

public enum Type {
    ACOUSTIC, ELECTRIC;

    public String toString() {
        switch(this) {
            case ACOUSTIC -> {
                return "acoustic";
            }
            case ELECTRIC -> {
                return "electric";
            }
            default -> {
                return "unspecified";
            }
        }
    }
    public static Type fromString(String text) {
        switch(text) {
            case "acoustic" -> {
                return ACOUSTIC;
            }
            case "electric" -> {
                return ELECTRIC;
            }
            default -> {
                return null;
            }
        }
    }
}
