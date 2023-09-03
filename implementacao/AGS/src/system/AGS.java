package system;

import exceptions.ObjectNotFoundException;
import managers.*;
import models.user.Pessoa;

import java.util.Scanner;

public class AGS {
    
	private static final Scanner scanner = new Scanner(System.in);
	private int option = 99;

    public Pessoa pessoaLogada;

    public AGS() {
        new UsuarioManager();
        new DisciplinaManager();
        new MatriculaManager();
        new ClassesManager();
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
            System.out.println("\n-------------------- AGS --------------------");
            System.out.println("Seja bem-vindo(a), " + pessoaLogada.getNome());
            System.out.println("\nDigite o numero da operação para realizá-la:");
            System.out.println("\n0 - Sair");

            pessoaLogada.getTipo().exibirMenu();
        }
    }

    public void logar(String idUsuario, String senhaUsuario) throws ObjectNotFoundException, IllegalArgumentException {
        Pessoa pessoa = UsuarioManager.findUsuario(idUsuario);

        if (!pessoa.getSenha().equals(senhaUsuario)) {
            throw new IllegalArgumentException("Senha incorreta");
        }

        this.pessoaLogada = pessoa;

        System.out.println("\nLogin realizado com sucesso!");

    }
}
