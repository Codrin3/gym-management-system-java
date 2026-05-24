public class ClasaSala {
    private String nume;
    private String tip;
    private int capacitate;

    public ClasaSala(String nume, String tip, int capacitate) {
        this.nume = nume;
        this.tip = tip;
        this.capacitate = capacitate;
    }

    public String getNume() {
        return nume;
    }

    public String getTip() {
        return tip;
    }

    public int getCapacitate() {
        return capacitate;
    }

    @Override
    public String toString() {
        return nume + " - Tip: " + tip + " - Capacitate: " + capacitate;
    }
}