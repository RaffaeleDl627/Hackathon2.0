package controller;

import model.*;
import java.util.List;
import java.util.ArrayList;

public class Ctrl {
    private final List<Hackathon> hackathons;
    public Ctrl(List<Hackathon> hackathons, List<Giudice> giudici) {
        if (hackathons == null || giudici == null) {
            throw new IllegalArgumentException("I parametri non possono essere null");
        }
        this.hackathons = new ArrayList<>(hackathons);
    }

    public List<Hackathon> getHackathons() {
        return new ArrayList<>(hackathons);
    }
}