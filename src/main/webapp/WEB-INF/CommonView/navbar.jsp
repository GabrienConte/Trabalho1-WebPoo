<%--
  Created by IntelliJ IDEA.
  User: Gabriel Conte
  Date: 15/06/2023
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<nav class="navbar m-5">
    <div class="navbar-brand">
        <a class="navbar-item">
            <img src="https://bulma.io/images/bulma-logo.png" width="112" height="28" alt="Bulma">
        </a>
    </div>

    <div id="navbarMenu" class="navbar-menu">
        <div class="navbar-start">
            <a class="navbar-item" href="../inicio.jsp">
                Inicio
            </a>
            <a class="navbar-item" href="../inicio.jsp">
                Novo Pedido
            </a>
            <a class="navbar-item" href="../inicio.jsp">
                Pedidos
            </a>
            <a class="navbar-item" href="../inicio.jsp">
                Clientes
            </a>
            <a class="navbar-item" href="produtos?opcao=visualizar">
                Produtos
            </a>
        </div>

        <div class="navbar-end">
            <div class="navbar-item has-dropdown is-hoverable mr-5">
                <a class="navbar-link">
                    Configuração do Sistema
                </a>
                <div class="navbar-dropdown">
                    <a class="navbar-item" href="../inicio.jsp">
                        Usuário
                    </a>
                    <hr class="navbar-divider">
                    <a class="navbar-item is-active" href="tiposusuario?opcao=visualizar">
                        Tipo Usuário
                    </a>
                </div>
            </div>
            <a class="button is-danger">
                <strong>Sair</strong>
            </a>
        </div>
    </div>
</nav>
