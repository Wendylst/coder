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
<form method="post" action="../business/updateShop">

<table>
<tr><td rowspan="5" width="80px" valign="middle"><img src="../resources/${cafe.shop_img}" width="80px" 	align="middle"></td><td></td><td></td></tr>
<tr><td>매장명</td><td><input type="text" value="${cafe.shop_name}" name="shop_name"></td></tr>
<tr><td>주소</td><td><input type="text" value="${cafe.shop_address}" name="shop_address" ></td></tr>
<tr><td>영업<br>시간</td><td><input type="text" value="${cafe.operation_hour}" name="operation_hour"></td></tr>
<tr><td>매장<br>전화<br>번호</td><td><input type="text" value="${cafe.shop_phone}" name="shop_phone"></td></tr>
</table>
	<input type="hidden" name="shop_no" value="${cafe.shop_no}">
	    <div class="ui-grid-a">
      <div class="ui-block-a">
        <input type="submit" class="ui-btn ui-corner-all ui-shadow" name="option" value="수정"></div>
      <div class="ui-block-b">
        <input type="submit" class="ui-btn ui-corner-all ui-shadow" name="option" value="삭제"></div>
    </div>
</form>
<div class="ui-grid-b">
     <form method="post" action="../business/updateShop"><input type="hidden" name="shop_no" value="${cafe.shop_no}">
     <input type="submit" class="ui-btn ui-corner-all ui-shadow" value="메뉴관리">
     </form>
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