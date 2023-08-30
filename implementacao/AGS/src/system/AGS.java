package system;

import exceptions.ObjectNotFoundException;
import managers.*;
import models.*;
import models.user.IPessoa;
import models.user.instances.*;

import java.util.Scanner;

public class AGS {
    
	private static final Scanner scanner = new Scanner(System.in);
	private int option = 99;

    public Pessoa pessoaLogada;

    public AGS() {
        new UsuarioManager();
        new DisciplinaManager();
    }

    public void loginMenu() {
        while (true) {
            try {

                System.out.println("Olá, seja bem-vindo ao AGS!\n");
                System.out.println("Por favor, insira suas credenciais: ");

                System.out.print("ID: ");
                String id = scanner.nextLine();

                System.out.print("Senha: ");
                String senha = scanner.nextLine();

                logar(id, senha);

                // Se chegar aqui é porque a senha e o usuario são validos
                // Não vai chegar se uma exception for lançada antes
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void actionMenu() {
        while (option != 0) {
            System.out.println("");
            System.out.println("AGS");
            System.out.println("");
            System.out.println("Digite o numero da operação para realiza-la");
            System.out.println("");
            System.out.println("0 - Sair");
            System.out.println("");
            
       

            pessoaLogada.getTipo().exibirMenu();
        }
    }

    public void logar(String idUsuario, String senhaUsuario) throws ObjectNotFoundException, IllegalArgumentException {
        Pessoa pessoa = UsuarioManager.findUsuario(idUsuario);

        if (!pessoa.getSenha().equals(senhaUsuario)) {
            throw new IllegalArgumentException("Senha incorreta");
        }

        this.pessoaLogada = pessoa;

        System.out.println("Login realizado com sucesso! Seja bem-vindo(a), " + pessoa.getNome());

    }
    
    // Dúvida
//    public void matricularEmDisciplina(String idUsuario, String idDisciplina) {
//        Pessoa pessoa = null;
//        Disciplina disciplina = null;
//
//        try {
//            pessoa = UsuarioManager.findUsuario(idUsuario);
//        } catch (ObjectNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            disciplina = DisciplinaManager.findDisciplina(idDisciplina);
//        } catch (ObjectNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        ((Aluno) pessoa.getTipo()).matricularEmDisciplina(disciplina);
//    }
}
