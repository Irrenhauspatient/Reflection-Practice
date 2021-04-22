import java.util.ArrayList;

public class Raum {

    private int geb;
    private int etage;
    private int raum;

    private ArrayList<Reservierung> reservierung;

    /**
     * Konstruktor mit 3 Parametern
     * 
     * @param geb   für Gebäude
     * @param etage für Etage
     * @param raum  für Raum
     */

    public Raum(int geb, int etage, int raum) {
        setGeb(geb);
        setEtage(etage);
        setRaum(raum);
        this.reservierung = new ArrayList<>();

    }

    /**
     * Methode zum Hinzufügen einer Reservierung
     * 
     * @param reservierung Objekt der Klasse Reservierung
     */
    public void addReservierung(Reservierung reservierung) {
        this.reservierung.add(reservierung);
    }

    /**
     * @return int
     */
    public int getGeb() {
        return geb;
    }

    /**
     * @param geb
     */
    public void setGeb(int geb) {
        Lib_Digits.checkSpan(0, Integer.MAX_VALUE, geb, "geb");
        this.geb = geb;
    }

    /**
     * @return int
     */
    public int getEtage() {
        return etage;
    }

    /**
     * @param etage
     */
    public void setEtage(int etage) {
        Lib_Digits.checkSpan(0, Integer.MAX_VALUE, etage, "etage");
        this.etage = etage;
    }

    /**
     * @return int
     */
    public int getRaum() {
        return raum;
    }

    /**
     * @param raum
     */
    public void setRaum(int raum) {
        Lib_Digits.checkSpan(0, Integer.MAX_VALUE, raum, "raum");
        this.raum = raum;
    }

    /**
     * @param index
     * @return Reservierung
     */
    public Reservierung getReservierung(int index) {
        Lib_Arrays.checkNullPointer(reservierung.toArray(), index);
        return reservierung.get(index);
    }

    /**
     * @return int anzahl der Reservierungen die ein Raum besitzt
     */
    public int getAnzahlReservierungen() {

        return Lib_Arrays.countIndex(reservierung.toArray());
    }

    public ArrayList<Reservierung> getReservierungsListe() {
        return reservierung;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Raum %d-%d.%d", geb, etage, raum));
        reservierung.forEach(reservierung -> sb.append("\ngebucht von " + reservierung));
        return sb.toString();

    }

    /**
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Raum other = (Raum) obj;
        if (etage != other.etage)
            return false;
        if (geb != other.geb)
            return false;
        if (raum != other.raum)
            return false;
        return true;
    }

}
