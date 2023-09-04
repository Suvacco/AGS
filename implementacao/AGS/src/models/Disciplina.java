package models;

import models.user.Pessoa;

import java.util.Set;
import java.util.HashSet;

public class Disciplina {

    // Atributos
    private String id;
    private String nome;
    private Set<Pessoa> alunos;
    private boolean isAtiva;

    // Construtores
    public Disciplina(String id, String nome) {
        this.id = id;
        this.nome = nome;
        alunos = new HashSet<Pessoa>();
        isAtiva = false;
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

    /*
        O número máximo de alunos inscritos a uma disciplina é de 60 e quando este número é atingido, as inscrições
        para essa disciplina são encerradas.
     */
    public void adicionarAluno(Pessoa aluno) {
        if (alunos.size() >= 60) {
            System.out.println("Erro: Matrículas encerradas para a disciplina " + id + " pois número máximo de alunos foi atingido");
            return;
        }
        alunos.add(aluno);
        verificarAtivacao();
    }

    public void imprimirAlunos() {
        alunos.forEach(aluno -> System.out.println("\t" + aluno.getNome()));
    }

    /*
        Uma disciplina só fica ativa, isto é, só vai ocorrer no semestre seguinte se, no final do período de matrículas
        tiver, pelo menos, 3 alunos matriculados.
     */
    private void verificarAtivacao() {
        if (alunos.size() >= 3)
            isAtiva = true;
    }

    @Override
    public String toString() {
        return "Disciplina: " + this.nome + "| ID: " + this.id;
    }
}
