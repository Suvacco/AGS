package managers;

import exceptions.ObjectNotFoundException;
import models.Disciplina;
import models.user.Pessoa;
import models.user.instances.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ClassesManager {

    public ClassesManager() {
        try {
            this.carregarClasses("database/classes.csv");
        } catch (FileNotFoundException e) {
            System.out.print("Erro: Arquivo não encontrado: " + e.getMessage());
        }
    }

    public void carregarClasses(String path) throws FileNotFoundException {
        File file = new File(path);

        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        int line = 0;

        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(",");

            try {
                cadastrarClasseEmProfessor(split);
            } catch (NullPointerException e) {
                System.out.println(line + ":" + split);
            }
            line++;
        }
        scanner.close();
    }

    public void cadastrarClasseEmProfessor(String dados[]) {
        Pessoa professor;
        Disciplina disciplina;

        try {
            professor = UsuarioManager.findUsuario(dados[0]);
            disciplina = DisciplinaManager.findDisciplina(dados[1]);
            ((Professor) professor.getTipo()).cadastrarEmDisciplina(disciplina);

        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
