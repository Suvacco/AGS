import models.*;
import models.user.instances.*;
import system.AGS;

import java.util.Date;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static AGS ags = new AGS();

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        System.out.println("Olá, seja bem-vindo ao AGS!\n");
        System.out.println("Por favor, insira suas credenciais: ");

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        ags.logar(id, senha);

        // Dúvida sobre Typecasting
        Pessoa pes1 = new Pessoa("14", "123", "Joao Paulo", new Aluno());
        Disciplina dis1 = new Disciplina("HISTORIA", "14");
        ((Aluno) pes1.getTipo()).matricularEmDisciplina(dis1);

//        int option = 0;
//        Scanner read = new Scanner(System.in);
//        UsuarioManager usuarioManager = new UsuarioManager();
//        
//        while(option != 99) {
//        	
//        	printMenu();
//        	
//        	System.out.println("Opção: ");
//        	option = read.nextInt();
//        	
//        	switch(option) {
//        	
//        		case 1:
//        			
//        			try {
//						usuarioManager.carregarUsuarios("database/usuarios.csv");
//        	        } catch (FileNotFoundException e) {
//        	            System.out.print("Arquivo não encontrado: " + e.getMessage());
//        	        }
//        			
//        			break;
//        			
//        		case 2: 
//        			
//        			String pessoa[] = new String[4];
//        			
//        			
//        			break;
//        			
//        		case 3: 
//        			
//        			break;
//        			
//        		case 4: 
//        			
//        			break;
//        			
//        		case 5:
//        			
//        			break;
//        			
//        		case 6:
//        			
//        			break;
//        			
//        		case 7:
//        			
//        			break;
//        	}
//        }
    }

//      public static void printMenu() {
//    	System.out.println("\n--------------------------------------------------\n");
//        System.out.println("---------------------- MENU ----------------------\n");
//        System.out.println("Escolha a opção que deseja:");
//        System.out.println("Digite 99 para sair:\n");
//        System.out.println("------------------- Usuarios -------------------");
//        System.out.println("1. Carregar usuarios");
//        System.out.println("2. Adicionar usuario ao sistema\n");
//        System.out.println("------------------- Matriculas -------------------");
//        System.out.println("3. Cadastrar matricula de aluno");
//        System.out.println("4. Carregar matriculas\n");
//        System.out.println("------------------- Disciplinas -------------------");
//        System.out.println("5. Adicionar disciplina");
//        System.out.println("6. Remover disciplina");
//        System.out.println("7. Renomear disciplina\n");
//    }

}
