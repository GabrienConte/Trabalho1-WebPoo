package dao;

import dao.conexao.ConectaDB;
import model.TipoUsuario;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public boolean inserir(Usuario usuario) {
        boolean criou  = false;
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO usuario (tipoUsuarioId, nome, login, email, senha) ");
        sql.append("VALUES ( " + usuario.getTipoUsuario().getId() + ", ");
        sql.append("         '" + usuario.getNome() + "', ");
        sql.append("         '" + usuario.getLogin() + "', ");
        sql.append("         '" + usuario.getEmail() + "', ");
        sql.append("         '" + usuario.getSenha()+ "'); ");

        try (Connection conn = new ConectaDB().getConexao()) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql.toString());
            criou = true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return criou;
    }

    public boolean deletar(Usuario usuario) {
        boolean deletado = false;
        StringBuilder sql = new StringBuilder();

        sql.append("DELETE FROM usuario WHERE id = " + usuario.getId() + ";");

        try (Connection conn = new ConectaDB().getConexao()) {
            Statement stmt = conn.createStatement();
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

        try (Connection conn = new ConectaDB().getConexao()) {
            Statement stmt = conn.createStatement();
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

    public Usuario getUsuarioById(int id) {
        StringBuilder sql = new StringBuilder();
        Usuario usuario = new Usuario();

        sql.append("SELECT us.*, tu.id as idTipoUsuario, tu.tipo FROM usuario us, tipoUsuario tu  ");
        sql.append("WHERE us.tipousuarioId = tu.id AND us.id = " + id  + ";");

        try (Connection conn = new ConectaDB().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            if(rs.next()) {
                usuario = ResultSetToObject(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuario getUsuarioByLogin(String login){
        StringBuilder sql = new StringBuilder();
        Usuario usuario = new Usuario();

        sql.append("SELECT us.*, tu.id as idTipoUsuario, tu.tipo FROM usuario us, tipoUsuario tu  ");
        sql.append("WHERE us.tipousuarioId = tu.id AND us.login = '" + login  + "';");

        try (Connection conn = new ConectaDB().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            if(rs.next()) {
                usuario = ResultSetToObject(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public List<Usuario> ListaUsuario() {
        List<Usuario> usuarios = new ArrayList<>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT us.*, tu.id as idTipoUsuario, tu.tipo FROM usuario us, tipoUsuario tu  ");
        sql.append("WHERE us.tipousuarioId = tu.id;");

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

    private Usuario ResultSetToObject(ResultSet rs) throws Exception {
        Usuario usuario = new Usuario();

        try {
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));

            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setId(rs.getInt("tipousuarioId"));
            tipoUsuario.setTipo(rs.getString("tipo"));
            usuario.setTipoUsuario(tipoUsuario);
        } catch (Exception e) {
            throw e;
        }

        return usuario;
    }
}
