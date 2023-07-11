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
        <h1 class="title">Criar novo produto</h1>

        <div class="container">
          <form method="post" action="produtos">
            <input type="hidden" id="opcao" name="opcao" value="salvar">

            <input type="hidden" id="id" name="id" value="${id != null ? id : '0'}">

            <div class="field">
              <label class="label">Descrição</label>
              <div class="control">
                <input name="descricao" id="descricao" class="input" type="text" placeholder="Produto" value="${descricao != null ? descricao : ''}" required>
              </div>
            </div>

            <div class="field">
              <label class="label">Marca</label>
              <div class="control">
                <input name="marca" id="marca" class="input" type="text" placeholder="Marca" value="${marca != null ? marca : ''}" required>
              </div>
            </div>

            <div class="field">
              <label class="label">Valor</label>
              <div class="control">
                <input name="valor" id="valor" class="input" type="number" placeholder="0,00" value="${valor != null ? valor : 0}" required>
              </div>
            </div>

            <div class="field">
              <label class="label">Quantidade</label>
              <div class="control">
                <input name="quantidade" id="quantidade" class="input" type="number" placeholder="0" value="${quantidade != null ? quantidade : 0}" required>
              </div>
            </div>

            <div class="field is-grouped is-grouped-right">
              <p class="control">
                <button type="submit" class="button is-primary">
                  Salvar
                </button>
              </p>
              <p class="control">
                <button type="reset" class="button is-light">
                  Limpar
                </button>
              </p>
            </div>
          </form>
        </div>
      </section>
    </div>
  </main>
</div>
<%@ include file="../CommonView/footer.jsp" %>
</body>
</html>
