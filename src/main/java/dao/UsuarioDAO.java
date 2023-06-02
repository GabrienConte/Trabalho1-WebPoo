package dao;

import model.Usuario;

public class UsuarioDAO {

    public Usuario getUsuario(String login){
        return new Usuario(1,"Conte", "52441975846", "conte", "123");
    }
}
