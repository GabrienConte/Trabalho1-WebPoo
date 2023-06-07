package dao;

import dao.conexao.ConectaDB;
import model.Produto;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutoDAO {
    public boolean inserir(Produto produto) {
        boolean salvou  = false;
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO produto (descricao, marca, quantidade, valor) ");
        sql.append("VALUES ('" + produto.getDescricao() + "', ");
        sql.append("        '" + produto.getMarca() + "', ");
        sql.append("         " + produto.getQuantidade() + ", ");
        sql.append("         " + produto.getValor()+ "); ");

        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.execute(sql.toString());
            salvou = true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return salvou;
    }

    public boolean deletar(Produto produto) {
        boolean deletado = false;
        StringBuilder sql = new StringBuilder();

        sql.append("DELETE FROM produto WHERE id = " + produto.getId() + ";");

        try {
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql.toString());
            deletado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deletado;
    }

    public boolean atualizar(Produto produto) {

        boolean atualizado = false;
        StringBuilder sql = new StringBuilder();

        sql.append(" UPDATE produto ");
        sql.append(" SET  descricao = '" + produto.getDescricao() + "', ");
        sql.append("      marca = '" + produto.getMarca() + "', ");
        sql.append("      quantidade = " + produto.getQuantidade() + ", ");
        sql.append("      valor =" + produto.getValor());
        sql.append(" WHERE id = " + produto.getId() + ";");

        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql.toString());
            atualizado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return atualizado;
    }

    public void salvar(Produto produto) {
        if(produto.getId() == 0) {
            this.inserir(produto);
        } else {
            this.atualizar(produto);
        }
    }

    public Produto getProduto(){
        return null;
    }

    public ArrayList<Produto> ListaProduto(){
        return null;
    }
}
