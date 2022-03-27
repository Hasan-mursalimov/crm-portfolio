<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Users</title>
</head>
<body>
<h1>Sign In</h1>
<p>Please enter your data</p>
<br>
<form method="post" action="/signIn">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <label for="email">Enter email here:</label>
    <input id="email" type="text" name="email" placeholder="Your email">
    <label for="password">Enter password here:</label>
    <input id="password" type="text" name="password" placeholder="Your password">
    <input type="submit" name="" value="Sign In">

    <label>
        <input type="checkbox" name="rememberMe">Запомни меня
    </label>
</form>
</body>
</html>