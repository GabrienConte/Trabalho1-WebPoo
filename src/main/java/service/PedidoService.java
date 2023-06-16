package service;

import dao.EntidadeDAO;
import dao.PedidoDAO;
import dao.UsuarioDAO;
import model.Entidade;
import model.Pedido;
import model.Usuario;

import java.util.List;

public class PedidoService {

    public static Pedido getPedido(int id) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        return  pedidoDAO.getPedidoById(id);
    }

    public static List<Usuario> usuarioList() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.ListaUsuario();
    }

    public static List<Entidade> entidadeList() {
        EntidadeDAO entidadeDAO = new EntidadeDAO();
        return entidadeDAO.ListaEntidade();
    }

    public static Boolean salvarPedido(Pedido pedido) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        return  pedidoDAO.salvar(pedido);
    }

    public static Boolean excluirPedido(Pedido pedido) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        return  pedidoDAO.deletar(pedido);
    }
}