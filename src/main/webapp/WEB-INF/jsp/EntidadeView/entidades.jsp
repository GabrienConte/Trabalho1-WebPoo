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
    <title>Clientes</title>
</head>
<body>
<%@ include file="../CommonView/navbar.jsp" %>
<div>
    <main>
        <div class="container content is-fluid mt-5 mb-5">
            <section>
                <h1 class="title">Lista de Clientes</h1>
                <div class="buttons">
                    <a href="entidades?opcao=criar" class="button is-normal is-link">Adicionar Cliente</a>
                </div>
                <div class="table-container">
                    <table class="table is-bordered is-hoverable">
                        <thead>
                        <tr class="has-text-centered is-size-4">
                            <th>Nome</th>
                            <th>CPF</th>
                            <th>Telefone</th>
                            <th>Ações</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="e" items="${entidades}">
                            <tr>
                                <th>${e.nome}</th>
                                <td>${e.cpf}</td>
                                <td>${e.telefone}</td>
                                <td>
                                    <a href="entidades?opcao=editar&id=${e.id}" class="button is-info is-light mr-3">Editar</a>
                                    <a href="entidades?opcao=excluir&id=${e.id}" class="button is-danger is-light">Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>
        </div>
    </main>
</div>
<%@ include file="../CommonView/footer.jsp" %>
</body>
</html>
