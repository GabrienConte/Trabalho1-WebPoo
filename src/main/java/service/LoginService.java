package service;

import dao.UsuarioDAO;
import model.Usuario;

public class LoginService {

    public boolean autenticar(String login, String senha){
        Usuario teste = new UsuarioDAO().getUsuarioByLogin(login);

        if(teste.getLogin() != null && senha.equals(teste.getSenha()))
        {
            return true;
        }else {
            return false;
        }
    }
}
