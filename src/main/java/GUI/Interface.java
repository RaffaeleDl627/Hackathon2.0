package GUI;

import model.Durata;
import model.Hackathon;
import Controller.Ctrl;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Interface {
    private JFrame frame;
    private JPanel panel1;
    private JComboBox<String> comboBox1;
    private JTextArea txtAreaDettagli;
    private JLabel lblDettagli;
    private Ctrl controller;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Interface ui = new Interface();
            ui.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Hackathon");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initComponents();
        setupHackathons();
        
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void initComponents() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        // Panel superiore che contiene sia la combo box che la label
        JPanel headerPanel = new JPanel(new BorderLayout());
        
        // Panel per la combo box
        JPanel topPanel = new JPanel(new FlowLayout());
        comboBox1 = new JComboBox<>();
        topPanel.add(new JLabel("Select Event:"));
        topPanel.add(comboBox1);
        headerPanel.add(topPanel, BorderLayout.NORTH);

        // Label per il titolo
        lblDettagli = new JLabel("Dettagli hackathon");
        lblDettagli.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDettagli.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(lblDettagli, BorderLayout.CENTER);

        panel1.add(headerPanel, BorderLayout.NORTH);

        // Area di testo per i dettagli
        txtAreaDettagli = new JTextArea();
        txtAreaDettagli.setEditable(false);
        txtAreaDettagli.setWrapStyleWord(true);
        txtAreaDettagli.setLineWrap(true);
        txtAreaDettagli.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtAreaDettagli.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Aggiungi JTextArea in uno JScrollPane
        JScrollPane scrollPane = new JScrollPane(txtAreaDettagli);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel1.add(scrollPane, BorderLayout.CENTER);
    }

    private void setupHackathons() {
        final ArrayList<Hackathon> hackathons = new ArrayList<>();
        hackathons.add(new Hackathon("Hack for the Future", "Milano", 100, 20, new Durata("2021-01-01", "2021-12-31")));
        hackathons.add(new Hackathon("Tech Revolution 2", "Roma", 150, 30, new Durata("2022-06-11", "2022-06-28")));
        hackathons.add(new Hackathon("Code Storm", "Torino", 100, 20, new Durata("2023-01-01", "2023-12-31")));
        hackathons.add(new Hackathon("Byte Battle", "Genova", 100, 20, new Durata("2024-01-01", "2024-12-31")));
        hackathons.add(new Hackathon("Dev Rush", "Bologna", 100, 20, new Durata("2025-01-01", "2025-12-31")));

        for (Hackathon h : hackathons) {
            comboBox1.addItem(h.getTitolo());
        }

        controller = new Ctrl(hackathons, comboBox1, txtAreaDettagli);
    }
}