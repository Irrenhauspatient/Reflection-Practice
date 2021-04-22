
public class Message {

    /**
     * @param min
     * @param max
     * @return String
     */
    public static String errorWrongValueSpan(int min, int max, String fieldname) {
        return String.format("Der eingegebene Wert bei %s unterschreitet %d oder überschreitet %d", fieldname, min,
                max);
    }

    /**
     * @param min
     * @param max
     * @param fieldname
     * @return String
     */
    public static String errorWrongValueSpan(double min, double max, String fieldname) {
        return String.format("Der eingegebene Wert bei %s unterschreitet %d oder überschreitet %d", fieldname, min,
                max);
    }

    /**
     * @param min
     * @param fieldname
     * @return String
     */
    public static String errorWrongValueMin(int min, String fieldname) {
        return String.format("Der eingegebene Wert bei %s unterschreitet %d", fieldname, min);
    }

    /**
     * @param min
     * @param fieldname
     * @return String
     */
    public static String errorWrongValueMin(double min, String fieldname) {
        return String.format("Der eingegebene Wert bei %s unterschreitet %d", fieldname, min);
    }

    /**
     * @param max
     * @param fieldname
     * @return String
     */
    public static String errorWrongValueMax(int max, String fieldname) {
        return String.format("Der eingegebene Wert bei %s überschreitet %d", fieldname, max);
    }

    /**
     * @param max
     * @param fieldname
     * @return String
     */
    public static String errorWrongValueMax(double max, String fieldname) {
        return String.format("Der eingegebene Wert bei %s überschreitet %d", fieldname, max);
    }

    /**
     * @param fieldname
     * @return String
     */
    public static String errorEmptyString(String fieldname) {
        return String.format("Das Feld %s darf nicht leer sein", fieldname);
    }

    /**
     * @param index
     * @return String
     */
    public static String errorNullPointerArray(int index) {
        return String.format("Der angegeben Index %d ist nicht belegt", index);
    }

}
