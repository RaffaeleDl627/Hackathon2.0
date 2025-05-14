package model;

public class Registrazione {
    private boolean state;
    private String inizioRegistrazioni;
    private String fineRegistrazioni;

    public Registrazione(boolean state, String inizioRegistrazioni, String fineRegistrazioni) {
        this.state = state;
        this.inizioRegistrazioni = inizioRegistrazioni;
        this.fineRegistrazioni = fineRegistrazioni;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void chiudiRegistrazioni() {
        setState(false);
    }

}
