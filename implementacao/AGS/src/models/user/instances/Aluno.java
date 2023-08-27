package models.user.instances;

import models.Disciplina;
import models.user.IPessoa;

import java.util.ArrayList;
import java.util.List;

public class Aluno implements IPessoa {

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

    /*
    Isso aqui faz sentido? Pq tipo, ta parecendo que a disciplina ta matriculando em você
    não que você está matriculando na disciplina. O obj "Disciplina" deveria ter uma lista de pessoas
    */
    // Dúvida
    public void matricularEmDisciplina(Disciplina disciplina) {
        this.gradeCurricular.add(disciplina);
    }

    public void cancelarMatriculaDisciplina() {

    }

}
