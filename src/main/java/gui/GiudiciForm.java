package gui;

import model.Giudice;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GiudiciForm extends JFrame {
    private static final String FONT_ARIAL = "Arial";
    private final transient List<Giudice> giudici;

    public GiudiciForm(JFrame parent, List<Giudice> giudici) {
        super("GIUDICI");
        this.giudici = giudici;
        setupUI();
        setLocationRelativeTo(parent);
    }

    private void setupUI() {
        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Titolo
        JLabel titleLabel = new JLabel("GIUDICI");
        titleLabel.setFont(new Font(FONT_ARIAL, Font.BOLD, 24));
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
        dettagliArea.setFont(new Font(FONT_ARIAL, Font.PLAIN, 14));

        JScrollPane dettagliScrollPane = new JScrollPane(dettagliArea);
        rightPanel.add(dettagliScrollPane);

        lista.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = lista.getSelectedIndex();
                if (selectedIndex != -1) {
                    Giudice giudice = giudici.get(selectedIndex);
                    String dettagli = "Nome: " + giudice.getNome() + "\n\n" +
                            "Cognome: " + giudice.getCognome() + "\n\n" +
                            "Hackathon: " + giudice.getHackathon() + "\n";

                    dettagliArea.setText(dettagli);
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