package models.user.instances;

import models.user.IPessoa;

public class Professor implements IPessoa {

    private void visualizarMatriculas() {

    }

    @Override
    public void exibirMenu() {
        System.out.println("1- Visualizar Matriculas");
    }
}
