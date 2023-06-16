package service;

import dao.EntidadeDAO;
import model.Entidade;

public class EntidadeService {

    public static Entidade getEntidade(int id) {
        EntidadeDAO entidadeDAO = new EntidadeDAO();
        return  entidadeDAO.getEntidadeById(id);
    }

    public static Boolean salvarEntidade(Entidade entidade) {
        EntidadeDAO entidadeDAO = new EntidadeDAO();
        return  entidadeDAO.salvar(entidade);
    }

    public static Boolean excluirEntidade(Entidade entidade) {
        EntidadeDAO entidadeDAO = new EntidadeDAO();
        return  entidadeDAO.deletar(entidade);
    }
}