package models.user.instances;

import java.util.Scanner;

import exceptions.ObjectNotFoundException;
import managers.DisciplinaManager;
import models.Disciplina;
import models.user.Pessoa;
import models.user.IPessoa;
import system.AGS;

public class Secretario implements IPessoa {

    // Atributos
	private static Scanner scanner = new Scanner(System.in);

    @Override
    public void exibirMenu() {

        String idDisciplina;

        System.out.println("""
        1 - Gerenciar disciplinas
        2 - Gerenciar professores
        3 - Gerenciar alunos
        4 - Gerenciar curriculo semestral
        5 - Alterar período de matrículas
        """);

        String option = scanner.nextLine();

        switch (Integer.parseInt(option)) {

            // GERENCIAR DISCIPLINAS
            case 1:
                System.out.println("""
                1 - Visualizar disciplinas"
                2 - Adicionar disciplinas
                3 - Remover disciplinas
                4 - Renomear disciplinas
                """);

                System.out.print("OP: ");
                String option1 = scanner.nextLine();

                switch(Integer.parseInt(option1)) {
                    case 1: // Visualizar disciplinas
                        visualizarDisciplinas();
                        break;

                    case 2: // Adicionar disciplinas
                        System.out.println("Digite o nome da disciplina");
                        String nomeDisciplina = scanner.nextLine();
                        System.out.println("Digite o ID da disciplina");
                        idDisciplina = scanner.nextLine();

                        Disciplina novaDisciplina = new Disciplina(nomeDisciplina, idDisciplina);

                        adicionarDisciplina(novaDisciplina);
                        break;

                    case 3: // Remover disciplinas
                        System.out.println("Digite o ID da disciplina que deseja remover");
                        idDisciplina = scanner.nextLine();

                        try {
                            removerDisciplina(DisciplinaManager.getInstance().findDisciplina(idDisciplina));
                        } catch (ObjectNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 4: // Renomear disciplinas
                        System.out.println("Digite o ID da discplina que deseja renomear");
                        idDisciplina = scanner.nextLine();
                        System.out.println("Digite o novo nome da disciplina");
                        String novoNome = scanner.nextLine();

                        try {
                            renomearDisciplina(DisciplinaManager.getInstance().findDisciplina(idDisciplina), novoNome);
                        } catch (ObjectNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                }

                break;

            // GERENCIAR PROFESSORES
            case 2:
                break;

            // GERENCIAR ALUNOS
            case 3:
                break;

            // GERENCIAR CURRÍCULO
            case 4:
                break;

            // ALTERAR PERÍODO DE MATRÍCULA
            case 5:
                alterarPeriodoMatricula();
                break;
        }

        scanner.close();
    }

    private void alterarPeriodoMatricula() {
        AGS.alterarPeriodoMatricula();
    }

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

        DisciplinaManager.getInstance().adicionarDisciplinaNoSistema(disciplina);
    }

    private void removerDisciplina(Disciplina disciplina) {
        if (disciplina == null)
            throw new NullPointerException("A disciplina não pode ser null");

        DisciplinaManager.getInstance().removerDisciplinaDoSistema(disciplina);
    }

    private void renomearDisciplina(Disciplina disciplina, String novoNome) {
        if (disciplina == null)
            throw new NullPointerException("A disciplina não pode ser null");

        disciplina.renomear(novoNome);
    }

    private void atribuirProfessor(Disciplina disciplina, Pessoa professorResponsavel) {
        if (disciplina == null)
            throw new NullPointerException("A disciplina não pode ser null");

        ((Professor) professorResponsavel.getTipo()).cadastrarEmDisciplina(disciplina);
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
