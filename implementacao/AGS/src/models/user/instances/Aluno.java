package models.user.instances;

import exceptions.ObjectNotFoundException;
import managers.DisciplinaManager;
import models.Disciplina;
import models.user.IPessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    
    public void matricularEmDisciplina() throws ObjectNotFoundException {
        DisciplinaManager.exibirDisciplinas();

        System.out.println("Digite o id da disciplina que gostaria de se matricular");

        String id = new Scanner(System.in).nextLine();

        Disciplina disciplina = DisciplinaManager.findDisciplina(id);

        boolean matriculado = this.gradeCurricular.add(disciplina);

        if (matriculado) {
            System.out.println("Matriculado na disciplina: " + disciplina.getNome());
        } else {
            System.out.println("Você já está matriculado na disciplina " + disciplina.getNome());
        }
    }
    
    public void cancelarMatriculaDisciplina(Disciplina disciplina) {
    	this.gradeCurricular.remove(disciplina);
    }

    public void cancelarMatriculaDisciplina() throws ObjectNotFoundException {
        DisciplinaManager.exibirDisciplinas();

        System.out.println("Digite o id da disciplina que gostaria de se desmatricular");

        String id = new Scanner(System.in).nextLine();

        Disciplina disciplina = DisciplinaManager.findDisciplina(id);

        boolean desmatriculado = this.gradeCurricular.remove(disciplina);

        if (desmatriculado) {
            System.out.println("Você foi desmatriculado da disciplina " + disciplina.getNome());
        } else {
            System.out.println("Você não está matriculado na disciplina " + disciplina.getNome());
        }
    }

    public void verGradeCurricular() {
        System.out.println("Matriculado nas seguintes disciplinas: ");
        this.gradeCurricular.forEach(disciplina -> System.out.println(disciplina.getNome()));
    }

    @Override
    public void exibirMenu() {
        try {

            Scanner scanner = new Scanner(System.in);

            System.out.println("1 - Matricular");
            System.out.println("2 - Cancelar Matricula");
            System.out.println("3 - Ver grade");

            System.out.print("OP: ");
            String option = scanner.nextLine();

            switch (Integer.parseInt(option)) {
                case 1:
                    matricularEmDisciplina();
                    break;
                case 2:
                    cancelarMatriculaDisciplina();
                    break;
                case 3:
                    verGradeCurricular();
                    break;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
