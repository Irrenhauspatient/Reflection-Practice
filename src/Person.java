
public class Person {

    private String vorname;
    private String nachname;

    /**
     * Konsstruktor mit 2 Parametern
     * 
     * @param vorname  für Vorname einer Person
     * @param nachname für Nachname einer Person
     */
    Person(String vorname, String nachname) {

        setVorname(vorname);
        setNachname(nachname);
    }

    /**
     * Standardkonstruktor
     */
    Person() {

    }

    /**
     * @return String
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * @param vorname
     */
    public void setVorname(String vorname) {
        Lib_String.checkIfNullOrEmpty(vorname, "vorname");
        this.vorname = Lib_String.AllWhitespaceToOne(vorname);
    }

    /**
     * @return String
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * @param nachname
     */
    public void setNachname(String nachname) {
        Lib_String.checkIfNullOrEmpty(nachname, "nachname");
        this.nachname = Lib_String.AllWhitespaceToOne(nachname);
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s %s", vorname, nachname);
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
        Person other = (Person) obj;
        if (nachname == null) {
            if (other.nachname != null)
                return false;
        } else if (!nachname.equals(other.nachname))
            return false;
        if (vorname == null) {
            if (other.vorname != null)
                return false;
        } else if (!vorname.equals(other.vorname))
            return false;
        return true;
    }

}
