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
  <title>Usuários</title>
</head>
<body>
<%@ include file="../CommonView/navbar.jsp" %>
<div>
  <main>
    <div class="container content is-fluid mt-5 mb-5">
      <section>
        <h1 class="title">Lista de Usuários</h1>
        <div class="buttons">
          <a href="usuarios?opcao=criar" class="button is-normal is-link">Adicionar Usuário</a>
        </div>
        <div class="table-container">
          <table class="table is-bordered is-hoverable">
            <thead>
            <tr class="has-text-centered is-size-4">
              <th>Nome</th>
              <th>Login</th>
              <th>E-mail</th>
              <th>Tipo</th>
              <th>Ações</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="u" items="${usuarios}">
              <tr>
                <th>${u.nome}</th>
                <td>${u.login}</td>
                <td>${u.email}</td>
                <td>${u.tipoUsuario.tipo}</td>
                <td>
                  <a href="usuarios?opcao=editar&id=${u.id}" class="button is-info is-light mr-3">Editar</a>
                  <a href="usuarios?opcao=excluir&id=${u.id}" class="button is-danger is-light">Excluir</a>
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
