package models;

import exceptions.ObjectNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class Curso {

    // Atributos
    private String nome;
    private int qtdCreditos;
    private Set<Disciplina> disciplinas;

    // Construtores
    public Curso(String nome, int qtdCreditos, Set<Disciplina> disciplinas) {
        this.nome = nome;
        this.qtdCreditos = qtdCreditos;
        this.disciplinas = new HashSet<>();
    }

    // Métodos
    private void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    private void removerDisciplina(Disciplina disciplina) throws ObjectNotFoundException {
        if (disciplinas.contains(disciplina)) {
            disciplinas.remove(disciplina);
        } else {
            throw new ObjectNotFoundException("Erro: a disciplina " + "não existe no curso "  + this.nome);
        }
    }

    public void imprimirDisciplinas() {
        disciplinas.forEach(disciplina -> System.out.println("\t" + disciplina));
    }
}
