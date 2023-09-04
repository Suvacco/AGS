package models.user.instances;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import exceptions.ObjectNotFoundException;
import managers.DisciplinaManager;
import managers.UsuarioManager;
import models.Curso;
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
                1 - Visualizar disciplinas
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

                        Disciplina novaDisciplina = new Disciplina(idDisciplina, nomeDisciplina);

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
                        Pessoa novoUsuario;

                        System.out.print("Digite o ID do novo usuario: ");
                            id = scanner.nextLine();
                        System.out.print("Digite a senha do novo usuario: ");
                            senha = scanner.nextLine();
                        System.out.print("Digite o nome do novo usuario: ");
                            nome = scanner.nextLine();
                        System.out.println("""
                            Selecione o tipo de usuário:
                                A - ALUNO
                                P - PROFESSOR
                                C - SECRETÁRIO
                            """);
                            String tipoOp = scanner.nextLine();

                        switch (tipoOp.toUpperCase().charAt(0)) {
                            case 'A':
                                novoUsuario = new Pessoa(id, senha, nome, new Aluno());
                                adicionarUsuario(novoUsuario);
                                break;
                            case 'P':
                                novoUsuario = new Pessoa(id, senha, nome, new Professor());
                                adicionarUsuario(novoUsuario);
                                break;
                            case 'C':
                                novoUsuario = new Pessoa(id, senha, nome, new Secretario());
                                adicionarUsuario(novoUsuario);
                                break;
                        }
                        break;

                    case 4: // Remover usuario
                        System.out.print("Digite o ID do usuario que deseja remover: ");
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
                            renomearUsuario(UsuarioManager.getInstance().findUsuario(idUsuario), novoNome);
                        } catch (ObjectNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                }

                break;

            // GERAR CURRÍCULO
            case 3:
                String input = "";
                String[] disciplinas = new String[50];

                System.out.print("Insira o nome do curso: ");
                String nomeCurso = scanner.nextLine();

                System.out.print("Insira a quantidade de créditos do curso: ");
                String qtdCreditos = scanner.nextLine();

                DisciplinaManager.getInstance().exibirDisciplinas();
                System.out.println("Insira os IDs das disciplinas que deseja adicionar. Digite -1 para prosseguir.");

                for (int i = 0; i < disciplinas.length; i++){
                    System.out.print("ID: ");
                    input = scanner.nextLine();

                    if (input.equals("-1"))
                        break;

                    disciplinas[i] = input;
                }

                Set<Disciplina> disciplinasCurriculo = gerarCurriculo(disciplinas);
                Curso novoCurso = new Curso(nomeCurso, Integer.parseInt(qtdCreditos), disciplinasCurriculo);

                System.out.println("Currículo gerado com sucesso!\n");
                System.out.println(novoCurso);
                break;

            // ALTERAR PERÍODO DE MATRÍCULA
            case 4:
                alterarPeriodoMatricula();
                break;
        }
    }

    private void alterarPeriodoMatricula() {
        AGS.alterarPeriodoMatricula();
    }

    private Set<Disciplina> gerarCurriculo(String[] idsDisciplinas) {
        Set<Disciplina> disciplinasCurriculo = new HashSet<>();

        for (int i = 0; i < idsDisciplinas.length; i++) {
            Disciplina d = null;

            if (idsDisciplinas[i] != null) {
                try {
                    d = DisciplinaManager.getInstance().findDisciplina(idsDisciplinas[i]);
                } catch (ObjectNotFoundException e) {
                    e.printStackTrace();
                }

                disciplinasCurriculo.add(d);
            }
        }

        return disciplinasCurriculo;
    }

    /*
        GERENCIAR DISCIPLINAS
     */

    private void visualizarDisciplinas() {
        DisciplinaManager.getInstance().exibirDisciplinas();
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
