public class MembruSala extends Persoana {

    public MembruSala(String nume, int id) {
        super(nume, id);
    }

    @Override
    public String toString() {
        return id + " - " + nume;
    }
}