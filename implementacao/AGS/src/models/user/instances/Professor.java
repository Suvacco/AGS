package models.user.instances;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import exceptions.ObjectNotFoundException;
import managers.DisciplinaManager;
import managers.MatriculaManager;
import models.Disciplina;
import models.user.IPessoa;

public class Professor implements IPessoa {

    // Atributos
    private Set<String> idsClasses;

    // Construtores
    public Professor() {
        this.idsClasses = new HashSet<>();
    }

    // Métodos
    @Override
    public void exibirMenu() {
        System.out.println("""
            1 - Visualizar minhas classes
            2 - Visualizar alunos por classe
        """);

        System.out.print("OP: ");
        String option = new Scanner(System.in).nextLine();

        switch (Integer.parseInt(option)) {
        	case 1:
                imprimirDisciplinas();
        		break;
            case 2:
                imprimirAlunosDeDisciplina();
                break;
		}
    }

    public void cadastrarEmDisciplina(String idDisciplina) {
        this.idsClasses.add(idDisciplina);
    }

    public void imprimirDisciplinas() {
        System.out.println("\nClasses lecionadas:");

        idsClasses.forEach(disciplina -> {
            try {
                System.out.println("\t" + DisciplinaManager.findDisciplina(disciplina));
            } catch (ObjectNotFoundException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    private void imprimirAlunosDeDisciplina() {
        idsClasses.forEach(id -> {
            try {
                System.out.println("\n" + DisciplinaManager.findDisciplina(id).getNome());
                DisciplinaManager.findDisciplina(id).imprimirAlunos();

            } catch (ObjectNotFoundException e) {
                e.getMessage();
            }
        });
    }

}
