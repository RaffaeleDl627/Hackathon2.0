package model;

public class Giudice extends IscrittoAllaPiattaforma{
    private String nome;
    private String cognome;

    public Giudice(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Voto assegnaVoto(File file, int valore) {
        return new Voto(valore, file, this); // Restituisce un'istanza di Voto
    }

}
