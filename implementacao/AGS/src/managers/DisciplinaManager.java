package managers;

import models.*;
import exceptions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DisciplinaManager {

    private static Set<Disciplina> disciplinas = new HashSet<>();

    private static DisciplinaManager instance;

    private DisciplinaManager() {
        try {
            this.carregarDisciplinas("database/disciplinas.csv");
        } catch (FileNotFoundException e) {
            System.out.print("Erro: Arquivo não encontrado: " + e.getMessage());
        }
    }

    public static DisciplinaManager getInstance() {
        if (instance == null) { instance = new DisciplinaManager(); }

        return instance;
    }
    
    public static Set<Disciplina> getDisciplinas() {
    	return disciplinas;
    }

    public static void exibirDisciplinas() {
        disciplinas.forEach(disciplina -> System.out.println(disciplina.getId() + " - " + disciplina.getNome()));
    }

    public void adicionarDisciplinaNoSistema(String[] dados) {
        Disciplina disciplina = new Disciplina(dados[0], dados[1]);
        disciplinas.add(disciplina);
    }

    public static void adicionarDisciplinaNoSistema(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public static void removerDisciplinaDoSistema(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }

    public static void renomearDisciplina(Disciplina disciplina, String novoNome) {
        disciplina.renomear(novoNome);
    }

    public void carregarDisciplinas(String path) throws FileNotFoundException {
        File file = new File(path);

        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        int line = 0;

        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(",");

            try {
                adicionarDisciplinaNoSistema(split);
            } catch (NullPointerException e) {
                System.out.println(line + ":" + split);
            }

            line++;
        }

        scanner.close();
    }

    public Disciplina findDisciplina(String id) throws ObjectNotFoundException {
        return disciplinas.stream()
                .filter(disciplina -> disciplina.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ObjectNotFoundException("Erro: Disciplina de id " + id + " não encontrada."));
    }
}
