package controller;

import dao.ProdutoDAO;
import model.Produto;
import service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import service.ProdutoService;

@WebServlet("produtos")
public class ProdutoController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");
        System.out.println(opcao);
        RequestDispatcher dispatcher;
        switch (opcao) {
            case "visualizar":
                dispatcher = VisualizarProdutos(req);
                break;
            case "criar":
                dispatcher = CriarProduto(req);
                break;
            case "editar":
                dispatcher = EditarProduto(req);
                break;
            case "salvar":
                Boolean salvou = SalvarProduto(req);
                dispatcher = VisualizarProdutos(req);
                break;
            case "excluir":
                ExcluirProduto(req);
                req.removeAttribute("id");
                req.setAttribute("opcao", "visualizar");
                dispatcher = VisualizarProdutos(req);
                break;
            default:
                dispatcher = VisualizarProdutos(req);
        }
        dispatcher.forward(req, resp);
    }

    private RequestDispatcher VisualizarProdutos(HttpServletRequest req) {
        req.setAttribute("produtos", new ProdutoDAO().ListaProduto());
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/produtos.jsp");
        return  dispatcher;
    }

    private RequestDispatcher CriarProduto(HttpServletRequest req) {
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/produtoCriarOuEditar.jsp");
        return  dispatcher;
    }

    private RequestDispatcher EditarProduto(HttpServletRequest req) {
        String id = req.getParameter("id");
        Produto produto = ProdutoService.getProduto(Integer.parseInt(id));

        if(produto.getId() > 0) {
            req.setAttribute("id", produto.getId());
            req.setAttribute("descricao", produto.getDescricao());
            req.setAttribute("marca", produto.getMarca());
            req.setAttribute("valor", produto.getValor());
            req.setAttribute("quantidade", produto.getQuantidade());
            req.setAttribute("opcao", "editar");
        }
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/produtoCriarOuEditar.jsp");
        return  dispatcher;
    }

    private boolean SalvarProduto(HttpServletRequest req) {
        String id = req.getParameter("id");
        String descricao = req.getParameter("descricao");
        String marca = req.getParameter("marca");
        String valor = req.getParameter("valor");
        String quantidade = req.getParameter("quantidade");

        Produto produto = new Produto();
        produto.setDescricao(descricao);
        produto.setMarca(marca);
        produto.setValor(Float.parseFloat(valor));
        produto.setQuantidade(Float.parseFloat(quantidade));
        if(id != "0")
            produto.setId(Integer.parseInt(id));

        return ProdutoService.salvarProduto(produto);
    }

    private boolean ExcluirProduto(HttpServletRequest req) {
        String id = req.getParameter("id");

        Produto produto = new Produto();
        if(id != null)
            produto.setId(Integer.parseInt(id));
        else
            produto.setId(0);

        return ProdutoService.excluirProduto(produto);
    }
}
