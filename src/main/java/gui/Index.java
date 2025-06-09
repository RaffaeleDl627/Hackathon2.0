package gui;

import controller.Ctrl;
import model.Hackathon;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.*;

public class Index {
    private static final String FONT_ARIAL = "Arial";
    private static final String HACK_FOR_FUTURE = "Hack for the Future";
    private static final String TECH_REVOLUTION = "Tech Revolution 2";
    private static final String CODE_STORM = "Code Storm";
    private static final String BYTE_BATTLE = "Byte Battle";
    private static final String DEV_RUSH = "Dev Rush";
    private JFrame mainFrame;
    private final Ctrl controller;
    private ArrayList<Giudice> giudici = new ArrayList<>();
    private ArrayList<Team> teams;

    public Index() {
        // Inizializzazione hackathons
        ArrayList<Hackathon> hackathons = new ArrayList<>();
        hackathons.add(new Hackathon(HACK_FOR_FUTURE, "Milano", 100, 5, new Durata("2021-01-01", "2021-12-31")));
        hackathons.add(new Hackathon(TECH_REVOLUTION, "Roma", 150, 4, new Durata("2022-06-11", "2022-06-28")));
        hackathons.add(new Hackathon(CODE_STORM, "Torino", 100, 5, new Durata("2023-01-01", "2023-12-31")));
        hackathons.add(new Hackathon(BYTE_BATTLE, "Genova", 100, 4, new Durata("2024-01-01", "2024-12-31")));
        hackathons.add(new Hackathon(DEV_RUSH, "Bologna", 100, 5, new Durata("2025-01-01", "2025-12-31")));

        controller = new Ctrl(hackathons, giudici);
        giudici = new ArrayList<>();
        initializeData();
        createAndShowGUI();
    }

    private void initializeData() {
        // Inizializzazione teams
        teams = new ArrayList<>();

// Teams per "Hack for the Future"
teams.add(new Team("CodeMasters", 9, HACK_FOR_FUTURE));
teams.add(new Team("ByteBusters", 7, HACK_FOR_FUTURE));
teams.add(new Team("PixelPirates", 8, HACK_FOR_FUTURE));
teams.add(new Team("DataDragons", 6, HACK_FOR_FUTURE));
teams.add(new Team("AlgorithmAces", 10, HACK_FOR_FUTURE));

// Teams per "Tech Revolution 2"
teams.add(new Team("TechTitans", 10, TECH_REVOLUTION));
teams.add(new Team("CloudCrusaders", 8, TECH_REVOLUTION));
teams.add(new Team("WebWizards", 9, TECH_REVOLUTION));
teams.add(new Team("DevDynamos", 7, TECH_REVOLUTION));

// Teams per "Code Storm"
teams.add(new Team("BitBandits", 8, CODE_STORM));
teams.add(new Team("BinaryBrain", 10, CODE_STORM));
teams.add(new Team("ServerSages", 6, CODE_STORM));
teams.add(new Team("QueryQuest", 9, CODE_STORM));
teams.add(new Team("LogicLegends", 7, CODE_STORM));

// Teams per "Byte Battle"
teams.add(new Team("JavaJedi", 8, BYTE_BATTLE));
teams.add(new Team("ScriptStars", 7, BYTE_BATTLE));
teams.add(new Team("NetworkNinjas", 9, BYTE_BATTLE));
teams.add(new Team("CipherSquad", 10, BYTE_BATTLE));

// Teams per "Dev Rush"
teams.add(new Team("SprintSages", 10, DEV_RUSH));
teams.add(new Team("CodeComets", 9, DEV_RUSH));
teams.add(new Team("RapidRebels", 8, DEV_RUSH));
teams.add(new Team("VelocityVanguard", 7, DEV_RUSH));
teams.add(new Team("FastForward", 9, DEV_RUSH));

        // Inizializzazione giudici
        giudici = new ArrayList<>();
        giudici.add(new Giudice("Marco", "Rossi", HACK_FOR_FUTURE));
        giudici.add(new Giudice("Laura", "Bianchi", TECH_REVOLUTION));
        giudici.add(new Giudice("Giuseppe", "Verdi", CODE_STORM));
        giudici.add(new Giudice("Anna", "Neri", BYTE_BATTLE));
    }

    private void createAndShowGUI() {
        mainFrame = new JFrame("HACKATHON");
        mainFrame.setSize(600, 400);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
        JToolBar toolBar = createToolBar();

        // Area descrizione
        JTextArea descriptionArea = createDescriptionArea();
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
        JToolBar localToolBar = new JToolBar();
        localToolBar.setFloatable(false);
        localToolBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        localToolBar.setBorderPainted(false);

        JButton eventiButton = new JButton("Eventi");
        JButton giudiciButton = new JButton("Giudici");
        JButton classificheButton = new JButton("Classifiche");

        eventiButton.addActionListener(e -> mostraListaEventi());
        giudiciButton.addActionListener(e -> mostraListaGiudici());
        classificheButton.addActionListener(e -> mostraClassifiche());

        localToolBar.add(eventiButton);
        localToolBar.add(giudiciButton);
        localToolBar.add(classificheButton);

        return localToolBar;
    }

    private JTextArea createDescriptionArea() {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setFont(new Font(FONT_ARIAL, Font.PLAIN, 14));
        area.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        area.setText("Un hackathon, ovvero una \"maratona di hacking\", è un evento durante il quale," +
                " team di partecipanti si sfidano per progettare e implementare nuove soluzioni basate " +
                "su una certa tecnologia o mirate a un certo ambito applicativo.");
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
        SwingUtilities.invokeLater(Index::new);
    }
}