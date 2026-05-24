public abstract class Persoana {
    protected String nume;
    protected int id;

    public Persoana(String nume, int id) {
        this.nume = nume;
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public int getId() {
        return id;
    }

    @Override
    public abstract String toString();
}