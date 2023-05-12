package dao;

import model.Cliente;
import java.sql.SQLException;//importa a classe SQLException para tratar os erros de conexão com o banco de dados
import java.sql.Statement;//importa a classe Statement para executar os comandos sql no banco de dados
import java.util.ArrayList;//importa a classe ArrayList para armazenar os objetos do tipo Cliente
import java.util.Scanner;

public class ClienteDao {
    public boolean salvar(Cliente c){//método para salvar um objeto do tipo Cliente no banco de dados

        boolean salvou  = false;//variável para verificar se o objeto foi salvo no banco de dados
        String sql = "INSERT INTO cliente(nomecliente, cpf) VALUES ('"+c.getNome() +"', '"+ c.getCpf()+"')";
        System.out.println("SQL: " +sql);

        try{//tenta executar o comando sql no banco de dados
            Statement stmt = new ConectaDB().getConexao().createStatement();//cria um objeto para executar o comando sql no banco de dados
            stmt.execute(sql);//executa o comando sql no banco de dados
            salvou = true;//se executou o comando sql no banco de dados, a variável salvou recebe true

        }catch (SQLException e){//caso ocorra algum erro, imprime o erro no console
            e.printStackTrace();
        }


        return salvou;
    }

    public boolean deletar(int id) {
        boolean deletado = false;
        String sql = "DELETE FROM cliente WHERE idcliente = '" + id + "'";
        try {
            Statement stmt = new ConectaDB().getConexao().createStatement();
            stmt.executeUpdate(sql);
            deletado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deletado;
    }

    public boolean atualizar(Cliente c, int id){//atualizar cliente
        boolean atualizado = false;//variável para verificar se o objeto foi atualizado no banco de dados
        System.out.println("deseja atualizar o nome, cpf ou ambos?");
        Scanner scan = new Scanner(System.in);
        String opcao = scan.nextLine();

        if(opcao.equals("nome")){
            String sql = "UPDATE cliente SET nomecliente ='" + c.getNome() + "' WHERE idcliente = '" + id + "'";
            try{
                Statement stmt = new ConectaDB().getConexao().createStatement();
                stmt.executeUpdate(sql);
                atualizado = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(opcao.equals("cpf")){
            String sqlcpf = "UPDATE cliente SET cpf ='" + c.getCpf() + "' WHERE idcliente = '" + id + "'";
            try{
                Statement stmt = new ConectaDB().getConexao().createStatement();
                stmt.executeUpdate(sqlcpf);
                atualizado = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else if(opcao.equals("ambos")){
            String sql = "UPDATE cliente SET nomecliente ='" + c.getNome() + "' WHERE idcliente = '" + id + "'";
            String sqlcpf = "UPDATE cliente SET cpf ='" + c.getCpf() + "' WHERE idcliente = '" + id + "'";
            try{
                Statement stmt = new ConectaDB().getConexao().createStatement();
                stmt.executeUpdate(sql);
                stmt.executeUpdate(sqlcpf);
                atualizado = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return atualizado;
    }

    public ArrayList<Cliente> getClientes(){
        return null;
    }
}
