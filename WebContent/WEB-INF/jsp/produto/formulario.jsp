<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p001495
  Date: 22/04/2019
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Novo Produto</title>
</head>
<body>

<table>
    <form action="<c:url value="/produto/adiciona"/>"method="post">
        <tr>
            <td>Nome</td><td><input name="produto.nome"></td>
        </tr>
        <tr>
            <td>Descricao</td><td><input name="produto.descricao"></td>
        </tr>
        <tr>
            <td>Preço</td><td><input name="produto.preco"></td>
        </tr>
        <tr>
            <td>Cor</td><td><input name="produto.cor"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Adiciona Produto"></td>
        </tr>

    </form>
</table>

</body>
</html>
