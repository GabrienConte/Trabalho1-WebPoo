package dao;

import dao.conexao.ConectaDB;
import model.Entidade;
import model.Entidade;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    public Entidade getEntidade(){
        return null;
    }

    public ArrayList<Entidade> ListaEntidade(){
        return null;
    }
}
