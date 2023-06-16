package service;

import dao.TipoUsuarioDAO;
import dao.UsuarioDAO;
import model.TipoUsuario;
import model.Usuario;

import java.util.List;

public class UsuarioService {

    public static Usuario getUsuario(int id) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return  usuarioDAO.getUsuarioById(id);
    }

    public static List<TipoUsuario> tipoUsuarioList() {
        TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
        return tipoUsuarioDAO.ListaTipoUsuario();
    }

    public static Boolean salvarUsuario(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return  usuarioDAO.salvar(usuario);
    }

    public static Boolean excluirUsuario(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return  usuarioDAO.deletar(usuario);
    }
}