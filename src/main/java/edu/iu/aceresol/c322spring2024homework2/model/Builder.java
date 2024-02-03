package edu.iu.aceresol.c322spring2024homework2.model;

public enum Builder {
   FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS,ANY;

   public String toString() {
       switch(this) {
           case FENDER -> {
               return "Fender";
           }
           case MARTIN -> {
               return "Martin";
           }
           case GIBSON -> {
               return "Gibson";
           }
           case COLLINGS -> {
               return "Collings";
           }
           case OLSON -> {
               return "Olson";
           }
           case RYAN -> {
               return "Ryan";
           }
           case PRS -> {
               return "PRS";
           }
           default -> {
               return "Unspecified";
           }
       }
   }
    public static Builder fromString(String text) {
        switch(text) {
            case "Fender" -> {
                return FENDER;
            }
            case "Martin" -> {
                return MARTIN;
            }
            case "Gibson" -> {
                return GIBSON;
            }
            case "Collings" -> {
                return COLLINGS;
            }
            case "Olson" -> {
                return OLSON;
            }
            case "Ryan" -> {
                return RYAN;
            }
            case "PRS" -> {
                return PRS;
            }
            default -> {
                return ANY;
            }
        }
    }
}
