<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel='stylesheet' href=
            'https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css'>
    <title></title>
</head>
<body>
<div class="hero is-fullheight">
    <div class="container is-fluid mt-3">
    <nav class="navbar">
        <div class="navbar-brand">
            <a class="navbar-item">
                <img src="https://bulma.io/images/bulma-logo.png" width="112" height="28" alt="Bulma">
            </a>
        </div>

        <div id="navbarMenu" class="navbar-menu">
            <div class="navbar-start">
                <a class="navbar-item is-active" href="principal.jsp">
                    Inicio
                </a>
                <a class="navbar-item" href="inicio.jsp">
                    Novo Pedido
                </a>
                <a class="navbar-item" href="inicio.jsp">
                    Pedidos
                </a>
                <a class="navbar-item" href="inicio.jsp">
                    Clientes
                </a>
                <a class="navbar-item" href="produtos?opcao=visualizar">
                    Produtos
                </a>
            </div>

            <div class="navbar-end">
                <div class="navbar-item has-dropdown is-hoverable">
                    <a class="navbar-link">
                        Configuração do Sistema
                    </a>
                    <div class="navbar-dropdown">
                        <a class="navbar-item" href="inicio.jsp">
                            Usuário
                        </a>
                        <hr class="navbar-divider">
                        <a class="navbar-item" href="inicio.jsp">
                            Tipo Usuário
                        </a>
                    </div>
                </div>
                <a class="button is-warning">
                    <strong>Sair</strong>
                </a>
            </div>
        </div>
    </nav>
    </div>
    <main>
        <div class="container mt-5 mb-5">
            <%@include file="inicio.jsp" %>
        </div>
    </main>
    <footer class="footer has-background-warning">
        <div class="content has-text-centered">
            <p>
                <strong>Cavalheiro Locações Web</strong> by Gabriel Conte.
                <a class="is-pulled-right">
                    <img src="https://bulma.io/images/made-with-bulma--black.png" alt="Made With Bulma" width="128" height="54">
                </a>
            </p>
        </div>
    </footer>
</div>
</body>
</html>