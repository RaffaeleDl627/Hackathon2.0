package model;

public class Giudice {
    private String nome;
    private String cognome;
    private String hackathon;

    public Giudice(String nome, String cognome, String hackathon) {
        this.nome = nome;
        this.cognome = cognome;
        this.hackathon = hackathon;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getHackathon() {
        return hackathon;
    }
}