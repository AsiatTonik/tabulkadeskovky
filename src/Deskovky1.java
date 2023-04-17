public class Deskovky1 {
    private String nazev;
    private int oblibenost;
    private boolean koupeno;

    public Deskovky1(String nazev, int oblibenost, boolean koupeno) {
        this.nazev = nazev;
        this.oblibenost = oblibenost;
        this.koupeno = koupeno;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getOblibenost() {
        return oblibenost;
    }

    public void setOblibenost(int oblibenost) {
        this.oblibenost = oblibenost;
    }

    public boolean isKoupeno() {
        return koupeno;
    }

    public void setKoupeno(boolean koupeno) {
        this.koupeno = koupeno;
    }
}
