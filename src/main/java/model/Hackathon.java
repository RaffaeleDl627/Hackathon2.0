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

    public String getTitolo() {
        return titolo;
    }

    public String getSede() {
        return sede;
    }

    public int getNumMaxIscritti() {
        return numMaxIscritti;
    }

    public int getDimMaxTeam() {
        return dimMaxTeam;
    }

    public String getDurata() {
        String durata = this.durata.getDataInizio() + " - " + this.durata.getDataFine();
        return durata;
    }

    public String mostraDettagli() {
        System.out.println("Titolo: " + titolo);
        System.out.println("\nSede: " + sede);
        System.out.println("\nNumero massimo di iscritti: " + numMaxIscritti);
        System.out.println("\nNumero massimo di team: " + dimMaxTeam);
        System.out.println("\nDurata: " + durata);
        return null;
    }
}