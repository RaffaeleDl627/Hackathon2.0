package model;

public class File {
    private String nome;
    private String data;

    public File(String nome, String data) {
        this.nome = nome;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }
}

