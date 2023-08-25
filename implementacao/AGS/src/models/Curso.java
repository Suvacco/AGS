package models;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    // Atributos
    private String nome;
    private int qtdCreditos;
    private List<Disciplina> curriculo;

    // Construtores
    public Curso(String nome, int qtdCreditos) {
        this.nome = nome;
        this.qtdCreditos = qtdCreditos;
        this.curriculo = new ArrayList<Disciplina>();
    }
}
