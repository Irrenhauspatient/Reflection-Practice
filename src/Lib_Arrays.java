
public class Lib_Arrays {

    /**
     * Zählt die einträge in dem Array und gibt die Anzahl zurück
     * 
     * @param array zu prüfendes Array
     * @return int anzahl der Einträge im Array
     */
    public static int countIndex(Object[] array) {

        int counter = 0;

        for (Object object : array) {

            counter++;
        }
        return counter;
    }

    /**
     * Überprüft ob der Index im Array null ist
     * 
     * @param array zu prüfendes Array
     * @param index eintrag im Array
     */
    public static int checkNullPointer(Object[] array, int index) {

        if (array[index] != null) {
            return index;
        }
        throw new NullPointerException(Lib_Message.errorNullPointerArray(index));

    }
}
