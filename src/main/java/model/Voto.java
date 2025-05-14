package model;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Voto {
    private int valore;
    private File file; // Associazione verso File
    private Giudice giudice; // Associazione verso Giudice

    public Voto(int valore, File file, Giudice giudice) {
        this.valore = valore;
        this.file = file;
        this.giudice = giudice;
    }

    public int getValore() {
        return valore;
    }

    public File getFile() {
        return file;
    }

    public Giudice getGiudice() {
        return giudice;
    }
}

