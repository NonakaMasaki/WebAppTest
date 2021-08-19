<%@ page language="java" contentType="text/html; charset=UTF-8"
   	 pageEncoding="UTF-8"%>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="model.Character,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キャラクター</title>
</head>
<body>
<table class="center" border="1">
<tr><th>ID</th><th>名前</th><th>体力</th><th>攻撃力</th></tr>
<c:forEach var="Character" items="${CharacterList}">

<tr>
	<td class="order"><c:out value="${Character.id}"/></td>
	<td class="order"><c:out value="${Character.name}"/></td>
 	<td class="order"><c:out value="${Character.hp}"/></td>
 	<td class="order"><c:out value="${Character.str}"/></td>
 			<td class="order"><form action="/RPG/CharacterList" method="post">
				<input  name="id" type="hidden" value="${Character.id}">
				<input type="submit" value="削除" onClick="alert('削除しました!');"/>
			</form></td>
</tr>
</c:forEach></table><br>

<a href="/RPG">トップへ</a>
<br>
<a href="/RPG/CharacterCreate">作成</a>
</body>
</html>