package models;

public class Pessoa {

    // Atributos
    private String nome;
    private String id;
    private String senha;
    public Usuario tipo;

    // Construtores
    public Pessoa(String nome, String id, String senha, Usuario tipo) {
        this.nome = nome;
        this.id = id;
        this.senha = senha;
        this.tipo = tipo;
    }

    // Métodos
    void renomear(String novoNome) {
        this.nome = novoNome;
    }
}
