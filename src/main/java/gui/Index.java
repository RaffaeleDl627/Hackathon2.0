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
        ArrayList<Hackathon> hackathons = new ArrayList<>();
        hackathons.add(new Hackathon("Hack for the Future", "Milano", 100, 20, new Durata("2021-01-01", "2021-12-31")));
        hackathons.add(new Hackathon("Tech Revolution 2", "Roma", 150, 30, new Durata("2022-06-11", "2022-06-28")));
        hackathons.add(new Hackathon("Code Storm", "Torino", 100, 20, new Durata("2023-01-01", "2023-12-31")));
        hackathons.add(new Hackathon("Byte Battle", "Genova", 100, 20, new Durata("2024-01-01", "2024-12-31")));
        hackathons.add(new Hackathon("Dev Rush", "Bologna", 100, 20, new Durata("2025-01-01", "2025-12-31")));

        controller = new Ctrl(hackathons);
        
        // Inizializzazione teams
        teams = new ArrayList<>();

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
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        mainFrame = new JFrame("HACKATHON");
        mainFrame.setSize(600, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principale con BoxLayout verticale
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Titolo
        JLabel titleLabel = new JLabel("HACKATHON");
        titleLabel.setFont(new Font(FONT_ARIAL, Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Panel per il titolo con margini
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Creazione della toolbar
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        toolBar.setBorderPainted(false);

        // Creazione dei pulsanti
        JButton eventiButton = new JButton("Eventi");
        JButton giudiciButton = new JButton("Giudici");  // invece di button2
        JButton classificheButton = new JButton("Classifiche");  // invece di button3
        classificheButton.addActionListener(e -> mostraClassifiche());

        // Aggiunta dei pulsanti alla toolbar
        toolBar.add(eventiButton);
        toolBar.add(giudiciButton);
        toolBar.add(classificheButton);

        // Gestione dell'evento click sul pulsante Eventi
        eventiButton.addActionListener(e -> mostraListaEventi());
        giudiciButton.addActionListener(e -> mostraListaGiudici());

        // Area di testo per la descrizione
        descriptionArea = new JTextArea();
        descriptionArea.setEditable(false);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setFont(new Font(FONT_ARIAL, Font.PLAIN, 14));
        descriptionArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        descriptionArea.setText("Un hackathon è un evento di programmazione intensivo dove sviluppatori, " +
                "designer e altri professionisti collaborano per creare soluzioni innovative in un periodo " +
                "di tempo limitato. Questi eventi promuovono la creatività, il lavoro di squadra e " +
                "l'innovazione, permettendo ai partecipanti di sviluppare progetti pratici e condividere " +
                "conoscenze con altri appassionati del settore.");

        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        scrollPane.setPreferredSize(new Dimension(550, 200));

        // Aggiunta componenti al panel principale
        mainPanel.add(titlePanel);
        mainPanel.add(toolBar);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spazio tra toolbar e area testo
        mainPanel.add(scrollPane);

        // Aggiunta del panel principale al frame
        mainFrame.add(mainPanel);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private void mostraListaEventi() {
        JFrame eventiFrame = new JFrame("Lista Eventi");
        eventiFrame.setSize(800, 400);  // Aumentata la larghezza per accommodare i dettagli
        
        // Panel principale con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Panel sinistro per la lista
        JPanel leftPanel = new JPanel(new BorderLayout());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Hackathon h : controller.getHackathons()) {
            listModel.addElement(h.getTitolo());
        }
        
        JList<String> lista = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(lista);
        leftPanel.add(new JLabel("Eventi disponibili:", SwingConstants.CENTER), BorderLayout.NORTH);
        leftPanel.add(listScrollPane, BorderLayout.CENTER);
        
        // Panel destro per i dettagli
        JPanel rightPanel = new JPanel(new BorderLayout());
        JTextArea dettagliArea = new JTextArea();
        dettagliArea.setEditable(false);
        dettagliArea.setWrapStyleWord(true);
        dettagliArea.setLineWrap(true);
        dettagliArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dettagliArea.setFont(new Font(FONT_ARIAL, Font.PLAIN, 14));
        
        JScrollPane dettagliScrollPane = new JScrollPane(dettagliArea);
        rightPanel.add(new JLabel("Dettagli evento:", SwingConstants.CENTER), BorderLayout.NORTH);
        rightPanel.add(dettagliScrollPane, BorderLayout.CENTER);
        
        // Aggiunta listener per la selezione della lista
        lista.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = lista.getSelectedIndex();
                if (selectedIndex != -1) {
                    Hackathon hackathon = controller.getHackathons().get(selectedIndex);
                    StringBuilder dettagli = new StringBuilder();
                    dettagli.append("Titolo: ").append(hackathon.getTitolo()).append("\n\n");
                    dettagli.append("Città: ").append(hackathon.getSede()).append("\n\n");
                    dettagli.append("Numero partecipanti: ").append(hackathon.getNumMaxIscritti()).append("\n\n");
                    dettagli.append("Numero team: ").append(hackathon.getDimMaxTeam()).append("\n\n");
                    dettagli.append("Durata:\n");
                    dettagli.append("Data: ").append(hackathon.getDurata()).append("\n");

                    
                    dettagliArea.setText(dettagli.toString());
                }
            }
        });
        
        // Split pane per dividere la lista e i dettagli
        JSplitPane splitPane = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,
            leftPanel,
            rightPanel
        );
        splitPane.setDividerLocation(300);
        
        mainPanel.add(splitPane, BorderLayout.CENTER);
        
        eventiFrame.add(mainPanel);
        eventiFrame.setLocationRelativeTo(mainFrame);
        eventiFrame.setVisible(true);

        // Inizializzazione giudici
        giudici = new ArrayList<>();
        giudici.add(new Giudice("Marco", "Rossi", "Hack for the Future"));
        giudici.add(new Giudice("Laura", "Bianchi", "Tech Revolution 2"));
        giudici.add(new Giudice("Giuseppe", "Verdi", "Code Storm"));
        giudici.add(new Giudice("Anna", "Neri", "Byte Battle"));

        createAndShowGUI();
    }

    private void mostraListaGiudici() {
        JFrame giudiciFrame = new JFrame("GIUDICI");
        giudiciFrame.setSize(800, 400);
        giudiciFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel principale con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Titolo
        JLabel titleLabel = new JLabel("GIUDICI");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Panel sinistro per la lista
        JPanel leftPanel = new JPanel(new BorderLayout());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Giudice g : giudici) {
            listModel.addElement(g.getNome() + " " + g.getCognome());
        }

        JList<String> lista = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(lista);
        leftPanel.add(listScrollPane);

        // Panel destro per i dettagli
        JPanel rightPanel = new JPanel(new BorderLayout());
        JTextArea dettagliArea = new JTextArea();
        dettagliArea.setEditable(false);
        dettagliArea.setWrapStyleWord(true);
        dettagliArea.setLineWrap(true);
        dettagliArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dettagliArea.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane dettagliScrollPane = new JScrollPane(dettagliArea);
        rightPanel.add(dettagliScrollPane);

        // Listener per la selezione della lista
        lista.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = lista.getSelectedIndex();
                if (selectedIndex != -1) {
                    Giudice giudice = giudici.get(selectedIndex);
                    StringBuilder dettagli = new StringBuilder();
                    dettagli.append("Nome: ").append(giudice.getNome()).append("\n\n");
                    dettagli.append("Cognome: ").append(giudice.getCognome()).append("\n\n");
                    dettagli.append("Hackathon: ").append(giudice.getHackathon()).append("\n");

                    dettagliArea.setText(dettagli.toString());
                }
            }
        });

        // Split pane per dividere la lista e i dettagli
        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                leftPanel,
                rightPanel
        );
        splitPane.setDividerLocation(300);

        // Aggiunta componenti al frame
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(splitPane, BorderLayout.CENTER);

        giudiciFrame.add(mainPanel);
        giudiciFrame.setLocationRelativeTo(mainFrame);
        giudiciFrame.setVisible(true);
    }

private void mostraClassifiche() {
    JFrame classificheFrame = new JFrame("CLASSIFICHE");
    classificheFrame.setSize(800, 400);
    classificheFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    // Panel principale con BorderLayout
    JPanel mainPanel = new JPanel(new BorderLayout());

    // Titolo
    JLabel titleLabel = new JLabel("CLASSIFICHE");
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

    // Panel sinistro per la lista degli hackathon
    JPanel leftPanel = new JPanel(new BorderLayout());
    DefaultListModel<String> listModel = new DefaultListModel<>();
    for (Hackathon h : controller.getHackathons()) {
        listModel.addElement(h.getTitolo());
    }

    JList<String> listaHackathon = new JList<>(listModel);
    JScrollPane listScrollPane = new JScrollPane(listaHackathon);
    leftPanel.add(new JLabel("Hackathons:", SwingConstants.CENTER), BorderLayout.NORTH);
    leftPanel.add(listScrollPane, BorderLayout.CENTER);

    // Panel destro per la classifica
    JPanel rightPanel = new JPanel(new BorderLayout());
    JTable classificaTable = new JTable();
    JScrollPane tableScrollPane = new JScrollPane(classificaTable);
    rightPanel.add(new JLabel("Classifica:", SwingConstants.CENTER), BorderLayout.NORTH);
    rightPanel.add(tableScrollPane, BorderLayout.CENTER);

    // Listener per la selezione dell'hackathon
    listaHackathon.addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            String selectedHackathon = listaHackathon.getSelectedValue();
            if (selectedHackathon != null) {
                // Filtra i team per l'hackathon selezionato e ordinali per giudizio
                ArrayList<Team> teamsFiltrati = new ArrayList<>();
                for (Team t : teams) {
                    if (t.getHackathon().equals(selectedHackathon)) {
                        teamsFiltrati.add(t);
                    }
                }
                teamsFiltrati.sort((t1, t2) -> Integer.compare(t2.getGiudizioGiudici(), t1.getGiudizioGiudici()));

                // Crea il modello della tabella
                String[] columnNames = {"Posizione", "Team", "Giudizio Giudici"};
                Object[][] data = new Object[teamsFiltrati.size()][3];
                for (int i = 0; i < teamsFiltrati.size(); i++) {
                    Team team = teamsFiltrati.get(i);
                    data[i][0] = i + 1;
                    data[i][1] = team.getNome();
                    data[i][2] = team.getGiudizioGiudici();
                }

                classificaTable.setModel(new DefaultTableModel(data, columnNames));
            }
        }
    });

    // Split pane per dividere la lista e la classifica
    JSplitPane splitPane = new JSplitPane(
        JSplitPane.HORIZONTAL_SPLIT,
        leftPanel,
        rightPanel
    );
    splitPane.setDividerLocation(300);

    // Aggiunta componenti al frame
    mainPanel.add(titleLabel, BorderLayout.NORTH);
    mainPanel.add(splitPane, BorderLayout.CENTER);

    classificheFrame.add(mainPanel);
    classificheFrame.setLocationRelativeTo(mainFrame);
    classificheFrame.setVisible(true);
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Index());
    }
}