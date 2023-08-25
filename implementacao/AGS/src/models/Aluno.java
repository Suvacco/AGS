package models;

import java.util.ArrayList;
import java.util.List;

public class Aluno implements Usuario {

    // Atributos
    private List<Disciplina> gradeCurricular;

    // Construtores
    public Aluno() {
        this.gradeCurricular = new ArrayList<Disciplina>();
    }

    // Getters e Setters
    public List<Disciplina> getGradeCurricular() {
        return gradeCurricular;
    }

    // Métodos
    public void matricularEmDisciplina(Disciplina disciplina) {
        this.gradeCurricular.add(disciplina);
    }

    private void cancelarMatriculaDisciplina() {

    }

}
