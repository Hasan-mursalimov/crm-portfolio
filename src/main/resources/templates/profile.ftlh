<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<title>Страница сотрудника</title>
<tr>
    <h1>${user.firstName} ${user.lastName}</h1>
    <h2>${user.numberTel} ${user.email}</h2>
    <h3>${user.salesPlan} ${user.completedPlan}</h3>

</tr>
<table>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Trade name</th>
    </tr>
    <a href="/clients/saveClient/" id="clients">Добавить клиентов</a>
    <#list  clients as client>
        <tr>
            <td>${client.firstName}</td>
            <td>${client.lastName}</td>
            <td>${client.tradeName}</td>

            <td>
                <form method="post" action="/profile/${user.id}/delete/${client.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="delete">
                </form>
            </td>
            <td>
                <a href="/clients/clientProfile/${client.id}" id="clientProfile">перейти</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>