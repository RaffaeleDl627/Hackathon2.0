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
    public String getTitolo() {
        return titolo;


    }public String mostraDettagli(){
        System.out.println("Titolo: " + titolo);
        System.out.println("\nSede"+ sede);
        System.out.println("\nNumero massimo di iscritti: " + numMaxIscritti);
        System.out.println("\n Numero massimo di team: " + dimMaxTeam);
        System.out.println("\nDurata:"+ durata);

        return null;
    }
}
