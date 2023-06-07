package dao;

import dao.conexao.ConectaDB;
import model.Endereco;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EnderecoDAO {
    public boolean inserir(Endereco endereco) {
        boolean salvou  = false;
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO endereco (cep, logradouro, observacao) ");
        sql.append("VALUES ('" + endereco.getCep() + "', ");
        sql.append("        '" + endereco.getLogradouro() + "', ");
        sql.append("        '" + endereco.getObservacao()+ "'); ");

        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.execute(sql.toString());
            salvou = true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return salvou;
    }

    public boolean deletar(Endereco endereco) {
        boolean deletado = false;
        StringBuilder sql = new StringBuilder();

        sql.append("DELETE FROM endereco WHERE id = " + endereco.getId() + ";");

        try {
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql.toString());
            deletado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deletado;
    }

    public boolean atualizar(Endereco endereco) {

        boolean atualizado = false;
        StringBuilder sql = new StringBuilder();

        sql.append(" UPDATE endereco ");
        sql.append(" SET  cep = '" + endereco.getCep() + "', ");
        sql.append("      logradouro = '" + endereco.getLogradouro() + "', ");
        sql.append("      observacao = '" + endereco.getObservacao() + "' ");
        sql.append(" WHERE id = " + endereco.getId() + ";");

        try{
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql.toString());
            atualizado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return atualizado;
    }

    public void salvar(Endereco endereco) {
        if(endereco.getId() == 0) {
            this.inserir(endereco);
        } else {
            this.atualizar(endereco);
        }
    }

    public Endereco getEndereco(){
        return null;
    }

    public ArrayList<Endereco> ListaEndereco(){
        return null;
    }
}
