
public class Mitarbeiter extends Person {

    private String email;

    /**
     * Konstruktor mit 3 Parametern
     * 
     * @param vorname  für Vorname des Mitarbeiteres, wird übergeben an Konstruktor
     *                 der Klasse Person
     * @param nachname für Nachname des Mitarbeiters, wird übergeben an Konstruktor
     *                 der Klasse Person
     * @param email    für Email des Mitarbeiters
     */
    Mitarbeiter(String vorname, String nachnahme, String email) {
        super(vorname, nachnahme);
        setEmail(email);

    }

    /**
     * Methode zum Reservieren eines Raumes durch einen Mitarbeiter
     * 
     * @param raum      für den ausgewählten Raum
     * @param beginn    für die Beginnuhrzeit der Reservierung
     * @param ende      für die Enduhrzeit der Reservierung
     * @param bemerkung für eine zugehörige Bemerkung
     */
    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung) {

        Lib_String.checkIfNullOrEmpty(bemerkung, "bemerkung");
        Reservierung reservierung = new Reservierung(beginn, ende);
        reservierung.setBemerkung(bemerkung);
        reservierung.setMitarbeiter(this);
        reservierung.setRaum(raum);
        raum.addReservierung(reservierung);

    }

    /**
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {

        Lib_String.checkIfNullOrEmpty(email, "email");
        this.email = Lib_String.RemoveAllWhitespaces(email);
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s %s (%s)", getVorname(), getNachname(), getEmail());
    }

    /**
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mitarbeiter other = (Mitarbeiter) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

}
