import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GestionareSala {
    private Map<Integer, MembruSala> membri = new HashMap<>();
    private Map<Integer, Antrenor> antrenori = new HashMap<>();
    private Map<String, ClasaSala> clase = new HashMap<>();

    public void adaugaMembru(String nume, int id) {
        membri.put(id, new MembruSala(nume, id));
    }

    public Map<Integer, MembruSala> obtineMembri() {
        return membri;
    }

    public void adaugaAntrenor(String nume, int id, String specializare) {
        antrenori.put(id, new Antrenor(nume, id, specializare));
    }

    public Map<Integer, Antrenor> obtineAntrenori() {
        return antrenori;
    }

    public void adaugaClasa(String nume, String tip, int capacitate) {
        clase.put(nume, new ClasaSala(nume, tip, capacitate));
    }

    public Map<String, ClasaSala> obtineClase() {
        return clase;
    }

    public void salveazaDate() {
        try (PrintWriter membriWriter = new PrintWriter(new FileWriter("membri.txt"));
             PrintWriter antrenoriWriter = new PrintWriter(new FileWriter("antrenori.txt"));
             PrintWriter claseWriter = new PrintWriter(new FileWriter("clase.txt"))) {

            for (MembruSala membru : membri.values()) {
                membriWriter.println(membru.getNume() + "," + membru.getId());
            }

            for (Antrenor antrenor : antrenori.values()) {
                antrenoriWriter.println(antrenor.getNume() + "," + antrenor.getId() + "," + antrenor.getSpecializare());
            }

            for (ClasaSala clasa : clase.values()) {
                claseWriter.println(clasa.getNume() + "," + clasa.getTip() + "," + clasa.getCapacitate());
            }

        } catch (IOException e) {
            System.out.println("Eroare la salvarea datelor: " + e.getMessage());
        }
    }

    public void incarcaDate() {
        membri.clear();
        antrenori.clear();
        clase.clear();

        incarcaFisier("membri.txt", 1);
        incarcaFisier("antrenori.txt", 2);
        incarcaFisier("clase.txt", 3);
    }

    private void incarcaFisier(String numeFisier, int tip) {
        File fisier = new File(numeFisier);
        if (!fisier.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fisier))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] date = linie.split(",");
                if (tip == 1 && date.length == 2) {
                    adaugaMembru(date[0], Integer.parseInt(date[1]));
                } else if (tip == 2 && date.length == 3) {
                    adaugaAntrenor(date[0], Integer.parseInt(date[1]), date[2]);
                } else if (tip == 3 && date.length == 3) {
                    adaugaClasa(date[0], date[1], Integer.parseInt(date[2]));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Eroare la citirea fișierului: " + numeFisier);
        }
    }
}