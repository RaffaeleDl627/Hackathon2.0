package org.example;
import model.*;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Piattaforma pippo = new Piattaforma();
        IscrittoAllaPiattaforma pietro = new IscrittoAllaPiattaforma();
        ArrayList<Team> teams = new ArrayList<>();
        teams.add(new Team("CodeMasters", 9, "Hack for the Future"));
        teams.add(new Team("ByteBusters", 7, "Hack for the Future"));
        teams.add(new Team("PixelPirates", 8, "Hack for the Future"));
        teams.add(new Team("DataDragons", 6, "Hack for the Future"));

        teams.add(new Team("TechTitans", 10, "Tech Revolution 2"));
        teams.add(new Team("CloudCrusaders", 8, "Tech Revolution 2"));
        teams.add(new Team("WebWizards", 9, "Tech Revolution 2"));
        teams.add(new Team("AlgoAces", 7, "Tech Revolution 2"));

        teams.add(new Team("BitBandits", 8, "Code Storm"));
        teams.add(new Team("DevDynamos", 10, "Code Storm"));
        teams.add(new Team("ServerSages", 6, "Code Storm"));
        teams.add(new Team("QueryQuest", 9, "Code Storm"));

        teams.add(new Team("JavaJedi", 8, "Byte Battle"));
        teams.add(new Team("ScriptStars", 7, "Byte Battle"));
        teams.add(new Team("NetworkNinjas", 9, "Byte Battle"));
        teams.add(new Team("LogicLegends", 10, "Byte Battle"));

        teams.add(new Team("CipherSquad", 9, "Dev Rush"));
        teams.add(new Team("BinaryBrain", 8, "Dev Rush"));
        teams.add(new Team("HashHeroes", 7, "Dev Rush"));
        teams.add(new Team("GitGenius", 10, "Dev Rush"));
    }
}