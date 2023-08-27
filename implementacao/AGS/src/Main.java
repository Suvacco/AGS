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
    }
}