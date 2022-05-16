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
<tr>
    <td>${client.firstName}</td>
    <br>
    <td>${client.lastName}</td>
    <br>
    <td>${client.numberTel}</td>
    <br>
    <td>${client.email}</td>
    <br>
    <td>${client.address}</td>
    <br>
    <td>${client.inn}</td>
    <br>
    <td>${client.tradeName}</td>
    <br>
    <td>${client.legalName}</td>
    <br>
    <td>${client.registrationDate}</td>
    <td>
        <head>
            <script>
                function disp(form) {
                    if (form.style.display == "none") {
                        form.style.display = "block";
                    } else {
                        form.style.display = "none";
                    }
                }
            </script>
        </head>
        <form id="form1" style="display: none;" method="post" action="/clients/clientProfile/${client.id}">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                <label for="numberTel">number tel</label>
                <input id="numberTel" type="tel" name="numberTel" placeholder="number tel">

                <label for="address">address</label>
                <input id="address" type="text" name="address" placeholder="address">

                <label for="email">email</label>
                <input id="email" type="email" name="email" placeholder="email">

                <input type="submit" name="" value="add">
            </form>
        </form>
        <input type="button" value="добавить" onclick="disp(document.getElementById('form1'))"/>
    </td>
</tr>
</body>
</html>