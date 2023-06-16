package controller;

import dao.PedidoDAO;
import model.Entidade;
import model.Pedido;
import model.Usuario;
import service.PedidoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("pedidos")
public class PedidoController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");
        RequestDispatcher dispatcher;
        switch (opcao) {
            case "visualizar":
                dispatcher = VisualizarPedidos(req);
                break;
            case "criar":
                req.setAttribute("entidades", PedidoService.entidadeList());
                req.setAttribute("usuarios", PedidoService.usuarioList());
                dispatcher = CriarPedido(req);
                break;
            case "editar":
                req.setAttribute("entidades", PedidoService.entidadeList());
                req.setAttribute("usuarios", PedidoService.usuarioList());
                dispatcher = EditarPedido(req);
                break;
            case "salvar":
                Boolean salvou = SalvarPedido(req);
                dispatcher = VisualizarPedidos(req);
                break;
            case "excluir":
                ExcluirPedido(req);
                req.setAttribute("opcao", "visualizar");
                dispatcher = VisualizarPedidos(req);
                break;
            default:
                dispatcher = VisualizarPedidos(req);
        }
        dispatcher.forward(req, resp);
    }

    private RequestDispatcher VisualizarPedidos(HttpServletRequest req) {
        req.setAttribute("pedidos", new PedidoDAO().ListaPedido());
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/PedidoView/pedidos.jsp");
        return  dispatcher;
    }

    private RequestDispatcher CriarPedido(HttpServletRequest req) {
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/PedidoView/pedidoCriarOuEditar.jsp");
        return  dispatcher;
    }

    private RequestDispatcher EditarPedido(HttpServletRequest req) {
        String id = req.getParameter("id");
        Pedido pedido = PedidoService.getPedido(Integer.parseInt(id));

        if(pedido.getId() > 0) {
            req.setAttribute("id", pedido.getId());
            req.setAttribute("dataEntrega", pedido.getDataEntrega());
            req.setAttribute("dataDevolucao", pedido.getDataDevolucao());
            req.setAttribute("total", pedido.getTotal());
            req.setAttribute("entidadeId", pedido.getEntidade().getId());
            req.setAttribute("usuarioId", pedido.getUsuario().getId());

            req.setAttribute("opcao", "editar");
        }
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/PedidoView/pedidoCriarOuEditar.jsp");
        return  dispatcher;
    }

    private boolean SalvarPedido(HttpServletRequest req) {
        String id = req.getParameter("id");
        String dataEntrega = req.getParameter("dataEntrega");
        String dataDevolucao = req.getParameter("dataDevolucao");
        String total = req.getParameter("total");
        String entidadeId = req.getParameter("entidadeId");
        String usuarioId = req.getParameter("usuarioId");

        SimpleDateFormat formatter =new SimpleDateFormat("yyyy-mm-dd");

        Pedido pedido = new Pedido();
        try {
            pedido.setDataEntrega(formatter.parse(dataEntrega));
            pedido.setDataDevolucao(formatter.parse(dataDevolucao));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        pedido.setTotal(Float.parseFloat(total));
        if(id != "0")
            pedido.setId(Integer.parseInt(id));

        Entidade entidade = new Entidade();
        entidade.setId(Integer.parseInt(entidadeId));
        pedido.setEntidade(entidade);

        Usuario usuario = new Usuario();
        usuario.setId(Integer.parseInt(usuarioId));
        pedido.setUsuario(usuario);

        return PedidoService.salvarPedido(pedido);
    }

    private boolean ExcluirPedido(HttpServletRequest req) {
        String id = req.getParameter("id");

        Pedido pedido = new Pedido();
        if(id != null)
            pedido.setId(Integer.parseInt(id));
        else
            pedido.setId(0);

        return PedidoService.excluirPedido(pedido);
    }
}
