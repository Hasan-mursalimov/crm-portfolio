<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><@spring.message 'singUp.form.title'/></title>
</head>
<body>
<h1><@spring.message 'singUp.header'/></h1>
<p><@spring.message 'singUp.description'/></p>
<br>
<a href="?lang=ru">RU</a>
<br>
<a href="?lang=en">EN</a>
<form method="post" action="/signUp">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <br>

    <label for="firstName"><@spring.message 'singUp.form.label.firstName'/></label>
    <input id="firstName" type="text" name="firstName" placeholder="<@spring.message 'singUp.form.input.firstName'/>">

    <br>

    <label for="lastName"><@spring.message 'singUp.form.label.lastName'/></label>
    <input id="lastName" type="text" name="lastName" placeholder="<@spring.message 'singUp.form.input.lastName'/>">

    <br>

    <label for="email"><@spring.message 'singUp.form.label.email'/></label>
    <input id="email" type="text" name="email" placeholder="<@spring.message 'singUp.form.input.email'/>">

    <br>

    <label for="password"><@spring.message 'singUp.form.label.password'/></label>
    <input id="password" type="text" name="password" placeholder="<@spring.message 'singUp.form.input.password'/>">

    <br>

    <label for="numberTel"><@spring.message 'singUp.form.label.numberTel'/></label>
    <input id="numberTel" type="text" name="numberTel" placeholder="<@spring.message 'singUp.form.input.numberTel'/>">

    <br>

    <label for="numberTel">number tel</label>
    <input id="numberTel" type="text" name="numberTel" placeholder="number tel">

    <br>

    <select id="role" name="role">
        <option value="ADMIN">ADMIN</option>
        <option value="SALES_MANAGER">SALES_MANAGER</option>
        <option value="SERVICE_MANAGER">SERVICE_MANAGER</option>
        <option value="SUPERVISOR">SUPERVISOR</option>
    </select>

    <br>

    <input type="submit" name="" value="<@spring.message 'singUp.input.submit.value'/>">

</form>
</body>
</html>

