package models;

import models.user.instances.Professor;

public class Disciplina {

    // Atributos
    private String nome;
    private String id;
    private Pessoa professor;

    // Construtores
    public Disciplina(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.professor = null;
    }

    // Métodos
    public void atribuirProfessor(Pessoa professor) {
        if (professor.getTipo() instanceof Professor) {
            this.professor = professor;
        }
    }

    public void renomear(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public Pessoa getProfessor() {
        return professor;
    }
}
