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
<h1>Пользователи!</h1>
<br>
<a href="/signUp" id="add">Добавить</a>
<br>
<table>
    <tr>
        <th>Id</th>
        <th>Email</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Role</th>
    </tr>
    <#list accounts as account>
        <tr>
            <td>${account.id}</td>
            <td>${account.email}</td>
            <td>${account.firstName}</td>
            <td>${account.lastName}</td>
            <td>${account.role}</td>
            <td>${account.salesPlan}</td>

            <td>
                <form method="post" action="/users/${account.id}/delete">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="Delete">
                </form>
            </td>
            <div>
                <#if isSupervisor>
                    <td>
                        <form method="post" action="/users/${account.id}/update">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <input id="salesPlan" type="text" name="salesPlan" placeholder="sales plan">
                            <input type="submit" name="" value="update">
                        </form>
                    </td>
                </#if>
            </div>
            <td><a href="/profile/${account.id}" id="profile">перейти</a></td>
        </tr>
    </#list>
</table>
</body>
</html>

