import models.*;
import models.user.instances.*;
import system.AGS;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static AGS ags = new AGS();

    public static void main(String[] args) {

        ags.loginMenu();

        ags.actionMenu();
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
