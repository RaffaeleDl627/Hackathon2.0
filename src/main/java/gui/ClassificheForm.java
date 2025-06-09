package gui;

import controller.Ctrl;
import model.Team;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ClassificheForm extends JFrame {
    private static final String FONT_ARIAL = "Arial";
    private final Ctrl controller;
    private final ArrayList<Team> teams;

    public ClassificheForm(JFrame parent, Ctrl controller, ArrayList<Team> teams) {
        super("CLASSIFICHE");
        this.controller = controller;
        this.teams = teams;
        setupUI();
        setLocationRelativeTo(parent);
    }

    private void setupUI() {
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Titolo
        JLabel titleLabel = new JLabel("CLASSIFICHE");
        titleLabel.setFont(new Font(FONT_ARIAL, Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Panel sinistro per la lista degli hackathon
        JPanel leftPanel = new JPanel(new BorderLayout());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (var h : controller.getHackathons()) {
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

        listaHackathon.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedHackathon = listaHackathon.getSelectedValue();
                if (selectedHackathon != null) {
                    ArrayList<Team> teamsFiltrati = new ArrayList<>();
                    for (Team t : teams) {
                        if (t.getHackathon().equals(selectedHackathon)) {
                            teamsFiltrati.add(t);
                        }
                    }
                    teamsFiltrati.sort((t1, t2) -> Integer.compare(t2.getGiudizioGiudici(), t1.getGiudizioGiudici()));

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

        JSplitPane splitPane = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,
            leftPanel,
            rightPanel
        );
        splitPane.setDividerLocation(300);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(splitPane, BorderLayout.CENTER);

        add(mainPanel);
    }
}