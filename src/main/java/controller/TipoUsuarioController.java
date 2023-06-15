package controller;

import dao.TipoUsuarioDAO;
import model.TipoUsuario;
import service.TipoUsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("tiposusuario")
public class TipoUsuarioController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");
        System.out.println(opcao);
        RequestDispatcher dispatcher;
        switch (opcao) {
            case "visualizar":
                dispatcher = VisualizarTipoUsuarios(req);
                break;
            case "criar":
                dispatcher = CriarTipoUsuario(req);
                break;
            case "editar":
                dispatcher = EditarTipoUsuario(req);
                break;
            case "salvar":
                Boolean salvou = SalvarTipoUsuario(req);
                dispatcher = VisualizarTipoUsuarios(req);
                break;
            case "excluir":
                ExcluirTipoUsuario(req);
                req.removeAttribute("id");
                req.setAttribute("opcao", "visualizar");
                dispatcher = VisualizarTipoUsuarios(req);
                break;
            default:
                dispatcher = VisualizarTipoUsuarios(req);
        }
        dispatcher.forward(req, resp);
    }

    private RequestDispatcher VisualizarTipoUsuarios(HttpServletRequest req) {
        req.setAttribute("tiposUsuario", new TipoUsuarioDAO().ListaTipoUsuario());
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/TipoUsuarioView/tiposusuario.jsp");
        return  dispatcher;
    }

    private RequestDispatcher CriarTipoUsuario(HttpServletRequest req) {
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/TipoUsuarioView/tipousuarioCriarOuEditar.jsp");
        return  dispatcher;
    }

    private RequestDispatcher EditarTipoUsuario(HttpServletRequest req) {
        String id = req.getParameter("id");
        TipoUsuario tipoUsuario = TipoUsuarioService.getTipoUsuario(Integer.parseInt(id));

        if(tipoUsuario.getId() > 0) {
            req.setAttribute("id", tipoUsuario.getId());
            req.setAttribute("tipo", tipoUsuario.getTipo());
            req.setAttribute("opcao", "editar");
        }
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/TipoUsuarioView/tipousuarioCriarOuEditar.jsp");
        return  dispatcher;
    }

    private boolean SalvarTipoUsuario(HttpServletRequest req) {
        String id = req.getParameter("id");
        String tipo = req.getParameter("tipo");

        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setTipo(tipo);
        if(id != "0")
            tipoUsuario.setId(Integer.parseInt(id));

        return TipoUsuarioService.salvarTipoUsuario(tipoUsuario);
    }

    private boolean ExcluirTipoUsuario(HttpServletRequest req) {
        String id = req.getParameter("id");

        TipoUsuario tipoUsuario = new TipoUsuario();
        if(id != null)
            tipoUsuario.setId(Integer.parseInt(id));
        else
            tipoUsuario.setId(0);

        return TipoUsuarioService.excluirTipoUsuario(tipoUsuario);
    }
}
