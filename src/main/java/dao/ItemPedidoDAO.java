package dao;

import dao.conexao.ConectaDB;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public ItemPedido getItemPedidoById(int id) {
        StringBuilder sql = new StringBuilder();
        ItemPedido itempedido = new ItemPedido();

        sql.append("SELECT itempedido.*, " );
        sql.append("    prd.id as idProduto, prd.descricao, prd.marca, prd.quantidade, prd.valor ");
        sql.append("    ped.id as idPedido, ped.usuarioid, ped.entidadeid, ped.dataentrega, ped.datadevolucao, ped.total ");
        sql.append("    usu.id as idUsuario, usu.nome as nomeUsuario, usu.login, usu.email, usu.senha, usu.tiposuarioid ");
        sql.append("    ent.id as idEntidade, ent.nome as nomeEntidade, ent.cpf,ent.telefone, ent.enderecoid, ");
        sql.append("    endereco.id as idEndereco, endereco.cep, endereco.logradouro, endereco.observacao");
        sql.append("    tpu.id as idTipoUsuario, tpu.tipo ");
        sql.append("FROM itempedido, produto prod,pedido ped, usuario usu, entidade ent, endereco,tipoUsuario tpu ");
        sql.append("WHERE itempedido.produtoid = prod.id AND itempedido.pedidoid = ped.id ");
        sql.append("    AND ped.entidadeid = ent.id AND ent.enderecoid = endereco.id AND ped.usuarioid = usu.id AND usu.tipousuarioId = tpu.id ");
        sql.append("    AND itempedido.id = " + id + ";"  );

        try (Connection conn = new ConectaDB().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            if(rs.next()) {
                itempedido = ResultSetToObject(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return itempedido;
    }

    public List<ItemPedido> ListaItemPedido() {
        List<ItemPedido> itemPedidos = new ArrayList<>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT itempedido.*, " );
        sql.append("    prd.id as idProduto, prd.descricao, prd.marca, prd.quantidade, prd.valor ");
        sql.append("    ped.id as idPedido, ped.usuarioid, ped.entidadeid, ped.dataentrega, ped.datadevolucao, ped.total ");
        sql.append("    usu.id as idUsuario, usu.nome as nomeUsuario, usu.login, usu.email, usu.senha, usu.tiposuarioid ");
        sql.append("    ent.id as idEntidade, ent.nome as nomeEntidade, ent.cpf,ent.telefone, ent.enderecoid, ");
        sql.append("    endereco.id as idEndereco, endereco.cep, endereco.logradouro, endereco.observacao");
        sql.append("    tpu.id as idTipoUsuario, tpu.tipo ");
        sql.append("FROM itempedido, produto prod,pedido ped, usuario usu, entidade ent, endereco,tipoUsuario tpu ");
        sql.append("WHERE itempedido.produtoid = prod.id AND itempedido.pedidoid = ped.id ");
        sql.append("    AND ped.entidadeid = ent.id AND ent.enderecoid = endereco.id AND ped.usuarioid = usu.id AND usu.tipousuarioId = tpu.id;");

        try (Connection conn = new ConectaDB().getConexao()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            while(rs.next()) {
                itemPedidos.add(ResultSetToObject(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemPedidos;
    }

    private ItemPedido ResultSetToObject(ResultSet rs) throws Exception {
        ItemPedido itempedido = new ItemPedido();

        try {
            itempedido.setId(rs.getInt("id"));
            itempedido.setTotal(rs.getFloat("total"));
            itempedido.setQuantidade(rs.getFloat("quantidade"));

            Pedido pedido = new Pedido();
            pedido.setId(rs.getInt("id"));
            pedido.setDataEntrega(rs.getDate("dataentrega"));
            pedido.setDataDevolucao(rs.getDate("datadevolucao"));
            pedido.setTotal(rs.getFloat("totalPedido"));

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

            Entidade entidade = new Entidade();
            entidade.setId(rs.getInt("entidadeid"));
            entidade.setNome(rs.getString("nomeEntidade"));
            entidade.setCpf(rs.getString("cpf"));
            entidade.setTelefone(rs.getString("telefone"));

            Endereco endereco = new Endereco();
            endereco.setId(rs.getInt("enderecoid"));
            endereco.setCep(rs.getString("cep"));
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setObservacao(rs.getString("observacao"));
            entidade.setEndereco(endereco);

            pedido.setUsuario(usuario);
            pedido.setEntidade(entidade);

            itempedido.setPedido(pedido);

            Produto produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setMarca(rs.getString("login"));
            produto.setQuantidade(rs.getFloat("quantidade"));
            produto.setValor(rs.getFloat("valor"));

            itempedido.setProduto(produto);
        } catch (Exception e) {
            throw e;
        }

        return itempedido;
    }
}
