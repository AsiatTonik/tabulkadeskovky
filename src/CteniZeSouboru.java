import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CteniZeSouboru {

    private static List<Deskovky1> list = new ArrayList<>();

    protected static List<Deskovky1> vypisSoubor(String nazevSouboru, String oddelovac) {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(nazevSouboru)));
            while (sc.hasNextLine()) {
                String radek = sc.nextLine();
                String[] polozka = radek.split(oddelovac);
                String nazev = polozka[0];
                Boolean koupeno = Boolean.parseBoolean(polozka[1]);
                int oblibenost = Integer.parseInt(polozka[2]);
                list.add(new Deskovky1(nazev, koupeno, oblibenost));

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return new ArrayList<>(list);
    }

    public List<Deskovky1> pocetSouboru() {
        list.size();
        return new ArrayList<>(list);
    }
}