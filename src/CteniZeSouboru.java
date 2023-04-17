
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class CteniZeSouboru {
        private final static String ODDELOVAC = ";";
        private final static String SOUBOR = "Deskovky.txt";
        private List<Deskovky> listDeskovky = new ArrayList<>();

        public void vypis(){
            try {
                Scanner scanner = new Scanner(new BufferedReader(new FileReader(SOUBOR)));
                listDeskovky.clear();
                while (scanner.hasNextLine()){
                    String radek = scanner.nextLine();
                    String[] casti = radek.split(ODDELOVAC);
                    String nazev = casti[0];
                    int oblibenost = Integer.parseInt(casti[1]);
                    boolean koupeno = Boolean.parseBoolean(casti[2]);
                    Deskovky deskovky = new Deskovky(nazev, oblibenost, koupeno);
                    listDeskovky.add(deskovky);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public List<Deskovky> getListDeskovky() {
            return listDeskovky;
        }
    }

