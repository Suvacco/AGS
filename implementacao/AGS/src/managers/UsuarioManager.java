package managers;

import exceptions.ObjectNotFoundException;
import models.user.Pessoa;
import models.user.instances.Professor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UsuarioManager {

    private static Set<Pessoa> pessoas = new HashSet<>();
    
    public static Set<Pessoa> getPessoas() {
    	return pessoas;
    }

    private static UsuarioManager instance;

    private UsuarioManager() {
        try {
            this.carregarUsuarios("database/usuarios.csv");
        } catch (FileNotFoundException e) {
            System.out.print("Erro: Arquivo não encontrado: " + e.getMessage());
        }
    }

    public static UsuarioManager getInstance() {
        if (instance == null) { instance = new UsuarioManager(); }

        return instance;
    }

    public void carregarUsuarios(String path) throws FileNotFoundException {
        File file = new File(path);

        Scanner scanner = new Scanner(file);

        scanner.nextLine();
        int line = 0;

        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(",");

            try {
                adicionarUsuarioNoSistema(split);
            } catch (NullPointerException e) {
                System.out.println(line + ":" + split);
            }

            line++;
        }
        scanner.close();
    }
    
    public static void imprimirDisciplinasDosProfessores(Professor professor) {
        pessoas.forEach(pessoa -> {
            if (pessoa.getTipo() instanceof Professor) {
                ((Professor) pessoa.getTipo()).imprimirDisciplinas();
            }
        });
    }

    private void adicionarUsuarioNoSistema(String[] dados) {
    	// Isso aqui é estupido, mas fica ilegivel colocar direto no obj
    	String id = dados[0];
    	String senha = dados[1];
    	String nome = dados[2];
    	String tipo = dados[3];

        pessoas.add(new Pessoa(id, senha, nome, tipo));
    }
    
    public static Pessoa findUsuario(String id) throws ObjectNotFoundException {
        return pessoas.stream()
                .filter(pessoa -> pessoa.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ObjectNotFoundException("Erro: Usuário de id " + id + " não encontrado"));
    }
}
