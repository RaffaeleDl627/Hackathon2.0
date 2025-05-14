package model;

public class Hackathon {
    private String titolo;
    private String sede;
    private int numMaxIscritti;
    private int dimMaxTeam;
    private Durata durata;

    public Hackathon(String titolo, String sede, int numMaxIscritti, int dimMaxTeam, Durata durata) {
        this.titolo = titolo;
        this.sede = sede;
        this.numMaxIscritti = numMaxIscritti;
        this.dimMaxTeam = dimMaxTeam;
        this.durata = durata;
    }

    public Durata getDurata() {
        return durata;
    }
}
