<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Страница клиента</title>
</head>
<body>
<table>
    <tr>
        <th>First name:</th>
        <td> ${client.firstName}</td><br>
        <th>Last name:</th>
        <td>${client.lastName}</td><br>
        <th>number tel:</th>
        <td>${client.numberTel}</td>
        <th>email</th>
        <td>${client.email}</td>
        <th>address:</th>
        <td>${client.address}
        <th>inn:</th>
        <td>${client.inn}</td>
        <th>trade name:</th>
        <td>${client.tradeName}</td>
        <th>legal name:</th>
        <td>${client.legalName}</td>
        <th>registration date:</th>
        <td>${client.registrationDate}</td>
    </tr>
</table>


</body>
</html>