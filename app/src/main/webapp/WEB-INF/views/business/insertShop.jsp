<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coder : 업체 회원  </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<script>

$(function() {
	$("#pageBack").on("click", function(){
		window.history.back();
	});
});	
</script>

<body>
<div data-role= "page" >
<div data-role= "header" ><h1>Coder : 업체 회원</h1></div> 
<div data-role= "content" >
<!-- 작성시작부분 -->
─ 매장 등록 ─<br><br>
<form method="post" action="../insertShopInfo" >
<table  class="tr1">
	<tr><td>업체명</td><td><input type="text" value ="<%=session.getAttribute("business_name")%>" disabled="disabled"></td></tr>
	<tr><td>담당자이름</td><td><input type="text" value ="<%=session.getAttribute("manager_name")%>" disabled="disabled"></td></tr>
	<tr><td>매장명</td><td><input type="text" name ="shop_name"></td></tr>
	<tr><td>매장주소</td><td><input type="text" name ="shop_address"></td></tr>
	<tr><td>영업시간</td><td><input type="text" name ="operation_hour"></td></tr>
	<tr><td>매장전화</td><td><input type="text" name ="shop_phone"></td></tr>
	<tr><td>매장소개</td><td><input type="text" name ="title"></td></tr>
</table>
<input type="submit" name ="register" value="등록">
</form>
<!-- <form method="get" action="main"><input type="submit" value="취소"></form> -->
<!-- 종료부분 -->
</div>
<div data-role= "footer" >
</div>
</div>
</body>
</html>