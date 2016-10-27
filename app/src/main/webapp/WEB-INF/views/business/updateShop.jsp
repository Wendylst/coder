<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div data-role= "header" ><h1>Coder</h1></div> 
<div data-role= "content" >
<!-- 작성시작부분 -->
<form>
<table>
<tr><td rowspan="5" width="100px"><img src="../resources/${cafe.shop_img}"></td><td></td><td></td></tr>
<tr><td>매장명</td><td><input type="text" value="${cafe.shop_name}" name="shop_name"></td></tr>
<tr><td>주소</td><td><input type="text" value="${cafe.shop_address}" name="shop_address" ></td></tr>
<tr><td>영업시간</td><td><input type="text" value="${cafe.operation_hour}" name="operation_hour"></td></tr>
<tr><td>매장<br>전화번호</td><td><input type="text" value="${cafe.shop_phone}" name="shop_phone"></td></tr>
</table> 
</form>
<!-- 종료부분 -->
</div>
<div data-role= "footer" >
</div>
</div>
</body>
</html>
