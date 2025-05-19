package Controller;
import model.Hackathon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ctrl {
    private ArrayList<Hackathon> hackathons;
    private JComboBox<String> comboBox1;
    private JLabel lblDettagli;

    public Ctrl(ArrayList<Hackathon> hackathons, JComboBox<String> comboBox1, JLabel lblDettagli) {
        this.hackathons = hackathons;
        this.comboBox1 = comboBox1;
        this.lblDettagli = lblDettagli;
        setupListener();
    }

    private void setupListener() {
        comboBox1.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            int selectedIndex = comboBox1.getSelectedIndex();
                                            lblDettagli.setText(hackathons.get(selectedIndex).mostraDettagli());
                                        }
                                    }
        );
    }
}
