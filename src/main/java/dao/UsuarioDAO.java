package dao;

import dao.conexao.ConectaDB;
import model.Usuario;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {
    public boolean inserir(Usuario usuario) {
        boolean salvou  = false;
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO usuario (tipoUsuarioId, nome, login, email, senha) ");
        sql.append("VALUES ( " + usuario.getTipoUsuario().getId() + ", ");
        sql.append("         '" + usuario.getNome() + "', ");
        sql.append("         '" + usuario.getLogin() + "', ");
        sql.append("         '" + usuario.getEmail() + "', ");
        sql.append("         '" + usuario.getSenha()+ "'); ");

        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.execute(sql.toString());
            salvou = true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return salvou;
    }

    public boolean deletar(Usuario usuario) {
        boolean deletado = false;
        StringBuilder sql = new StringBuilder();

        sql.append("DELETE FROM usuario WHERE id = " + usuario.getId() + ";");

        try {
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql.toString());
            deletado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deletado;
    }

    public boolean atualizar(Usuario usuario) {

        boolean atualizado = false;
        StringBuilder sql = new StringBuilder();

        sql.append(" UPDATE usuario ");
        sql.append(" SET  tipoUsuarioId  =" + usuario.getTipoUsuario().getId() + ", ");
        sql.append("      nome ='" + usuario.getNome() + "', ");
        sql.append("      login = '" + usuario.getLogin() + "', ");
        sql.append("      email = '" + usuario.getEmail() + "', ");
        sql.append("      senha = '" + usuario.getSenha() + "' ");
        sql.append(" WHERE id = " + usuario.getId() + ";");

        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql.toString());
            atualizado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return atualizado;
    }

    public void salvar(Usuario usuario) {
        if(usuario.getId() == 0) {
            this.inserir(usuario);
        } else {
            this.atualizar(usuario);
        }
    }

    public Usuario getUsuario(){
        return null;
    }

    public ArrayList<Usuario> ListaUsuario(){
        return null;
    }
}
