package controller;

import dao.UsuarioDAO;
import model.TipoUsuario;
import model.Usuario;
import service.UsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("usuarios")
public class UsuarioController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");
        RequestDispatcher dispatcher;
        switch (opcao) {
            case "visualizar":
                dispatcher = VisualizarUsuarios(req);
                break;
            case "criar":
                req.setAttribute("tiposUsuario", UsuarioService.tipoUsuarioList());
                dispatcher = CriarUsuario(req);
                break;
            case "editar":
                req.setAttribute("tiposUsuario", UsuarioService.tipoUsuarioList());
                dispatcher = EditarUsuario(req);
                break;
            case "salvar":
                Boolean salvou = SalvarUsuario(req);
                dispatcher = VisualizarUsuarios(req);
                break;
            case "excluir":
                ExcluirUsuario(req);
                req.setAttribute("opcao", "visualizar");
                dispatcher = VisualizarUsuarios(req);
                break;
            default:
                dispatcher = VisualizarUsuarios(req);
        }
        dispatcher.forward(req, resp);
    }

    private RequestDispatcher VisualizarUsuarios(HttpServletRequest req) {
        req.setAttribute("usuarios", new UsuarioDAO().ListaUsuario());
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/UsuarioView/usuarios.jsp");
        return  dispatcher;
    }

    private RequestDispatcher CriarUsuario(HttpServletRequest req) {
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/UsuarioView/usuarioCriarOuEditar.jsp");
        return  dispatcher;
    }

    private RequestDispatcher EditarUsuario(HttpServletRequest req) {
        String id = req.getParameter("id");
        Usuario usuario = UsuarioService.getUsuario(Integer.parseInt(id));

        if(usuario.getId() > 0) {
            req.setAttribute("id", usuario.getId());
            req.setAttribute("nome", usuario.getNome());
            req.setAttribute("login", usuario.getLogin());
            req.setAttribute("email", usuario.getEmail());
            req.setAttribute("senha", usuario.getSenha());
            req.setAttribute("tipoUsuarioId", usuario.getTipoUsuario().getId());

            req.setAttribute("opcao", "editar");
        }
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/UsuarioView/usuarioCriarOuEditar.jsp");
        return  dispatcher;
    }

    private boolean SalvarUsuario(HttpServletRequest req) {
        String id = req.getParameter("id");
        String nome = req.getParameter("nome");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String tipoUsuarioId = req.getParameter("tipoUsuarioId");

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        if(id != "0")
            usuario.setId(Integer.parseInt(id));

        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setId(Integer.parseInt(tipoUsuarioId));
        usuario.setTipoUsuario(tipoUsuario);
        return UsuarioService.salvarUsuario(usuario);
    }

    private boolean ExcluirUsuario(HttpServletRequest req) {
        String id = req.getParameter("id");

        Usuario usuario = new Usuario();
        if(id != null)
            usuario.setId(Integer.parseInt(id));
        else
            usuario.setId(0);

        return UsuarioService.excluirUsuario(usuario);
    }
}