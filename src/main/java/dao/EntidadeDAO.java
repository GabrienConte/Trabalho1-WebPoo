package dao;

import dao.conexao.ConectaDB;
import model.Endereco;
import model.Entidade;
import model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntidadeDAO {
    public boolean inserir(Entidade entidade) {
        boolean salvou  = false;
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO entidade (enderecoId, nome, cpf, telefone) ");
        sql.append("VALUES ( " + entidade.getEndereco().getId() + ", ");
        sql.append("         '" + entidade.getNome() + "', ");
        sql.append("         '" + entidade.getCpf() + "', ");
        sql.append("         '" + entidade.getTelefone()+ "'); ");

        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.execute(sql.toString());
            salvou = true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return salvou;
    }

    public boolean deletar(Entidade entidade) {
        boolean deletado = false;
        StringBuilder sql = new StringBuilder();

        sql.append("DELETE FROM entidade WHERE id = " + entidade.getId() + ";");

        try {
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql.toString());
            deletado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deletado;
    }

    public boolean atualizar(Entidade entidade) {

        boolean atualizado = false;
        StringBuilder sql = new StringBuilder();

        sql.append(" UPDATE entidade ");
        sql.append(" SET  enderecoId = " + entidade.getEndereco().getId() + ", ");
        sql.append("      nome ='" + entidade.getNome() + "', ");
        sql.append("      cpf = '" + entidade.getCpf() + "', ");
        sql.append("      telefone = '" + entidade.getTelefone() + "' ");
        sql.append(" WHERE id = " + entidade.getId() + ";");

        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql.toString());
            atualizado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return atualizado;
    }

    public void salvar(Entidade entidade) {
        if(entidade.getId() == 0) {
            this.inserir(entidade);
        } else {
            this.atualizar(entidade);
        }
    }

    public Entidade getEntidadeById(int id) {
        StringBuilder sql = new StringBuilder();
        Entidade entidade = new Entidade();

        sql.append("SELECT entidade.*, endereco.id as idEndereco, endereco.cep, endereco.logradouro, endereco.observacao FROM entidade, endereco ");
        sql.append("WHERE entidade.enderecoid = endereco.id AND entidade.id = " + id  + ";");

        try (Connection conn = new ConectaDB().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            if(rs.next()) {
                entidade = ResultSetToObject(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entidade;
    }

    public List<Entidade> ListaEntidade() {
        List<Entidade> entidades = new ArrayList<>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT entidade.*, endereco.id as idEndereco, endereco.cep, endereco.logradouro, endereco.observacao FROM entidade, endereco ");
        sql.append("WHERE entidade.enderecoid = endereco.id;");

        try (Connection conn = new ConectaDB().getConexao()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            while(rs.next()) {
                entidades.add(ResultSetToObject(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entidades;
    }

    private Entidade ResultSetToObject(ResultSet rs) throws Exception {
        Entidade entidade = new Entidade();

        try {
            entidade.setId(rs.getInt("id"));
            entidade.setNome(rs.getString("nome"));
            entidade.setCpf(rs.getString("cpf"));
            entidade.setTelefone(rs.getString("telefone"));

            Endereco endereco = new Endereco();
            endereco.setId(rs.getInt("enderecoid"));
            endereco.setCep(rs.getString("cep"));
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setObservacao(rs.getString("observacao"));
            entidade.setEndereco(endereco);
        } catch (Exception e) {
            throw e;
        }

        return entidade;
    }
}
