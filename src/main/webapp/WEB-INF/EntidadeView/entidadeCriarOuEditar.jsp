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
                <h1 class="title">Criar novo Cliente</h1>

                <div class="container">
                    <form method="post" action="entidades">
                        <input type="hidden" id="opcao" name="opcao" value="salvar">

                        <input type="hidden" id="id" name="id" value="${id != null ? id : '0'}">
                        <input type="hidden" id="enderecoId" name="enderecoId" value="${enderecoId != null ? id : '0'}">

                        <div class="field">
                            <label class="label">Nome</label>
                            <div class="control">
                                <input name="nome" id="nome" class="input" type="text" placeholder="Nome" value="${nome != null ? nome : ''}" required>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">CPF</label>
                            <div class="control">
                                <input name="cpf" id="cpf" class="input" type="text" placeholder="999.999.999-99" value="${cpf != null ? cpf : ''}" required>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">Telefone</label>
                            <div class="control">
                                <input name="telefone" id="telefone" class="input" type="text" placeholder="(55)99999-9999" value="${telefone != null ? telefone : ''}" required>
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
