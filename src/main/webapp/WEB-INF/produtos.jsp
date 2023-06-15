<%--
  Created by IntelliJ IDEA.
  User: Gabriel Conte
  Date: 15/06/2023
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel='stylesheet' href=
            'https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css'>
    <title>Produtos</title>
</head>
<body>
<nav class="navbar m-5">
        <div class="navbar-brand">
            <a class="navbar-item">
                <img src="https://bulma.io/images/bulma-logo.png" width="112" height="28" alt="Bulma">
            </a>
        </div>

        <div id="navbarMenu" class="navbar-menu">
            <div class="navbar-start">
                <a class="navbar-item" href="inicio.jsp">
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
                <a class="navbar-item is-active" href="produtos?opcao=visualizar">
                    Produtos
                </a>
            </div>

            <div class="navbar-end">
                <div class="navbar-item has-dropdown is-hoverable mr-5">
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
                <a class="button is-danger">
                    <strong>Sair</strong>
                </a>
            </div>
        </div>
    </nav>
<div>
    <main>
        <div class="container content is-fluid mt-5 mb-5">
            <section>
                <h1 class="title">Lista de produtos</h1>
                <div class="buttons">
                    <a href="produtos?opcao=criar" class="button is-normal is-link">Adiconar Produto</a>
                </div>
                <div class="table-container">
                    <table class="table is-bordered is-hoverable">
                        <thead>
                        <tr class="has-text-centered is-size-4">
                            <th>Descrição</th>
                            <th>Marca</th>
                            <th>Quantidade</th>
                            <th>Valor</th>
                            <th>Ações</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="p" items="${produtos}">
                            <tr>
                                <th>${p.descricao}</th>
                                <td>${p.marca}</td>
                                <td>${p.quantidade}</td>
                                <td>R$: ${p.valor}</td>
                                <td>
                                    <a href="produtos?opcao=editar&id=${p.id}" class="button is-info is-light mr-3">Editar</a>
                                    <a href="produtos?opcao=excluir&id=${p.id}" class="button is-danger is-light">Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>
            <section class="level mt-5">
                <div class="level-item has-text-centered">
                    <div>
                        <p class="heading">Tweets</p>
                        <p class="title">3,456</p>
                    </div>
                </div>
                <div class="level-item has-text-centered">
                    <div>
                        <p class="heading">Following</p>
                        <p class="title">123</p>
                    </div>
                </div>
                <div class="level-item has-text-centered">
                    <div>
                        <p class="heading">Followers</p>
                        <p class="title">456K</p>
                    </div>
                </div>
                <div class="level-item has-text-centered">
                    <div>
                        <p class="heading">Likes</p>
                        <p class="title">789</p>
                    </div>
                </div>
            </section>
        </div>
    </main>
</div>
<footer class="footer has-background-warning">
    <div class="content has-text-centered">
        <p>
            <strong>Cavalheiro Locações Web</strong> by Gabriel Conte.
            <a class="is-pulled-right">
                <img src="https://bulma.io/images/made-with-bulma--black.png" alt="Made With Bulma" width="128" height="54">
            </a>
        </p>
    </div>

    <div class="columns">
        <!-- Column 1 -->
        <div class="column">
            <!-- Heading is left aligned, medium weight -->
            <h4 class="bd-footer-title
                 has-text-weight-medium
                 has-text-left">
                GeeksforGeeks
            </h4>
            <!-- footer content -->
            <p class="bd-footer-link
                has-text-left">
                GeeksforGeeks is a web portal for
                geeks who wants to learn about
                Computer Science and want to see
                Tutorials, Articles, etc.
            </p>

        </div>
        <!-- Column 2 -->
        <div class="column">
            <h4 class="bd-footer-title
                 has-text-weight-medium
                 has-text-justify">
                Explore
            </h4>
            <!-- Column 2 lists with links -->
            <p class="bd-footer-link">
                <a href="https://">
          <span class="icon-text">
            <span>Practice</span>
          </span>
                </a>
                <br />
                <a href="https://">
              <span class="icon-text">
                <span>Blogs</span>
              </span>
                </a>
                <br />
                <a href="https://">
              <span class="icon-text">
                <span>Careers</span>
              </span>
                </a>
            </p>
        </div>
        <!-- Column 3 -->
        <div class="column">
            <h4 class="bd-footer-title
                 has-text-weight-medium
                 has-text-justify">
                Contact us
            </h4>
            <!-- Column 3 lists with links -->
            <p class="bd-footer-link">
                <a href="https://">
              <span class="icon-text">
                <span>Email</span>
              </span>
                </a>
                <br />
                <a href="https://">
              <span class="icon-text">
                <span>Call Us</span>
              </span>
                </a>
                <br />
                <a href="https://">
              <span class="icon-text">
                <span>Chat with us!</span>
              </span>
                </a>
            </p>
        </div>
    </div>
</footer>
</body>
</html>
