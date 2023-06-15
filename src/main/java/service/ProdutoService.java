package service;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService {

    public static Produto getProduto(int id) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return  produtoDAO.getProdutoById(id);
    }
    public static Boolean salvarProduto(Produto produto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return  produtoDAO.salvar(produto);
    }

    public static Boolean excluirProduto(Produto produto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return  produtoDAO.deletar(produto);
    }
}
