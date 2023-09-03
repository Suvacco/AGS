package models.user.instances;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import exceptions.ObjectNotFoundException;
import managers.DisciplinaManager;
import models.user.IPessoa;

public class Professor implements IPessoa {

    // Atributos
    private Set<Integer> idsClasses;

    // Construtores
    public Professor() {
        this.idsClasses = new HashSet<>();
    }

    // Métodos
    @Override
    public void exibirMenu() {
        System.out.println("1 - Visualizar minhas classes");

        System.out.print("OP: ");
        String option = new Scanner(System.in).nextLine();

        switch (Integer.parseInt(option)) {
        	case 1:
                imprimirDisciplinas();
        		break;
		}
    }

    public void cadastrarEmDisciplina(int idDisciplina) {
        this.idsClasses.add(idDisciplina);
    }

    public void imprimirDisciplinas() {
        System.out.println("\nClasses lecionadas:");

        idsClasses.forEach(disciplina -> {
            try {
                System.out.println("\t" + DisciplinaManager.findDisciplina(String.valueOf(disciplina)).getNome());
            } catch (ObjectNotFoundException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
