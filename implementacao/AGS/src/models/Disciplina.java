package models;

import models.user.Pessoa;

import java.util.Set;
import java.util.HashSet;

public class Disciplina {

    // Atributos
    private String id;
    private String nome;
    private Set<Pessoa> alunos;

    // Construtores
    public Disciplina(String id, String nome) {
        this.id = id;
        this.nome = nome;
        alunos = new HashSet<Pessoa>();
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    // Métodos
    public void renomear(String nome) {
        this.nome = nome;
    }

    public void adicionarAluno(Pessoa aluno) {
        alunos.add(aluno);
    }

    public void imprimirAlunos() {
        alunos.forEach(aluno -> System.out.println("\t" + aluno.getNome()));
    }

    @Override
    public String toString() {
        return "\nDisciplina: " + this.nome + "\nId: " + this.id;
    }
}
