package service;

import dao.UsuarioDAO;
import model.Usuario;

public class LoginService {

    public boolean autenticar(String login, String password){

        Usuario teste = new UsuarioDAO().getUsuario();
        if(teste.getLogin().equals(login) && teste.getSenha().equals(password))
        {
            return true;
        }else {
            return false;
        }
    }
}
