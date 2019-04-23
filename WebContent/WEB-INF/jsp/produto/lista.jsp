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
    <script src="<c:url value="/js/jquery-1.6.1.min.js"/>"></script>
    <script>
        function remove(id) {
        $.get('remove?produto.id='+id, function () {
            alert('Produto removido com sucesso');
            $('#produto-'+id).remove();
        })
        }
    </script>
</head>
<body>

${mensagem}
<table>
<c:forEach var="produto" items="${produtoList}">
    <tr id="produto-${produto.id}">
        <td>${produto.nome}</td>
        <td>${produto.descricao}</td>
        <td>${produto.preco}</td>
        <td>${produto.cor}</td>
        <td><a href="" onclick="remove(${produto.id});return false;">Remove</a></td>
    </tr>

</c:forEach>
</table>
</body>
</html>
