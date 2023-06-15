<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma-rtl.min.css">
</head>
<body>
<section class="section">
    <div class="container">
        <h1 class="title is-1">Entrar</h1>
        <div class="container box">
            <form method="get" action="login">
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