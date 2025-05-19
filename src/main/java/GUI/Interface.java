package GUI;

import model.Durata;
import model.Hackathon;
import Controller.Ctrl;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Interface {
    static private JFrame frame;
    private JPanel panel1;
    private JComboBox<String> comboBox1;
    private JLabel lblDettagli;

    public static void main(String[] args) {
        frame = new JFrame("Hackathon");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Interface ui = new Interface();
        frame.setContentPane(ui.panel1);
        
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public Interface() {
        initComponents();
        setupHackathons();
    }

    private void initComponents() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        // Panel superiore per la combo box
        JPanel topPanel = new JPanel(new FlowLayout());
        comboBox1 = new JComboBox<>();
        topPanel.add(new JLabel("Select Event:"));
        topPanel.add(comboBox1);
        panel1.add(topPanel, BorderLayout.NORTH);

        // Label per i dettagli
        lblDettagli = new JLabel("Dettagli hackathon");
        lblDettagli.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDettagli.setHorizontalAlignment(SwingConstants.CENTER);
        lblDettagli.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        lblDettagli.setOpaque(true);
        lblDettagli.setBackground(Color.WHITE);
        panel1.add(lblDettagli, BorderLayout.CENTER);
    }

    private void setupHackathons() {
        final ArrayList<Hackathon> hackathons = new ArrayList<>();
        hackathons.add(new Hackathon("Hack for the Future", "Milano", 100, 20, new Durata("2021-01-01", "2021-12-31")));
        hackathons.add(new Hackathon("Tech Revolution 2", "Roma", 150, 30, new Durata("2022-06-11", "2022-06-28")));
        hackathons.add(new Hackathon("Hackathon 3", "Torino", 100, 20, new Durata("2023-01-01", "2023-12-31")));
        hackathons.add(new Hackathon("Hackathon 4", "Genova", 100, 20, new Durata("2024-01-01", "2024-12-31")));
        hackathons.add(new Hackathon("Hackathon 5", "Bologna", 100, 20, new Durata("2025-01-01", "2025-12-31")));

        for (Hackathon h : hackathons) {
            comboBox1.addItem(h.getTitolo());
        }

        new Ctrl(hackathons, comboBox1, lblDettagli);
    }
}