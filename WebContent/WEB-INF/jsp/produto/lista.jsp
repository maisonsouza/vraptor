<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p001495
  Date: 22/04/2019
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de produtos</title>
</head>
<body>
<table>
<c:forEach var="produto" items="${produtoList}">
    <tr>
        <td>${produto.nome}</td>
        <td>${produto.descricao}</td>
        <td>${produto.preco}</td>
        <td>${produto.cor}</td>
    </tr>

</c:forEach>
</table>
</body>
</html>
