package models.user.instances;

import managers.DisciplinaManager;
import models.Disciplina;
import models.Pessoa;
import models.user.IPessoa;

public class Secretario implements IPessoa {

    // TODO Inserir parâmetros e valores de retorno das funções vazias

    private void gerarCurriculo() {

    }

    /*
        GERENCIAR DISCIPLINAS
     */
    private void visualizarDisciplinas() {

    }

    private void adicionarDisciplina(Disciplina disciplina) {
        if (disciplina == null)
            throw new NullPointerException("A disciplina não pode ser null");

        DisciplinaManager.adicionarDisciplinaNoSistema(disciplina);
    }

    private void removerDisciplina(Disciplina disciplina) {
        if (disciplina == null)
            throw new NullPointerException("A disciplina não pode ser null");

        DisciplinaManager.removerDisciplinaDoSistema(disciplina);
    }

    private void renomearDisciplina(Disciplina disciplina, String novoNome) {
        if (disciplina == null)
            throw new NullPointerException("A disciplina não pode ser null");

        disciplina.renomear(novoNome);
    }

    private void atribuirProfessor(Disciplina disciplina, Pessoa professorResponsavel) {
        if (disciplina == null)
            throw new NullPointerException("A disciplina não pode ser null");

        disciplina.atribuirProfessor(professorResponsavel);
    }

    /*
        GERENCIAR PROFESSORES
     */

    private void visualizarProfessores() {

    }

    private void adicionarProfessor(Professor professor) {

    }

    private void removerProfessor(Professor professor) {

    }

    private void renomearProfessor(Pessoa professor, String novoNome) {
        professor.renomear(novoNome);
    }

    /*
        GERENCIAR ALUNOS
     */

    private void visualizarAlunos() {

    }

    private void adicionarAluno(Aluno aluno) {

    }

    private void removerAluno(Aluno aluno) {

    }

    private void renomearAluno(Pessoa aluno, String novoNome) {
        aluno.renomear(novoNome);
    }

}
