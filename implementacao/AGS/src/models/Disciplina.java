package models;

public class Disciplina {

    // Atributos
    private String nome;
    private String id;
    private Professor profResponsavel;

    // Construtores
    public Disciplina(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.profResponsavel = null;
    }

    // Métodos
    void atribuirProfessor(Professor professor) {
        this.profResponsavel = professor;
    }

    void renomear(String nome) {
        this.nome = nome;
    }
}
