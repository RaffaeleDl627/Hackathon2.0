package model;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Piattaforma {
    private List<Voto> classifica; // Lista delle istanze di Voto

    public Piattaforma() {
        this.classifica = new ArrayList<>();
    }

    public void aggiungiVoto(Voto voto) {
        classifica.add(voto); // Aggiunge un voto alla lista
    }

    public void pubblicaClassificaFinale() {
        // Ordina la classifica in base al valore del voto in ordine decrescente
        classifica.sort(Comparator.comparingInt(Voto::getValore).reversed());

        System.out.println("Classifica finale:");
        for (Voto voto : classifica) {
            System.out.println("File: " + voto.getFile().getNome() +
                    ", Giudice: " + voto.getGiudice().getNome() + " " + voto.getGiudice().getCognome() +
                    ", Valore: " + voto.getValore());
        }
    }
}
}
