package teste;

import dao.EntidadeDAO;
import model.Entidade;

public class ClienteTeste {
    public static void main(String[] args) {
        Entidade c = new Entidade("Allan3","11111");//cria um objeto cliente
        Entidade c1 = new Entidade("Rodrigues", "000.000.000-45");
        EntidadeDAO dao = new EntidadeDAO();//cria um objeto dao para acessar os métodos de manipulação do banco
        // dao.salvar(c);//salva o objeto cliente no banco de dados
        //dao.deletar(7);
        //dao.atualizar(c1,8);


    }
}
