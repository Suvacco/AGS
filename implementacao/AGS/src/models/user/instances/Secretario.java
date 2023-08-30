package models.user.instances;

import java.util.Scanner;

import exceptions.ObjectNotFoundException;
import managers.DisciplinaManager;
import models.Disciplina;
import models.Pessoa;
import models.user.IPessoa;

public class Secretario implements IPessoa {
	
	private static Scanner scanner = new Scanner(System.in);

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

    @Override
    public void exibirMenu() {
    	
    	String idDisciplina;
    	
        System.out.println("1- Gerenciar Disciplinas");
        System.out.println("2- Gerenciar Professores");
        System.out.println("3- Gerenciar Alunos");
        System.out.println("4- Gerenciar Curriculo Semestral");
        
        String option = scanner.nextLine();
        
        switch (Integer.parseInt(option)) {
        	case 1:
        		System.out.println("1- Visualizar disciplinas");
        		System.out.println("2- Adicionar disciplinas");
        		System.out.println("3- Remover disciplinas");
        		System.out.println("4- Renomear disciplinas");
        		
        		String option1 = scanner.nextLine();
        		
        		switch(Integer.parseInt(option1)) {
        			case 1: 
        				visualizarDisciplinas();
        				break;
        				
        			case 2:
        				System.out.println("Digite o nome da disciplina");
        				String nomeDisciplina = scanner.nextLine();
        				System.out.println("Digite o ID da disciplina");
        				idDisciplina = scanner.nextLine();
        				
        				Disciplina novaDisciplina = new Disciplina(nomeDisciplina, idDisciplina);
        				
        				adicionarDisciplina(novaDisciplina);
        				break;
        				
        			case 3:
        				System.out.println("Digite o ID da disciplina que deseja remover");
        				idDisciplina = scanner.nextLine();
        				
						try {
							removerDisciplina(DisciplinaManager.findDisciplina(idDisciplina));
						} catch (ObjectNotFoundException e) {
							e.printStackTrace();
						}
        				break;
        				
        			case 4:
        				System.out.println("Digite o ID da discplina que deseja renomear");
        				idDisciplina = scanner.nextLine();
        				System.out.println("Digite o novo nome da disciplina");
        				String novoNome = scanner.nextLine();
        				
						try {
							renomearDisciplina(DisciplinaManager.findDisciplina(idDisciplina), novoNome);
						} catch (ObjectNotFoundException e) {
							e.printStackTrace();
						}
        				
        				break;
        		}
        		
        		break;
        		
        	case 2:
        		break;
        		
        	case 3:
        		break;
        		
        	case 4:
        		break;
		}
    }
}
