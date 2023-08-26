import system.AGS;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static AGS ags = new AGS();

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        System.out.println("Olá, seja bem-vindo ao AGS!");
        System.out.println("");
        System.out.println("Por favor, insira suas credenciais: ");

        System.out.println("ID: ");
        String id = scanner.nextLine();

        System.out.println("Senha: ");
        String senha = scanner.nextLine();

        ags.logar(id, senha);
    }
}