<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coder : </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<div data-role= "page" >



<div data-role= "header" ><h1>Coder : 업체용</h1></div> 
<div data-role= "content" >
<!-- 작성시작부분 -->
<c:forEach var="cafe" items="${shop}" varStatus="status">
<table>
<tr><td rowspan="5" width="100px"><img src="../resources/${cafe.shop_img}"></td><td></td><td></td></tr>
<tr><td>매장명</td><td>${cafe.shop_name}</td></tr>
<tr><td>주소</td><td>${cafe.shop_address}</td></tr>
<tr><td>영업시간</td><td>${cafe.operation_hour}</td></tr>
<tr><td>매장<br>전화번호</td><td>${cafe.shop_phone}</td></tr>
</table>
<div class="ui-grid-b">
      <div><form method="post" action="business/updateShop"><input type="submit" class="ui-btn ui-corner-all ui-shadow" value="메뉴관리">
      <input type="hidden" value="${cafe.shop_no}"></form></div>
      <div><form method="post" action="business/updateShop"><input type="submit" class="ui-btn ui-corner-all ui-shadow" value="매장정보 수정/삭제">
      <input type="hidden" value="${cafe.shop_no}"></form></div>
   
    </div>
<hr>
</c:forEach>
<!-- 종료부분 -->
</div>
<form action="business/main" method="post"><input type="submit" value="이전화면"></form>
<div data-role= "footer" >
</div>
</div>
</body>
</html>