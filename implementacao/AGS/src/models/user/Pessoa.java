package models.user;

import models.user.instances.Aluno;
import models.user.instances.Professor;
import models.user.instances.Secretario;

public class Pessoa {

    // Atributos
    private String nome;
    private String id;
    private String senha;
    private IPessoa tipo;

    // Construtores
    public Pessoa(String id, String senha, String nome, IPessoa tipo) {
        this.nome = nome;
        this.id = id;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Pessoa(String id, String senha, String nome, String tipo) {
        this.nome = nome;
        this.id = id;
        this.senha = senha;
        this.tipo = findTipoByString(tipo);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public IPessoa getTipo() {
        return tipo;
    }

    // Métodos
    public void renomear(String novoNome) {
        this.nome = novoNome;
    }

    private IPessoa findTipoByString(String tipo) {
        switch (tipo) {
            case "PROFESSOR" -> {
                return new Professor();
            }
            case "ALUNO" -> {
                return new Aluno();
            }
            case "SECRETARIO" -> {
                return new Secretario();
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return  "\nId: " + this.id + "\nSenha " + this.senha + "\nNome: " + this.nome + "\nTipo: " + this.tipo.getClass();
    }
}
