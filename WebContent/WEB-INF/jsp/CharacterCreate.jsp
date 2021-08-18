<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RPGテスト</title>
</head>
<body>
<h1>RPGテスト</h1>
<form action="/RPG/CharacterCreate" method="post">
名　前　<input type="text" value="のなか"name="name"><br>
体　力　<input type="number" value="70"name="hp"><br>
攻撃力 <input type="number" value="35"name="str"><br>


<input type="submit" value="確認" onClick="alert('登録しました!');">
</form>



</body>
</html>