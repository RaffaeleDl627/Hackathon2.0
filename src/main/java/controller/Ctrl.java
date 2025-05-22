package controller;

import model.Hackathon;

import java.util.ArrayList;

public class Ctrl {
    private ArrayList<Hackathon> hackathons;

    public Ctrl(ArrayList<Hackathon> hackathons) {
        this.hackathons = hackathons;
    }

    public ArrayList<Hackathon> getHackathons() {
        return hackathons;
    }

    public String getDettagliHackathon(int index) {
        if (index >= 0 && index < hackathons.size()) {
            Hackathon hackathon = hackathons.get(index);
            StringBuilder details = new StringBuilder();
            details.append("Titolo: ").append(hackathon.getTitolo()).append("\n");
            details.append("Sede: ").append(hackathon.getSede()).append("\n");
            details.append("Numero massimo di iscritti: ").append(hackathon.getNumMaxIscritti()).append("\n");
            details.append("Dimensione massima team: ").append(hackathon.getDimMaxTeam()).append("\n");
            details.append("Durata: ").append(hackathon.getDurata());
            return details.toString();
        }
        return "Nessun hackathon selezionato";
    }
}