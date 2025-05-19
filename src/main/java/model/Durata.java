package model;

public class Durata {
    private String dataInizio;
    private String dataFine;

    public String getDataInizio() {
        return dataInizio;
    }
    public String getDataFine() {
        return dataFine;
    }

    public Durata(String dataInizio, String dataFine) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }
}
