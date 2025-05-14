package model;

public class Team {
    private boolean state; // true: definitivo, false: provvisorio
    private File[] files; // Associazione con la classe File (1 -> 0..*)

    public Team() {
        this.state = false; // Inizialmente il team è provvisorio
    }

    public boolean isState() {
        return state;
    }

    public void switchState(Registrazione registrazione) {
        if (!registrazione.isState()) { // Se registrazione chiusa
            this.state = true; // Team diventa definitivo
        }
    }
    public void setFiles(File[] files) {
        this.files = files;
    }

    public File[] getFiles() {
        return files;
    }

}
