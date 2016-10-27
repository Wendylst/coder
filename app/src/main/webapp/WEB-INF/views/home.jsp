<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<meta charset="UTF-8">
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello! This is a practice project.  
</h1>
<a href="login">click</a>
<c:forEach var="cafe" items="${shop}" varStatus="status">
<table>
<tr><td rowspan="5" width="100px">ㅋㅋㅋㅋㅋ${cafe.shop_img}</td><td></td><td></td><td rowspan="5">gg</td></tr>
<tr><td>매장명</td><td>${cafe.shop_name}1</td></tr>
<tr><td>주소</td><td>${cafe.shop_address}1</td></tr>
<tr><td>영업시간</td><td>${cafe.OPERATION_HOUR}1</td></tr>
<tr><td>매장전화번호</td><td>${cafe.shop_phone}1</td></tr>
</table>
</c:forEach>
</body>	
</html>
