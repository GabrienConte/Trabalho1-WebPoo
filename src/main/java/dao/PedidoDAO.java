package dao;

import dao.conexao.ConectaDB;
import model.Pedido;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PedidoDAO {
    public boolean inserir(Pedido pedido) {
        boolean salvou  = false;
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO pedido (usuarioId , entidadeId , dataEntrega, dataDevolucao , total ) ");
        sql.append("VALUES ( " + pedido.getUsuario().getId() + ", ");
        sql.append("         " + pedido.getEntidade().getId() + ", ");
        sql.append("         '" + pedido.getDataEntrega() + "', ");
        sql.append("         '" + pedido.getDataDevolucao() + "', ");
        sql.append("         " + pedido.getTotal()+ "); ");

        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.execute(sql.toString());
            salvou = true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return salvou;
    }

    public boolean deletar(Pedido pedido) {
        boolean deletado = false;
        StringBuilder sql = new StringBuilder();

        sql.append("DELETE FROM pedido WHERE id = " + pedido.getId() + ";");

        try {
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql.toString());
            deletado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deletado;
    }

    public boolean atualizar(Pedido pedido) {

        boolean atualizado = false;
        StringBuilder sql = new StringBuilder();

        sql.append(" UPDATE pedido ");
        sql.append(" SET  usuarioId = " + pedido.getUsuario().getId() + ", ");
        sql.append("      entidadeId = " + pedido.getEntidade().getId() + ", ");
        sql.append("      dataEntrega = '" + pedido.getDataEntrega() + "', ");
        sql.append("      dataDevolucao = '" + pedido.getDataDevolucao() + "', ");
        sql.append("      total =" + pedido.getTotal());
        sql.append(" WHERE id = " + pedido.getId() + ";");

        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql.toString());
            atualizado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return atualizado;
    }

    public void salvar(Pedido pedido) {
        if(pedido.getId() == 0) {
            this.inserir(pedido);
        } else {
            this.atualizar(pedido);
        }
    }

    public Pedido getPedido(){
        return null;
    }

    public ArrayList<Pedido> ListaPedido(){
        return null;
    }
}
