package dao;

import dao.conexao.ConectaDB;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public boolean salvar(Pedido pedido) {
        if(pedido.getId() == 0) {
            return this.inserir(pedido);
        } else {
            return this.atualizar(pedido);
        }
    }

    public Pedido getPedidoById(int id) {
        StringBuilder sql = new StringBuilder();
        Pedido pedido = new Pedido();

        sql.append("SELECT pedido.*, usu.id as idUsuario, usu.nome as nomeUsuario, usu.login, usu.email, usu.senha, usu.tiposuarioid ");
        sql.append("ent.id as idEntidade, ent.nome as nomeEntidade, ent.cpf,ent.telefone, ent.enderecoid, ");
        sql.append("tpu.id as idTipoUsuario, tpu.tipo ");
        sql.append("FROM pedido, usuario usu, entidade ent, endereco,tipoUsuario tpu ");
        sql.append("WHERE pedido.entidadeid = ent.id AND pedido.usuarioid = usu.id AND usu.tipousuarioId = tpu.id AND pedido.id = " + id  + ";");

        try (Connection conn = new ConectaDB().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            if(rs.next()) {
                pedido = ResultSetToObject(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pedido;
    }

    public List<Pedido> ListaPedido() {
        List<Pedido> pedidos = new ArrayList<>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT pedido.*, usu.id as idUsuario, usu.nome as nomeUsuario, usu.login, usu.email, usu.senha, usu.tiposuarioid ");
        sql.append("ent.id as idEntidade, ent.nome as nomeEntidade, ent.cpf,ent.telefone, ent.enderecoid, ");
        sql.append("tpu.id as idTipoUsuario, tpu.tipo ");
        sql.append("FROM pedido, usuario usu, entidade ent,tipoUsuario tpu ");
        sql.append("WHERE pedido.entidadeid = ent.id AND pedido.usuarioid = usu.id AND usu.tipousuarioId = tpu.id;");

        try (Connection conn = new ConectaDB().getConexao()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            while(rs.next()) {
                pedidos.add(ResultSetToObject(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    private Pedido ResultSetToObject(ResultSet rs) throws Exception {
        Pedido pedido = new Pedido();

        try {
            pedido.setId(rs.getInt("id"));
            pedido.setDataEntrega(rs.getDate("dataentrega"));
            pedido.setDataDevolucao(rs.getDate("datadevolucao"));
            pedido.setTotal(rs.getFloat("total"));

            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("usuarioid"));
            usuario.setNome(rs.getString("nomeUsuario"));
            usuario.setLogin(rs.getString("login"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));

            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setId(rs.getInt("tipousuarioId"));
            tipoUsuario.setTipo(rs.getString("tipo"));
            usuario.setTipoUsuario(tipoUsuario);

            pedido.setUsuario(usuario);

            Entidade entidade = new Entidade();
            entidade.setId(rs.getInt("entidadeid"));
            entidade.setNome(rs.getString("nomeEntidade"));
            entidade.setCpf(rs.getString("cpf"));
            entidade.setTelefone(rs.getString("telefone"));

            pedido.setEntidade(entidade);
        } catch (Exception e) {
            throw e;
        }

        return pedido;
    }
}
