package models.user.instances;

import java.util.Scanner;

import exceptions.ObjectNotFoundException;
import managers.DisciplinaManager;
import managers.UsuarioManager;
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
        2 - Gerenciar usuários
        3 - Gerar curriculo semestral
        4 - Alterar período de matrículas
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
                        System.out.print("Digite o nome da nova disciplina: ");
                        String nomeDisciplina = scanner.nextLine();
                        System.out.print("Digite o ID da nova disciplina: ");
                        idDisciplina = scanner.nextLine();

                        Disciplina novaDisciplina = new Disciplina(nomeDisciplina, idDisciplina);

                        adicionarDisciplina(novaDisciplina);
                        break;

                    case 3: // Remover disciplinas
                        System.out.print("Digite o ID da disciplina que deseja remover: ");
                        idDisciplina = scanner.nextLine();

                        try {
                            removerDisciplina(DisciplinaManager.getInstance().findDisciplina(idDisciplina));
                        } catch (ObjectNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 4: // Renomear disciplinas
                        System.out.print("Digite o ID da discplina que deseja renomear: ");
                        idDisciplina = scanner.nextLine();
                        System.out.print("Digite o novo nome da disciplina: ");
                        String novoNome = scanner.nextLine();

                        try {
                            renomearDisciplina(DisciplinaManager.getInstance().findDisciplina(idDisciplina), novoNome);
                        } catch (ObjectNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                }

                break;

            // GERENCIAR USUÁRIOS
            case 2:
                System.out.println("""
                1 - Visualizar professores
                2 - Visualizar alunos
                3 - Adicionar usuario
                4 - Remover usuario
                5 - Renomear usuario
                """);

                System.out.print("OP: ");
                String option2 = scanner.nextLine();

                switch(Integer.parseInt(option2)) {
                    case 1: // Visualizar professores
                        visualizarProfessores();
                        break;

                    case 2: // Visualizar alunos
                        visualizarAlunos();
                        break;

                    case 3: // Adicionar usuario
                        String id, senha, nome;

                        System.out.print("Digite o ID do novo usuario: ");
                            id = scanner.nextLine();
                        System.out.print("Digite a senha do novo usuario: ");
                            senha = scanner.nextLine();
                        System.out.print("Digite o nome do novo usuario: ");
                            nome = scanner.nextLine();

                        Pessoa novoUsuario = new Pessoa(id, senha, nome, new Professor());
                        adicionarUsuario(novoUsuario);
                        break;

                    case 4: // Remover usuario
                        System.out.print("Digite o ID do usuario que deseja remover:");
                        String idUsuario = scanner.nextLine();

                        try {
                            removerUsuario(UsuarioManager.getInstance().findUsuario(idUsuario));
                        } catch (ObjectNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 5: // Renomear usuario
                        System.out.print("Digite o ID do usuario que deseja renomear: ");
                        idUsuario = scanner.nextLine();
                        System.out.print("Digite o novo nome do usuario: ");
                        String novoNome = scanner.nextLine();

                        try {
                            renomearDisciplina(DisciplinaManager.getInstance().findDisciplina(idUsuario), novoNome);
                        } catch (ObjectNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                }
                break;

            // GERAR CURRÍCULO
            case 3:
                break;

            // ALTERAR PERÍODO DE MATRÍCULA
            case 4:
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
        GERENCIAR USUÁRIOS
     */

    private void visualizarProfessores() {
        UsuarioManager.imprimirProfessores();
    }

    private void visualizarAlunos() {
        UsuarioManager.imprimirAlunos();
    }

    private void adicionarUsuario(Pessoa pessoa) {
        UsuarioManager.adicionarUsuarioNoSistema(pessoa);
    }

    private void removerUsuario(Pessoa pessoa) {
        try {
            UsuarioManager.removerUsuarioDoSistema(pessoa);
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void renomearUsuario(Pessoa pessoa, String novoNome) {
        try {
            pessoa.renomear(novoNome);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
