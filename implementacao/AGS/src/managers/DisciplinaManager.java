package managers;

import models.Disciplina;
import models.Pessoa;
import models.user.instances.Professor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
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

        if (dados[2] != null) {
            Pessoa professor = UsuarioManager.findUsuario(dados[2]);

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

    public static Disciplina findDisciplina(String id) {
        return disciplinas.stream().filter(disciplinas -> disciplinas.getId().equals(id)).findFirst().orElse(null);
    }
}
