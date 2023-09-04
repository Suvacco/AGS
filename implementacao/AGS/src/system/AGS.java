package system;

import exceptions.ObjectNotFoundException;
import managers.*;
import models.Disciplina;
import models.user.Pessoa;

import java.util.Scanner;

public class AGS {
    
	private static final Scanner scanner = new Scanner(System.in);
    private static boolean periodoMatricula;
	private int option = 99;

    public Pessoa pessoaLogada;

    public AGS() {
        periodoMatricula = true;
        DisciplinaManager.getInstance();
        MatriculaManager.getInstance();
        ClassesManager.getInstance();
    }

    public void loginMenu() {
        while (true) {
            System.out.println("Olá, seja bem-vindo ao AGS!\n");
            System.out.println("Por favor, insira suas credenciais: ");

            System.out.print("ID: ");
            String id = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            try {
                logar(id, senha);

                break;  // Se chegar aqui é porque a senha e o usuário são válidos.
                // Não vai chegar se uma exception for lançada antes.

            } catch (ObjectNotFoundException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void acaoMenu() {
        while (option != 0) {
            System.out.println("\n-------------------- AGS --------------------");
            System.out.println("Seja bem-vindo(a), " + pessoaLogada.getNome());
            System.out.println("Período de matrículas aberto: " + (periodoMatricula ? "Sim" : "Não"));
            System.out.println("\nDigite o numero da operação para realizá-la:");
            System.out.println("\n0 - Sair");
            pessoaLogada.getTipo().exibirMenu();
        }
    }

    public void logar(String idUsuario, String senhaUsuario) throws ObjectNotFoundException, IllegalArgumentException {
        Pessoa pessoa = UsuarioManager.getInstance().findUsuario(idUsuario);

        if (! pessoa.getSenha().equals(senhaUsuario)) {
            throw new IllegalArgumentException("Senha incorreta");
        }

        this.pessoaLogada = pessoa;

        System.out.println("\nLogin realizado com sucesso!");
    }

    public static void alterarPeriodoMatricula() {
        if (periodoMatricula == true) {
            periodoMatricula = false;
            System.out.println("Período de matrículas fechado com sucesso.");
        } else {
            periodoMatricula = true;
            System.out.println("Período de matrículas aberto com sucesso.");
        }
    }
}
