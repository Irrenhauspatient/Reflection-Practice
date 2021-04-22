
public class Reservierung {

    private Raum raum;
    private Mitarbeiter von;
    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;

    public Reservierung(Uhrzeit beginn, Uhrzeit ende) {
        this.beginn = beginn;
        this.ende = ende;
    }

    /**
     * @param mitarbeiter
     */
    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.von = mitarbeiter;
    }

    /**
     * @param raum
     */
    public void setRaum(Raum raum) {
        this.raum = raum;

    }

    /**
     * @param bemerkung
     */
    public void setBemerkung(String bemerkung) {
        Lib_String.checkIfNullOrEmpty(bemerkung, "Bemerkung");
        this.bemerkung = Lib_String.AllWhitespaceToOne(bemerkung);
    }

    /**
     * @return String
     */
    public String getBemerkung() {
        return bemerkung;
    }

    /**
     * @return Uhrzeit
     */
    public Uhrzeit getBeginn() {
        return beginn;
    }

    /**
     * @return Uhrzeit
     */
    public Uhrzeit getEnde() {
        return ende;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s von %s bis %s für %s", von, beginn, ende, bemerkung);
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
        Reservierung other = (Reservierung) obj;
        if (beginn == null) {
            if (other.beginn != null)
                return false;
        } else if (!beginn.equals(other.beginn))
            return false;
        if (bemerkung == null) {
            if (other.bemerkung != null)
                return false;
        } else if (!bemerkung.equals(other.bemerkung))
            return false;
        if (ende == null) {
            if (other.ende != null)
                return false;
        } else if (!ende.equals(other.ende))
            return false;
        if (raum == null) {
            if (other.raum != null)
                return false;
        } else if (!raum.equals(other.raum))
            return false;
        if (von == null) {
            if (other.von != null)
                return false;
        } else if (!von.equals(other.von))
            return false;
        return true;
    }

}