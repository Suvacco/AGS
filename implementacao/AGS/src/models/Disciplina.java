package models;

import models.user.instances.Professor;

public class Disciplina {

    // Atributos
    private String id;
    private String nome;

    // Construtores
    public Disciplina(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

//    public Pessoa getProfessor() {
//        return professor;
//    }

    // Métodos
//    public void atribuirProfessor(Pessoa professor) {
//        if (professor.getTipo() instanceof Professor) {
//            this.professor = professor;
//        }
//    }

    public void renomear(String nome) {
        this.nome = nome;
    }
}
