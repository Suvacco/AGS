package models;

public class Disciplina {
    private String nome;
    private String id;
    private Professor profResponsavel;

    public Disciplina(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.profResponsavel = null;
    }

    void atribuirProfessor(Professor professor) {
        this.profResponsavel = professor;
    }

    void renomear(String nome) {
        this.nome = nome;
    }
}
