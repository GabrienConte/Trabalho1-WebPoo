package dao;

import dao.conexao.ConectaDB;
import model.TipoUsuario;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TipoUsuarioDAO {
    public boolean inserir(TipoUsuario tipoUsuario) {
        boolean salvou  = false;
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO tipoUsuario (tipo) VALUES ('" + tipoUsuario.getTipo() + "');");

        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.execute(sql.toString());
            salvou = true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return salvou;
    }

    public boolean deletar(TipoUsuario tipoUsuario) {
        boolean deletado = false;
        StringBuilder sql = new StringBuilder();

        sql.append("DELETE FROM tipoUsuario WHERE id = " + tipoUsuario.getId() + ";");

        try {
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql.toString());
            deletado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deletado;
    }

    public boolean atualizar(TipoUsuario tipoUsuario) {

        boolean atualizado = false;
        StringBuilder sql = new StringBuilder();

        sql.append(" UPDATE usuarioTipo SET tipo = '" + tipoUsuario.getTipo() + "' ");
        sql.append(" WHERE id = " + tipoUsuario.getId() + ";");

        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql.toString());
            atualizado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return atualizado;
    }

    public void salvar(TipoUsuario tipoUsuario) {
        if(tipoUsuario.getId() == 0) {
            this.inserir(tipoUsuario);
        } else {
            this.atualizar(tipoUsuario);
        }
    }

    public TipoUsuario getTipoUsuario(){
        return null;
    }

    public ArrayList<TipoUsuario> ListaTipoUsuario(){
        return null;
    }
}
