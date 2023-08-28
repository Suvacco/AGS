package managers;

import exceptions.ObjectNotFoundException;
import models.Disciplina;
import models.Pessoa;
import models.user.instances.Aluno;
import models.user.instances.Professor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class UsuarioManager {

    private static Set<Pessoa> pessoas = new HashSet<>();
    
    public static Set<Pessoa> getPessoas() {
    	return pessoas;
    }

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
    
    public static void imprimirMatriculasDeUmProfessor(Professor professor) {
    	
    	// Acredite isso aqui é MUITO avacalhado e deve ser corrigido o quanto antes,
    	// Talvez a estrutura de dados atual não esteja fazendo muito sentido
    	// Esse código procura no Set<Disciplina> quais as disciplinas que o professor do parametro faz parte
    	// Depois procura no Set<Pessoa> pessoas do tipo "Aluno" que tem a disciplina na List<Disciplina> gradeCurricular
    	// TODO: Refatorar
    	DisciplinaManager.getDisciplinas().forEach(disciplina -> {
    		
    		if (disciplina.getProfessor().equals(professor)) {
    			
				System.out.println(disciplina.getNome().toUpperCase());
    			
    			pessoas.forEach(pessoa -> {
    				
    				if (pessoa.getTipo() instanceof Aluno) {

    					if (((Aluno)pessoa.getTipo()).getGradeCurricular().contains(disciplina)) {
    						
    						System.out.println("  - " + pessoa.getNome() + " - " + pessoa.getId());
    						
    					}
    				}
    			});
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
                .orElseThrow(() -> new ObjectNotFoundException("Usuário de id " + id + " não encontrado."));
    }
}
