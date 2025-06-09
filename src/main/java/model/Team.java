package model;

public class Team {
    private String nome;
    private int giudizioGiudici;
    private String hackathon;

    public Team(String nome, int giudizioGiudici, String hackathon) {
        this.nome = nome;
        this.giudizioGiudici = giudizioGiudici;
        this.hackathon = hackathon;
    }

    public String getNome() {
        return nome;
    }

    public int getGiudizioGiudici() {
        return giudizioGiudici;
    }

    public String getHackathon() {
        return hackathon;
    }
}