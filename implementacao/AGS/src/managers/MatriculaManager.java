package managers;

import exceptions.ObjectNotFoundException;
import models.Disciplina;
import models.Pessoa;
import models.user.instances.Aluno;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MatriculaManager {

    public MatriculaManager() {
        try {
            this.carregarMatriculas("database/matriculas.csv");
        } catch (FileNotFoundException e) {
            System.out.print("Arquivo não encontrado: " + e.getMessage());
        }
    }

    public void cadastrarMatriculaEmAluno(String dados[]) {
    	try {
    		
	        Pessoa pessoa = UsuarioManager.findUsuario(dados[0]);
	
	        if (pessoa == null) {
	            return;
	        }
	
	        if (!(pessoa.getTipo() instanceof Aluno)) {
	            return;
	        }
	
	        Disciplina disciplina = DisciplinaManager.findDisciplina(dados[1]);
	
	        ((Aluno) pessoa.getTipo()).matricularEmDisciplina(disciplina);
        
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }

    public void carregarMatriculas(String path) throws FileNotFoundException {
        File file = new File(path);

        Scanner scanner = new Scanner(file);

        scanner.nextLine();

        int line = 0;

        while (scanner.hasNextLine()) {

            String[] split = scanner.nextLine().split(";");

            try {
                cadastrarMatriculaEmAluno(split);
            } catch (NullPointerException e) {
                System.out.println(line + ":" + split);
            }

            line++;
        }

        scanner.close();
    }
}
