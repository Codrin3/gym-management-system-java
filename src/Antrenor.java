public class Antrenor extends Persoana {
    private String specializare;

    public Antrenor(String nume, int id, String specializare) {
        super(nume, id);
        this.specializare = specializare;
    }

    public String getSpecializare() {
        return specializare;
    }

    @Override
    public String toString() {
        return id + " - " + nume + " - Specializare: " + specializare;
    }
}