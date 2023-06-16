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
    <title>Pedidos</title>
</head>
<body>
<%@ include file="../CommonView/navbar.jsp" %>
<div>
    <main>
        <div class="container content is-fluid mt-5 mb-5">
            <section>
                <h1 class="title">Criar novo Pedido</h1>

                <div class="container">
                    <form method="post" action="pedidos">
                        <input type="hidden" id="opcao" name="opcao" value="salvar">

                        <input type="hidden" id="id" name="id" value="${id != null ? id : '0'}">

                        <div class="field">
                            <label class="label">Data Entrega</label>
                            <div class="control">
                                <input name="dataEntrega" id="dataEntrega" class="input" type="date" value="${dataEntrega != null ? dataEntrega : ''}" required>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">Data Devolução</label>
                            <div class="control">
                                <input name="dataDevolucao" id="dataDevolucao" class="input" type="date" value="${dataDevolucao != null ? dataDevolucao : ''}" required>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">Total</label>
                            <div class="control">
                                <input name="total" id="total" class="input" type="number" placeholder="E-mail" value="${total != null ? total : '0'}" required>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">Cliente</label>
                            <div class="control">
                                <div class="select">
                                    <select name="entidadeId" required >
                                        <option value="">.. Selecione ..</option>
                                        <c:forEach var="e" items="${entidades}">
                                            <option value="${e.id}">${e.nome}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">Usuário</label>
                            <div class="control">
                                <div class="select">
                                    <select name="usuarioId" required >
                                        <option value="">.. Selecione ..</option>
                                        <c:forEach var="u" items="${usuarios}">
                                            <option value="${u.id}">${u.nome}</option>
                                        </c:forEach>
                                    </select>
                                </div>
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
