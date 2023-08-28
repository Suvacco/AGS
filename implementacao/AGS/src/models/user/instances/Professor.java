package models.user.instances;

import java.util.Scanner;

import managers.UsuarioManager;
import models.user.IPessoa;

public class Professor implements IPessoa {

    private void visualizarMatriculas() {
    	UsuarioManager.imprimirMatriculasDeUmProfessor(this);
    }

    @Override
    public void exibirMenu() {
        System.out.println("1- Visualizar Matriculas");
        
        String option = new Scanner(System.in).nextLine();
    
        switch (Integer.parseInt(option)) {
        	case 1:
        		visualizarMatriculas();
        		break;
		}
    }
}
