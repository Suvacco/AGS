package managers;

import models.Pessoa;
import models.user.instances.Aluno;
import models.user.instances.Professor;
import models.user.Usuario;
import models.user.instances.Secretario;
import system.AGS;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UsuarioManager {

    private static Set<Pessoa> pessoas = new HashSet<>();

    public UsuarioManager() {
        try {
            this.carregarUsuarios("database/usuarios.csv");
        } catch (FileNotFoundException e) {
            System.out.print("Arquivo não encontrado: " + e.getMessage());
        }
    }

    public void carregarUsuarios(String path) throws FileNotFoundException {
        File file = new File(path);

        Scanner scanner = new Scanner(file);

        scanner.nextLine();

        int line = 0;

        while (scanner.hasNextLine()) {

            String[] split = scanner.nextLine().split(";");

            try {

                adicionarUsuarioNoSistema(split);

            } catch (NullPointerException e) {
                System.out.println(line + ":" + split);
            }

            line++;
        }

        scanner.close();
    }

    private void adicionarUsuarioNoSistema(String[] dados) {
        pessoas.add(new Pessoa(dados[0], dados[1], dados[2], dados[3]));
    }

    public static Pessoa findUsuario(String id) {
        return pessoas.stream().filter(pessoa -> pessoa.id.equals(id)).findFirst().orElse(null);
    }
}
