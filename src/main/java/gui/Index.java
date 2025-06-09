package gui;

import controller.Ctrl;
import model.Hackathon;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.*;
import javax.swing.table.DefaultTableModel;

public class Index {
    private static final String FONT_ARIAL = "Arial";
    private JFrame mainFrame;
    private JToolBar toolBar;
    private JTextArea descriptionArea;
    private Ctrl controller;
    private ArrayList<Giudice> giudici;
    private ArrayList<Team> teams;

    public Index() {
        // Inizializzazione hackathons
        ArrayList<Hackathon> hackathons = new ArrayList<>();
        hackathons.add(new Hackathon("Hack for the Future", "Milano", 100, 20, new Durata("2021-01-01", "2021-12-31")));
        hackathons.add(new Hackathon("Tech Revolution 2", "Roma", 150, 30, new Durata("2022-06-11", "2022-06-28")));
        hackathons.add(new Hackathon("Code Storm", "Torino", 100, 20, new Durata("2023-01-01", "2023-12-31")));
        hackathons.add(new Hackathon("Byte Battle", "Genova", 100, 20, new Durata("2024-01-01", "2024-12-31")));
        hackathons.add(new Hackathon("Dev Rush", "Bologna", 100, 20, new Durata("2025-01-01", "2025-12-31")));

        controller = new Ctrl(hackathons);
        initializeData();
        createAndShowGUI();
    }

    private void initializeData() {
        // Inizializzazione teams
        teams = new ArrayList<>();
        // Aggiunta teams per ogni hackathon...
        // (mantenere il codice esistente per l'aggiunta dei teams)

// Teams per "Hack for the Future"
teams.add(new Team("CodeMasters", 9, "Hack for the Future"));
teams.add(new Team("ByteBusters", 7, "Hack for the Future"));
teams.add(new Team("PixelPirates", 8, "Hack for the Future"));
teams.add(new Team("DataDragons", 6, "Hack for the Future"));
teams.add(new Team("AlgorithmAces", 10, "Hack for the Future"));

// Teams per "Tech Revolution 2"
teams.add(new Team("TechTitans", 10, "Tech Revolution 2"));
teams.add(new Team("CloudCrusaders", 8, "Tech Revolution 2"));
teams.add(new Team("WebWizards", 9, "Tech Revolution 2"));
teams.add(new Team("DevDynamos", 7, "Tech Revolution 2"));

// Teams per "Code Storm"
teams.add(new Team("BitBandits", 8, "Code Storm"));
teams.add(new Team("BinaryBrain", 10, "Code Storm"));
teams.add(new Team("ServerSages", 6, "Code Storm"));
teams.add(new Team("QueryQuest", 9, "Code Storm"));
teams.add(new Team("LogicLegends", 7, "Code Storm"));

// Teams per "Byte Battle"
teams.add(new Team("JavaJedi", 8, "Byte Battle"));
teams.add(new Team("ScriptStars", 7, "Byte Battle"));
teams.add(new Team("NetworkNinjas", 9, "Byte Battle"));
teams.add(new Team("CipherSquad", 10, "Byte Battle"));

// Teams per "Dev Rush"
teams.add(new Team("SprintSages", 10, "Dev Rush"));
teams.add(new Team("CodeComets", 9, "Dev Rush"));
teams.add(new Team("RapidRebels", 8, "Dev Rush"));
teams.add(new Team("VelocityVanguard", 7, "Dev Rush"));
teams.add(new Team("FastForward", 9, "Dev Rush"));

        // Inizializzazione giudici
        giudici = new ArrayList<>();
        giudici.add(new Giudice("Marco", "Rossi", "Hack for the Future"));
        giudici.add(new Giudice("Laura", "Bianchi", "Tech Revolution 2"));
        giudici.add(new Giudice("Giuseppe", "Verdi", "Code Storm"));
        giudici.add(new Giudice("Anna", "Neri", "Byte Battle"));
    }

    private void createAndShowGUI() {
        mainFrame = new JFrame("HACKATHON");
        mainFrame.setSize(600, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Titolo
        JLabel titleLabel = new JLabel("HACKATHON");
        titleLabel.setFont(new Font(FONT_ARIAL, Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Toolbar
        toolBar = createToolBar();

        // Area descrizione
        descriptionArea = createDescriptionArea();
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        scrollPane.setPreferredSize(new Dimension(550, 200));

        mainPanel.add(titlePanel);
        mainPanel.add(toolBar);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(scrollPane);

        mainFrame.add(mainPanel);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        toolBar.setBorderPainted(false);

        JButton eventiButton = new JButton("Eventi");
        JButton giudiciButton = new JButton("Giudici");
        JButton classificheButton = new JButton("Classifiche");

        eventiButton.addActionListener(e -> mostraListaEventi());
        giudiciButton.addActionListener(e -> mostraListaGiudici());
        classificheButton.addActionListener(e -> mostraClassifiche());

        toolBar.add(eventiButton);
        toolBar.add(giudiciButton);
        toolBar.add(classificheButton);

        return toolBar;
    }

    private JTextArea createDescriptionArea() {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setFont(new Font(FONT_ARIAL, Font.PLAIN, 14));
        area.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        area.setText("Un hackathon è un evento di programmazione intensivo dove sviluppatori, " +
                "designer e altri professionisti collaborano per creare soluzioni innovative in un periodo " +
                "di tempo limitato. Questi eventi promuovono la creatività, il lavoro di squadra e " +
                "l'innovazione, permettendo ai partecipanti di sviluppare progetti pratici e condividere " +
                "conoscenze con altri appassionati del settore.");
        return area;
    }

    private void mostraListaEventi() {
        EventiForm form = new EventiForm(mainFrame, controller);
        form.setVisible(true);
    }

    private void mostraListaGiudici() {
        GiudiciForm form = new GiudiciForm(mainFrame, giudici);
        form.setVisible(true);
    }

    private void mostraClassifiche() {
        ClassificheForm form = new ClassificheForm(mainFrame, controller, teams);
        form.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Index());
    }
}