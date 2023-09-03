package managers;

import exceptions.ObjectNotFoundException;
import models.Disciplina;
import models.user.Pessoa;
import models.user.instances.Aluno;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatriculaManager {

    private static MatriculaManager instance;

    private MatriculaManager() {
        try {
            this.carregarMatriculas("database/matriculas.csv");
        } catch (FileNotFoundException e) {
            System.out.print("Erro: Arquivo não encontrado: " + e.getMessage());
        }
    }

    public static MatriculaManager getInstance() {
        if (instance == null) { instance = new MatriculaManager(); }

        return instance;
    }

    public void carregarMatriculas(String path) throws FileNotFoundException {
        File file = new File(path);

        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        int line = 0;

        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(",");

            try {
                cadastrarMatriculaEmAluno(split);
                cadastrarAlunoEmDisciplina(split);
            } catch (NullPointerException e) {
                System.out.println(line + ":" + split);
            }

            line++;
        }

        scanner.close();
    }

    private void cadastrarAlunoEmDisciplina(String[] dados) {
        try {
            Pessoa pessoa = UsuarioManager.findUsuario(dados[0]);

            if (pessoa == null) {
                return;
            }

            if (!(pessoa.getTipo() instanceof Aluno)) {
                return;
            }

            Disciplina disciplina = DisciplinaManager.getInstance().findDisciplina(dados[1]);

            disciplina.adicionarAluno(pessoa);

        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
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

	        Disciplina disciplina = DisciplinaManager.getInstance().findDisciplina(dados[1]);

	        ((Aluno) pessoa.getTipo()).realizarMatriculaNaMemoria(disciplina);

    	} catch (ObjectNotFoundException e) {
    		System.out.println(e.getMessage());
    	}
    }

}
