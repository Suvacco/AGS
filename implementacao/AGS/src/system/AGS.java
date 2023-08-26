package system;

import managers.DisciplinaManager;
import managers.UsuarioManager;
import models.Pessoa;
import models.user.Usuario;

import java.util.HashSet;
import java.util.Set;

public class AGS {

    Pessoa pessoaLogada;

    public AGS() {

        new UsuarioManager();

        new DisciplinaManager();

    }

    public void logar(String id, String senha) {
        Pessoa pessoa = UsuarioManager.findUsuario(id);

        if (pessoa == null) {
            return;
        }

        if (!pessoa.getSenha().equals(senha)) {
            return;
        }

        pessoaLogada = pessoa;
    }
}
