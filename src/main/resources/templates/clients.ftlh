<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Clients</title>
</head>
<body>
<h1>Клиенты</h1>
<br>
<table>
    <a href="/clients/saveClient" id="add">добавить</a>
    <tr>
        <th>ID</th>
        <th>Legal name</th>
        <th>Trade name</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Number tel</th>
    </tr>

    <#list clients as client>
        <tr>
            <td>${client.id}</td>
            <td>${client.legalName}</td>
            <td>${client.tradeName}</td>
            <td>${client.firstName}</td>
            <td>${client.lastName}</td>
            <td>${client.numberTel}</td>
            <td>
                <a href="/clients/${client.id}/clientProfile" id="clientProfile">перейти</a>
            </td>
        </tr>
    </#list>
</table>
<h2>Клиенты без менеджера</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Legal name</th>
        <th>Trade name</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Number tel</th>
    </tr>

    <#list clientWithOutUser as client>
    <tr>
        <td>${client.id}</td>
        <td>${client.legalName}</td>
        <td>${client.tradeName}</td>
        <td>${client.firstName}</td>
        <td>${client.lastName}</td>
        <td>${client.numberTel}</td>
        <td>
            <a href="/clients/${client.id}/clientProfile" id="clientProfile">перейти</a>
        </td>
        <td>
            <form method="post">
                <input type="hidden" name="id" value="${client.id}">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <input type="submit" name="" value="add">
            </form>
        </td>
        </#list>


</table>
</body>
</html>