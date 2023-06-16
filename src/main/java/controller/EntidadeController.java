package controller;

import dao.EntidadeDAO;
import model.Entidade;
import service.EntidadeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("entidades")
public class EntidadeController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");
        RequestDispatcher dispatcher;
        switch (opcao) {
            case "visualizar":
                dispatcher = VisualizarEntidades(req);
                break;
            case "criar":
                dispatcher = CriarEntidade(req);
                break;
            case "editar":
                dispatcher = EditarEntidade(req);
                break;
            case "salvar":
                Boolean salvou = SalvarEntidade(req);
                dispatcher = VisualizarEntidades(req);
                break;
            case "excluir":
                ExcluirEntidade(req);
                req.setAttribute("opcao", "visualizar");
                dispatcher = VisualizarEntidades(req);
                break;
            default:
                dispatcher = VisualizarEntidades(req);
        }
        dispatcher.forward(req, resp);
    }

    private RequestDispatcher VisualizarEntidades(HttpServletRequest req) {
        req.setAttribute("entidades", new EntidadeDAO().ListaEntidade());
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/EntidadeView/entidades.jsp");
        return  dispatcher;
    }

    private RequestDispatcher CriarEntidade(HttpServletRequest req) {
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/EntidadeView/entidadeCriarOuEditar.jsp");
        return  dispatcher;
    }

    private RequestDispatcher EditarEntidade(HttpServletRequest req) {
        String id = req.getParameter("id");
        Entidade entidade = EntidadeService.getEntidade(Integer.parseInt(id));

        if(entidade.getId() > 0) {
            req.setAttribute("id", entidade.getId());
            req.setAttribute("nome", entidade.getNome());
            req.setAttribute("cpf", entidade.getCpf());
            req.setAttribute("telefone", entidade.getTelefone());

            req.setAttribute("opcao", "editar");
        }
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/EntidadeView/entidadeCriarOuEditar.jsp");
        return  dispatcher;
    }

    private boolean SalvarEntidade(HttpServletRequest req) {
        String id = req.getParameter("id");
        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String telefone = req.getParameter("telefone");

        Entidade entidade = new Entidade();
        entidade.setNome(nome);
        entidade.setCpf(cpf);
        entidade.setTelefone(telefone);
        if(id != "0")
            entidade.setId(Integer.parseInt(id));

        return EntidadeService.salvarEntidade(entidade);
    }

    private boolean ExcluirEntidade(HttpServletRequest req) {
        String id = req.getParameter("id");

        Entidade entidade = new Entidade();
        if(id != null) {
            entidade = EntidadeService.getEntidade(Integer.parseInt(id));
        }
        else
            entidade.setId(0);

        return EntidadeService.excluirEntidade(entidade);
    }
}