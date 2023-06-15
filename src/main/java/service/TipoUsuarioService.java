package service;

import dao.TipoUsuarioDAO;
import model.TipoUsuario;

public class TipoUsuarioService {
    public static TipoUsuario getTipoUsuario(int id) {
        TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
        return  tipoUsuarioDAO.getTipoUsuarioById(id);
    }
    public static Boolean salvarTipoUsuario(TipoUsuario tipoUsuario) {
        TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
        return  tipoUsuarioDAO.salvar(tipoUsuario);
    }

    public static Boolean excluirTipoUsuario(TipoUsuario tipoUsuario) {
        TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
        return  tipoUsuarioDAO.deletar(tipoUsuario);
    }
}
