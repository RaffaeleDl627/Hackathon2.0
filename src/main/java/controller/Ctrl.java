package controller;

import model.Hackathon;
import java.util.List;

public class Ctrl {
    private List<Hackathon> hackathons;

    public Ctrl(List<Hackathon> hackathons) {
        this.hackathons = hackathons;
    }

    public List<Hackathon> getHackathons() {
        return hackathons;
    }

    public String getDettagliHackathon(int index) {
        if (index >= 0 && index < hackathons.size()) {
            Hackathon hackathon = hackathons.get(index);
            return "Titolo: " + hackathon.getTitolo() + "\n" +
                    "Sede: " + hackathon.getSede() + "\n" +
                    "Numero massimo di iscritti: " + hackathon.getNumMaxIscritti() + "\n" +
                    "Dimensione massima team: " + hackathon.getDimMaxTeam() + "\n" +
                    "Durata: " + hackathon.getDurata();
        }
        return "Nessun hackathon selezionato";
    }
}