package models;

import models.user.Usuario;
import models.user.instances.Aluno;
import models.user.instances.Professor;
import models.user.instances.Secretario;

public class Pessoa {

    // Atributos
    public String nome;
    public String id;
    public String senha;
    public Usuario tipo;

    // Construtores
    public Pessoa(String id, String senha, String nome, Usuario tipo) {
        this.nome = nome;
        this.id = id;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Pessoa(String id, String senha, String nome, String tipo) {
        this.nome = nome;
        this.id = id;
        this.senha = senha;
        this.tipo = findTipoByString(tipo);
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario getTipo() {
        return tipo;
    }

    // Métodos
    public void renomear(String novoNome) {
        this.nome = novoNome;
    }

    private Usuario findTipoByString(String tipo) {
        switch (tipo) {
            case "PROFESSOR" -> {
                return new Professor();
            }
            case "ALUNO" -> {
                return new Aluno();
            }
            case "SECRETARIO" -> {
                return new Secretario();
            }
        }

        return null;
    }
}
