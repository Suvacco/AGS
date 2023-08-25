package models;

public class Secretario implements Usuario {

    // TODO Inserir parâmetros e valores de retorno das funções vazias

    private void gerarCurriculo() {

    }

    /*
        GERENCIAR DISCIPLINAS
     */
    private void visualizarDisciplinas() {

    }

    private void adicionarDisciplina(Disciplina disciplina) {

    }

    private void removerDisciplina(Disciplina disciplina) {

    }

    private void renomearDisciplina(Disciplina disciplina, String novoNome) {
        if (disciplina == null)
            throw new NullPointerException("A disciplina não pode ser null");

        disciplina.renomear(novoNome);
    }

    private void atribuirProfessor(Disciplina disciplina, Professor professorResponsavel) {
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
