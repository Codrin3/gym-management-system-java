import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GestionareSala sala = new GestionareSala();

        JFrame frame = new JFrame("Gestionare Sala de Sport");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 450);

        JTextArea zonaAfisare = new JTextArea();
        zonaAfisare.setEditable(false);
        frame.add(new JScrollPane(zonaAfisare), BorderLayout.CENTER);

        JPanel panouButoane = new JPanel(new GridLayout(0, 3, 5, 5));

        JButton btnAdaugaMembru = new JButton("Adaugă Membru");
        JButton btnAfisMembri = new JButton("Afișează Membri");
        JButton btnAdaugaAntrenor = new JButton("Adaugă Antrenor");
        JButton btnAfisAntrenori = new JButton("Afișează Antrenori");

        JButton btnAdaugaClasa = new JButton("Adaugă Clasă");
        JButton btnAfisClase = new JButton("Afișează Clase");

        JButton btnSalveaza = new JButton("Salvează Date");
        JButton btnIncarca = new JButton("Încarcă Date");

        panouButoane.add(btnAdaugaMembru);
        panouButoane.add(btnAfisMembri);
        panouButoane.add(btnAdaugaAntrenor);
        panouButoane.add(btnAfisAntrenori);
        panouButoane.add(btnAdaugaClasa);
        panouButoane.add(btnAfisClase);
        panouButoane.add(btnSalveaza);
        panouButoane.add(btnIncarca);

        frame.add(panouButoane, BorderLayout.SOUTH);

        btnAdaugaMembru.addActionListener(e -> {
            try {
                String nume = JOptionPane.showInputDialog("Nume membru:");
                int id = Integer.parseInt(JOptionPane.showInputDialog("ID membru:"));
                sala.adaugaMembru(nume, id);
                zonaAfisare.append("Membru adăugat: " + nume + "\n");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Eroare la datele introduse!");
            }
        });

        btnAfisMembri.addActionListener(e -> {
            zonaAfisare.setText("=== Membri ===\n");
            sala.obtineMembri().values().forEach(m -> zonaAfisare.append(m + "\n"));
        });

        btnAdaugaAntrenor.addActionListener(e -> {
            try {
                String nume = JOptionPane.showInputDialog("Nume antrenor:");
                int id = Integer.parseInt(JOptionPane.showInputDialog("ID antrenor:"));
                String spec = JOptionPane.showInputDialog("Specializare:");
                sala.adaugaAntrenor(nume, id, spec);
                zonaAfisare.append("Antrenor adăugat: " + nume + "\n");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Eroare la datele introduse!");
            }
        });

        btnAfisAntrenori.addActionListener(e -> {
            zonaAfisare.setText("=== Antrenori ===\n");
            sala.obtineAntrenori().values().forEach(a -> zonaAfisare.append(a + "\n"));
        });

        btnAdaugaClasa.addActionListener(e -> {
            try {
                String nume = JOptionPane.showInputDialog("Nume clasă:");
                String tip = JOptionPane.showInputDialog("Tip clasă:");
                int capacitate = Integer.parseInt(JOptionPane.showInputDialog("Capacitate maximă:"));
                sala.adaugaClasa(nume, tip, capacitate);
                zonaAfisare.append("Clasă adăugată: " + nume + "\n");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Eroare la datele introduse!");
            }
        });

        btnAfisClase.addActionListener(e -> {
            zonaAfisare.setText("=== Clase ===\n");
            sala.obtineClase().values().forEach(c -> zonaAfisare.append(c + "\n"));
        });

        btnSalveaza.addActionListener(e -> {
            sala.salveazaDate();
            zonaAfisare.append("Datele au fost salvate!\n");
        });

        btnIncarca.addActionListener(e -> {
            sala.incarcaDate();
            zonaAfisare.setText("Date încărcate cu succes!\n");
        });

        frame.setVisible(true);
    }
}