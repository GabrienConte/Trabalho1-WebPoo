<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
<h2>Logar usuário</h2>
<div>
    <form method="get" action="login" >
        <label for="name">Nome:</label>
            <input type="text" id="name" name="name">

        <label for="password">Senha:</label>
            <input type="text" id="password" name="password">
        <br>
        <br>
        <button type="submit">Autenticar</button>
    </form>
</div>
</body>
</html>