package dao;

import dao.conexao.ConectaDB;
import model.ItemPedido;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemPedidoDAO {
    public boolean inserir(ItemPedido itemPedido) {
        boolean salvou  = false;
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO itemPedido (produtoId  , pedidoId  , quantidade , total) ");
        sql.append("VALUES ( " + itemPedido.getProduto().getId() + ", ");
        sql.append("         " + itemPedido.getPedido().getId() + ", ");
        sql.append("         " + itemPedido.getQuantidade() + ", ");
        sql.append("         " + itemPedido.getTotal()+ "); ");

        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.execute(sql.toString());
            salvou = true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return salvou;
    }

    public boolean deletar(ItemPedido itemPedido) {
        boolean deletado = false;
        StringBuilder sql = new StringBuilder();

        sql.append("DELETE FROM itemPedido WHERE id = " + itemPedido.getId() + ";");

        try {
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql.toString());
            deletado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deletado;
    }

    public boolean atualizar(ItemPedido itemPedido) {

        boolean atualizado = false;
        StringBuilder sql = new StringBuilder();

        sql.append(" UPDATE itemPedido ");
        sql.append(" SET  produtoId = " + itemPedido.getProduto().getId() + ", ");
        sql.append("      pedidoId = " + itemPedido.getPedido().getId() + ", ");
        sql.append("      quantidade = " + itemPedido.getQuantidade() + ", ");
        sql.append("      total =" + itemPedido.getTotal());
        sql.append(" WHERE id = " + itemPedido.getId() + ";");

        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql.toString());
            atualizado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return atualizado;
    }

    public void salvar(ItemPedido itemPedido) {
        if(itemPedido.getId() == 0) {
            this.inserir(itemPedido);
        } else {
            this.atualizar(itemPedido);
        }
    }

    public ItemPedido getItemPedido(){
        return null;
    }

    public ArrayList<ItemPedido> ListaItemPedido(){
        return null;
    }
}
