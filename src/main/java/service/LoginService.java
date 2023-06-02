package service;

import dao.UsuarioDAO;
import model.Usuario;

public class LoginService {

    public boolean autenticar(String login, String password){

        Usuario teste = new UsuarioDAO().getUsuario("teste");
        if(teste.getLogin().equals(login) && teste.getPassword().equals(password))
        {
            return true;
        }else {
            return false;
        }
    }
}
