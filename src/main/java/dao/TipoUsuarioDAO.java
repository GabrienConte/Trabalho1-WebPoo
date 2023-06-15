package dao;

import dao.conexao.ConectaDB;
import model.TipoUsuario;
import model.TipoUsuario;
import model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

        sql.append(" UPDATE tipoUsuario SET tipo = '" + tipoUsuario.getTipo() + "' ");
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

    public boolean salvar(TipoUsuario tipoUsuario) {
        if(tipoUsuario.getId() == 0) {
            return this.inserir(tipoUsuario);
        } else {
            return this.atualizar(tipoUsuario);
        }
    }

    public TipoUsuario getTipoUsuarioById(int id) {
        StringBuilder sql = new StringBuilder();
        TipoUsuario tipoUsuario = new TipoUsuario();

        sql.append("SELECT * FROM tipoUsuario tu  ");
        sql.append("WHERE tu.id = " + id  + ";");

        try (Connection conn = new ConectaDB().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            if(rs.next()) {
                tipoUsuario = ResultSetToObject(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoUsuario;
    }

    public List<TipoUsuario> ListaTipoUsuario() {
        List<TipoUsuario> usuarios = new ArrayList<>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT * FROM tipoUsuario tu  ");

        try (Connection conn = new ConectaDB().getConexao()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            while(rs.next()) {
                usuarios.add(ResultSetToObject(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    private TipoUsuario ResultSetToObject(ResultSet rs) throws Exception {
        TipoUsuario tipoUsuario = new TipoUsuario();

        try {
            tipoUsuario.setId(rs.getInt("id"));
            tipoUsuario.setTipo(rs.getString("tipo"));

        } catch (Exception e) {
            throw e;
        }

        return tipoUsuario;
    }
}
