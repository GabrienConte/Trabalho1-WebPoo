package dao;

import model.Usuario;

public class UsuarioDAO {

    public Usuario getUsuario(String login){
        return new Usuario(1,"Conte", "conte", "123");
    }
}
