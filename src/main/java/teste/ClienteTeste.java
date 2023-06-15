package teste;

import dao.EntidadeDAO;
import dao.ProdutoDAO;
import dao.TipoUsuarioDAO;
import dao.UsuarioDAO;
import model.Entidade;
import model.Produto;
import model.TipoUsuario;
import model.Usuario;

public class ClienteTeste {
    public static void main(String[] args) {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        for(Produto p : produtoDAO.ListaProduto()){
            System.out.println(p.getDescricao());
        }
    }
}
