package service;

import dao.UsuarioDAO;
import model.Usuario;

public class LoginService {

    public boolean autenticar(String login, String password){

        Usuario teste = new UsuarioDAO().getUsuarioByLogin(login);
        if(teste != null && teste.getSenha() == password)
        {
            return true;
        }else {
            return false;
        }
    }
}
