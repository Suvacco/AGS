package system;

import exceptions.ObjectNotFoundException;
import managers.*;
import models.*;
import models.user.instances.*;

public class AGS {

    Pessoa pessoaLogada;

    public AGS() {
        new UsuarioManager();
        new DisciplinaManager();
    }

    public void logar(String idUsuario, String senhaUsuario) {
        Pessoa pessoa = null;

        try {
            pessoa = UsuarioManager.findUsuario(idUsuario);
        } catch (ObjectNotFoundException e) {
            System.out.printf("Erro: usuário de id " + idUsuario + "não foi encontrado");
            return;
        }

        if (!pessoa.getSenha().equals(senhaUsuario)) {
            System.out.println("Erro: senha incorreta");
            return;
        }

        pessoaLogada = pessoa;
        System.out.println("Login realizado com sucesso! Seja bem-vindo(a), " + pessoa.getNome());
    }

    // Dúvida
    public void matricularEmDisciplina(String idUsuario, String idDisciplina) {
        Pessoa pessoa = null;
        Disciplina disciplina = null;

        try {
            pessoa = UsuarioManager.findUsuario(idUsuario);
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            disciplina = DisciplinaManager.findDisciplina(idDisciplina);
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }

        ((Aluno) pessoa.getTipo()).matricularEmDisciplina(disciplina);
    }
}
