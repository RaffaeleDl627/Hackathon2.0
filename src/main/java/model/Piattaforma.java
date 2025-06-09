package model;

import java.util.*;

public class Piattaforma {
    private final List<Hackathon> hackathons;

    public Piattaforma() {
        this.hackathons = new ArrayList<>();
    }

    public void aggiungiHackathon(Hackathon hackathon) {
        hackathons.add(hackathon);
    }

    public List<Hackathon> getHackathons() {
        return new ArrayList<>(hackathons);
    }
}