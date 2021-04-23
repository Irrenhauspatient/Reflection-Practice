import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dialog {

    public ArrayList<Mitarbeiter> mitarbeiterliste;
    public ArrayList<Raum> raumliste;

    private Scanner input;

    /**
     * @param args
     */

    public Dialog() {
        input = new Scanner(System.in);

        mitarbeiterliste = new ArrayList<Mitarbeiter>();
        raumliste = new ArrayList<Raum>();

    }

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException {

        Class<?> cls = Dialog.class;
        Object o = cls.getDeclaredConstructor().newInstance();
        ArrayList<String> menue = new ArrayList<String>();

        menue.add("Mitarbeiter anlegen");
        menue.add("Raum anlegen");
        menue.add("Raum reservieren");
        menue.add("Raum reservierungen anzeigen");
        menue.add("Anzahl der reservierungen anzeigen");
        menue.add("Ende");

        new Lib_Dialog().start(menue, o);

    }

    public void Mitarbeiteranlegen() {

        System.out.print("Vorname: ");
        String vorname = input.nextLine();
        System.out.print("\nNachname: ");
        String nachname = input.nextLine();
        System.out.print("\nE-Mail: ");
        String email = input.nextLine();

        Mitarbeiter mitarbeiter = new Mitarbeiter(vorname, nachname, email);
        mitarbeiterliste.add(mitarbeiter);
        System.out.println(String.format("%s wurde angelegt", mitarbeiter.toString()));
        System.out.println();
        return;
    }

    public void Raumanlegen() {

        System.out.print("Gebäude: ");
        int gebäude = input.nextInt();
        System.out.print("\nEtage: ");
        int etage = input.nextInt();
        System.out.print("\nRaum: ");
        int raumNr = input.nextInt();

        Raum raum = new Raum(gebäude, etage, raumNr);
        raumliste.add(raum);
        System.out.println(String.format("%s wurde angelegt", raum.toString()));
        System.out.println();
    }

    public void Raumreservieren() {

        System.out.println("Raeume:");
        Lib_Dialog.printMenue(raumliste);
        int raumNr = Lib_Dialog.chooseOption();
        Raum raum = raumliste.get(Lib_Arrays.checkNullPointer(raumliste.toArray(), raumNr - 1));

        input.nextLine();
        System.out.println("Mitarbeiter:");
        Lib_Dialog.printMenue(mitarbeiterliste);
        int mitarbeiterNr = Lib_Dialog.chooseOption();
        Mitarbeiter mitarbeiter = mitarbeiterliste
                .get(Lib_Arrays.checkNullPointer(mitarbeiterliste.toArray(), raumNr - 1));

        System.out.print("\nBeginn Uhrzeit:");
        System.out.print("\nStunde:");
        int stundeBeginn = input.nextInt();
        System.out.print("\nMinute:");
        int minuteBeginn = input.nextInt();

        Uhrzeit beginn = new Uhrzeit(stundeBeginn, minuteBeginn);

        System.out.print("Ende Uhrzeit:\n");
        System.out.print("\nStunde:");
        int stundeEnde = input.nextInt();
        System.out.print("\nMinute:");
        int minuteEnde = input.nextInt();

        Uhrzeit ende = new Uhrzeit(stundeEnde, minuteEnde);

        input.nextLine();
        System.out.print("\nBemerkung:");
        String bemerkung = input.nextLine();

        mitarbeiter.reserviere(raum, beginn, ende, bemerkung);
    }

    public void Raumreservierungenanzeigen() {
        Lib_Dialog.printMenue(raumliste);
    }

    public void Anzahlderreservierungenanzeigen() {

        for (Raum raum : raumliste) {

            System.out.println(String.format("Anzahl an Reservierungen: %d für %s", raum.getAnzahlReservierungen(),
                    raum.toString()));

        }

    }

}
