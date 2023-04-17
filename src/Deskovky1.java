public class Deskovky1 {
    private String nazev;
    private boolean koupeno;
    private int oblibenost;

    public Deskovky1(String nazev, boolean koupeno, int oblibenost) {
        this.nazev = nazev;
        this.koupeno = koupeno;
        this.oblibenost = oblibenost;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean isZakoupeno() {
        return koupeno;
    }

    public void setZakoupeno(boolean zakoupeno) {
        this.koupeno = zakoupeno;
    }

    public int getOblibenost() {
        return oblibenost;
    }

    public void setOblibenost(int oblibenost) {
        this.oblibenost = oblibenost;
    }
}

