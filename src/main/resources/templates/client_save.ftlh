<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Save Client</title>
</head>
<body>
<h1>Save client</h1>
<p>save client</p>
<br>
<form method="post" action="/clients/saveClient">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <br>

    <label for="firstName">first name</label>
    <input id="firstName" type="text" name="firstName" placeholder="first name">

    <br>

    <label for="lastName">last name</label>
    <input id="lastName" type="text" name="lastName" placeholder="last name">

    <br>

    <label for="inn">inn</label>
    <input id="inn" type="text" name="inn" placeholder="inn">

    <br>

    <label for="legalName">legal name</label>
    <input id="legalName" type="text" name="legalName" placeholder="legal name">

    <br>

    <label for="tradeName">trade name</label>
    <input id="tradeName" type="text" name="tradeName" placeholder="trade name">

    <br>

    <label for="numberTel">number tel</label>
    <input id="numberTel" type="tel" name="numberTel" placeholder="number tel">

    <br>

    <label for="birthday">birthday</label>
    <input id="birthday" type="date" name="birthday" placeholder="birthday">

    <br>

    <label for="address">address</label>
    <input id="address" type="text" name="address" placeholder="address">

    <br>

    <br>

    <label for="email">email</label>
    <input id="email" type="email" name="email" placeholder="email">


        <select id="accounts" name="accountId">
            <#list accounts as account>
            <option value="${account.id}">${account.firstName} ${account.lastName}</option>
            </#list>
        </select>
    <br>

    <input type="submit" name="" value="add">
</form>
</body>
</html>