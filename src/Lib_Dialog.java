import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lib_Dialog {

    private static final int ENDE = 6;
    private int option = -1;

    private static Scanner input;
    private static int optioncounter;

    /**
     * Eigentliche Startmethode
     */

    public void start(ArrayList<String> menue, String className) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        input = new Scanner(System.in);

        Class<?> cls = Class.forName(className);
        Object o = cls.getDeclaredConstructor().newInstance();

        while (option != ENDE) {
            try {
                printMenue(menue);
                option = chooseOption();
                ausfuehrenFunktion(menue, option, o);
            } catch (InputMismatchException msg) {
                System.out.println("\n" + msg + ": Kein korrekter Wert");
                input.nextLine();
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
        }

    }

    public static <T> int printMenue(ArrayList<T> arraylist) {

        StringBuilder sb = new StringBuilder();
        optioncounter = 0;

        for (T string : arraylist) {

            optioncounter++;
            sb.append(String.format("%d: %s\n", optioncounter, string));

        }
        System.out.println(sb);
        return optioncounter;

    }

    public static int chooseOption() {

        System.out.print("\nBitte wählen sie eine Option\n");
        return input.nextInt();
    }

    public static void ausfuehrenFunktion(ArrayList<String> menue, int option, Object o)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Method method = o.getClass().getDeclaredMethod(Lib_String.RemoveAllWhitespaces(menue.get(option - 1)));
        method.invoke(o);
    }

}
