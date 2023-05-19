package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("login")
public class LoginController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* super.service(req, resp); */
        System.out.println("bateu no login");

        String login = req.getParameter("name");
        String password = req.getParameter("password");

        RequestDispatcher dispatcher;
        if(login.equals("conte") && password.equals("qwe")){
            System.out.println("Logado");
            dispatcher = req.getRequestDispatcher("/WEB-INF/principal.jsp");
        }else{
            System.out.println("deu ruim");
            dispatcher = req.getRequestDispatcher("/index.jsp");
        }

        dispatcher.forward(req, resp);
    }
}