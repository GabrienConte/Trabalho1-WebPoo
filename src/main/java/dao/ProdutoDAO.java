package dao;

import dao.conexao.ConectaDB;
import model.Produto;
import model.TipoUsuario;
import model.Produto;
import model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public boolean salvar(Produto produto) {
        if(produto.getId() == 0) {
            return this.inserir(produto);
        } else {
            return this.atualizar(produto);
        }
    }

    public Produto getProdutoById(int id) {
        StringBuilder sql = new StringBuilder();
        Produto produto = new Produto();

        sql.append("SELECT * FROM produto prod  ");
        sql.append("WHERE prod.id = " + id  + ";");

        try (Connection conn = new ConectaDB().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            if(rs.next()) {
                produto = ResultSetToObject(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }

    public List<Produto> ListaProduto() {
        List<Produto> produtos = new ArrayList<>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT * FROM produto prod  ");

        try (Connection conn = new ConectaDB().getConexao()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            while(rs.next()) {
                produtos.add(ResultSetToObject(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtos;
    }

    private Produto ResultSetToObject(ResultSet rs) throws Exception {
        Produto produto = new Produto();

        try {
            produto.setId(rs.getInt("id"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setMarca(rs.getString("marca"));
            produto.setQuantidade(rs.getFloat("quantidade"));
            produto.setValor(rs.getFloat("valor"));

        } catch (Exception e) {
            throw e;
        }

        return produto;
    }
}
