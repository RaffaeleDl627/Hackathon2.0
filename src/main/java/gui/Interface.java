package gui;

import controller.Ctrl;
import model.Durata;
import model.Hackathon;
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

    public Interface() {
        ArrayList<Hackathon> hackathons = new ArrayList<>();
        hackathons.add(new Hackathon("Hack for the Future", "Milano", 100, 20, new Durata("2021-01-01", "2021-12-31")));
        hackathons.add(new Hackathon("Tech Revolution 2", "Roma", 150, 30, new Durata("2022-06-11", "2022-06-28")));
        hackathons.add(new Hackathon("Code Storm", "Torino", 100, 20, new Durata("2023-01-01", "2023-12-31")));
        hackathons.add(new Hackathon("Byte Battle", "Genova", 100, 20, new Durata("2024-01-01", "2024-12-31")));
        hackathons.add(new Hackathon("Dev Rush", "Bologna", 100, 20, new Durata("2025-01-01", "2025-12-31")));

        controller = new Ctrl(hackathons);
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Hackathon");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initComponents();
        populateComboBox();
        
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void initComponents() {
        panel1 = new JPanel(new BorderLayout());

        // Panel superiore
        JPanel headerPanel = new JPanel(new BorderLayout());
        
        // ComboBox panel
        JPanel topPanel = new JPanel(new FlowLayout());
        comboBox1 = new JComboBox<>();
        comboBox1.addActionListener(e -> {
            int selectedIndex = comboBox1.getSelectedIndex();
            txtAreaDettagli.setText(controller.getDettagliHackathon(selectedIndex));
        });
        
        topPanel.add(new JLabel("Select Event:"));
        topPanel.add(comboBox1);
        headerPanel.add(topPanel, BorderLayout.NORTH);

        // Label titolo
        lblDettagli = new JLabel("Dettagli hackathon");
        lblDettagli.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDettagli.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(lblDettagli, BorderLayout.CENTER);

        panel1.add(headerPanel, BorderLayout.NORTH);

        // Text area
        txtAreaDettagli = new JTextArea();
        txtAreaDettagli.setEditable(false);
        txtAreaDettagli.setWrapStyleWord(true);
        txtAreaDettagli.setLineWrap(true);
        txtAreaDettagli.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtAreaDettagli.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JScrollPane scrollPane = new JScrollPane(txtAreaDettagli);
        panel1.add(scrollPane, BorderLayout.CENTER);
    }

    private void populateComboBox() {
        for (Hackathon h : controller.getHackathons()) {
            comboBox1.addItem(h.getTitolo());
        }
        
        // Mostra i dettagli del primo elemento
        if (comboBox1.getItemCount() > 0) {
            txtAreaDettagli.setText(controller.getDettagliHackathon(0));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interface());
    }
}