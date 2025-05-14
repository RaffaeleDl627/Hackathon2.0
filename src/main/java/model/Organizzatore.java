package model;

public class Organizzatore extends IscrittoAllaPiattaforma{
    private String nome;
    private String cognome;

    public Organizzatore(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public void inviaInvito() {
        System.out.println("Invito inviato.");
    }

    public void switchRegistrazioneState(Registrazione registrazione) {
        registrazione.setState(false);
    }
}
