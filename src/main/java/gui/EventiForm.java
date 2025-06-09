package gui;

import controller.Ctrl;
import model.Hackathon;
import javax.swing.*;
import java.awt.*;

public class EventiForm extends JFrame {
    private static final String FONT_ARIAL = "Arial";
    private final Ctrl controller;

    public EventiForm(JFrame parent, Ctrl controller) {
        super("Lista Eventi");
        this.controller = controller;
        setupUI();
        setLocationRelativeTo(parent);
    }

    private void setupUI() {
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
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
        
        JSplitPane splitPane = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,
            leftPanel,
            rightPanel
        );
        splitPane.setDividerLocation(300);
        
        mainPanel.add(splitPane, BorderLayout.CENTER);
        add(mainPanel);
    }
}