<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <%@ include file="CommonView/header.jsp" %>
    <title>Login</title>
</head>
<body>
<section class="section">
    <nav class="navbar" role="navigation" aria-label="main navigation">
        <div class="navbar-brand">
            <a class="navbar-item">
                <img src="C:\Users\Gabriel Conte\Desktop\UFSM\WebPoo\trabalho1_webpoo\images\cav-removebg-preview.png">
            </a>

            <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
                <span aria-hidden="true"></span>
                <span aria-hidden="true"></span>
                <span aria-hidden="true"></span>
            </a>
        </div>

        <div id="navbarBasicExample" class="navbar-menu">
            <div class="navbar-start">

            </div>

            <div class="navbar-end">
                <div class="navbar-item">

                </div>
            </div>
        </div>
    </nav>
    <div class="container">
        <h1 class="title is-1">Entrar</h1>
        <div class="container box">
            <form method="post" action="login">
                <div class="field">
                    <label class="label" for="login">Login</label>
                    <p class="control">
                        <input id="login" name="login" class="input" type="text" placeholder="Login">
                        <span class="icon is-small is-left">
                            <i class="fas fa-envelope"></i>
                        </span>
                    </p>
                </div>
                <div class="field">
                    <label class="label" for="senha">Senha</label>
                    <p class="control">
                        <input id="senha" name="senha" class="input" type="password" placeholder="Senha">
                        <span class="icon is-small is-left">
                          <i class="fas fa-lock"></i>
                        </span>
                    </p>
                </div>
                <div class="field">
                    <p class="control">
                        <button type="submit" class="button is-success">
                            Login
                        </button>
                    </p>
                </div>
            </form>
        </div>
    </div>
</section>
</body>
</html>