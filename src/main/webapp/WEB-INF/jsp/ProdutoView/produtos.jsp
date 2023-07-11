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
    <%@ include file="../CommonView/header.jsp" %>
    <title>Produtos</title>
</head>
<body>
<%@ include file="../CommonView/navbar.jsp" %>
<div>
    <main>
        <div class="container content is-fluid mt-5 mb-5">
            <section>
                <h1 class="title">Lista de produtos</h1>
                <div class="buttons">
                    <a href="produtos?opcao=criar" class="button is-normal is-link">Adicionar Produto</a>
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
<%@ include file="../CommonView/footer.jsp" %>
</body>
</html>
