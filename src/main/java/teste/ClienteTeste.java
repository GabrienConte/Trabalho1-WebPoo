package teste;

import dao.ClienteDao;
import model.Cliente;

public class ClienteTeste {
    public static void main(String[] args) {
        Cliente c = new Cliente("Allan3","11111");//cria um objeto cliente
        Cliente c1 = new Cliente("Rodrigues", "000.000.000-45");
        ClienteDao dao = new ClienteDao();//cria um objeto dao para acessar os métodos de manipulação do banco
        // dao.salvar(c);//salva o objeto cliente no banco de dados
        //dao.deletar(7);
        //dao.atualizar(c1,8);


    }
}
