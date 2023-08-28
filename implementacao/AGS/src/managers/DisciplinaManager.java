package managers;

import models.*;
import exceptions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class DisciplinaManager {

    private static Set<Disciplina> disciplinas = new HashSet<>();

    public DisciplinaManager() {
        try {
            this.carregarDisciplinas("database/disciplinas.csv");
        } catch (FileNotFoundException e) {
            System.out.print("Arquivo não encontrado: " + e.getMessage());
        }
    }
    
    public static Set<Disciplina> getDisciplinas() {
    	return disciplinas;
    }

    public static void exibirDisciplinas() {
        disciplinas.forEach(disciplina -> System.out.println(disciplina.getId() + " - " + disciplina.getNome()));
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
    
    public void adicionarDisciplinaNoSistema(String dados[]) {
        Disciplina disciplina = new Disciplina(dados[0], dados[1]);
        Pessoa professor = null;

        if (dados[2] != null) {
            try {
                professor = UsuarioManager.findUsuario(dados[2]);
            } catch (ObjectNotFoundException e) {
                System.out.println("Não foi possível adicionar disciplina no sistema pois o professor de id " + dados[2] + " não foi encontrado.");
            }

            if (professor != null) {
                disciplina.atribuirProfessor(professor);
            }
        }

        disciplinas.add(disciplina);
    }

    public void carregarDisciplinas(String path) throws FileNotFoundException {
        File file = new File(path);

        Scanner scanner = new Scanner(file);

        scanner.nextLine();

        int line = 0;

        while (scanner.hasNextLine()) {

            String[] split = scanner.nextLine().split(";");

            try {
                adicionarDisciplinaNoSistema(split);
            } catch (NullPointerException e) {
                System.out.println(line + ":" + split);
            }

            line++;
        }

        scanner.close();
    }

    public static Disciplina findDisciplina(String id) throws ObjectNotFoundException {
        return disciplinas.stream()
                .filter(disciplina -> disciplina.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ObjectNotFoundException("Disciplina de id " + id + " não encontrada."));
    }

//    public static Disciplina findDisciplina(String id) throws ObjectNotFoundException {
//        Optional<Disciplina> optionalDisciplina = disciplinas.stream()
//                .filter(disciplina -> disciplina.getId().equals(id))
//                .findFirst();
//
//        if (optionalDisciplina.isPresent()) {
//            return optionalDisciplina.get();
//        } else {
//            throw new ObjectNotFoundException("Disciplina de id " + id + " não encontrada.");
//        }
//    }
}
