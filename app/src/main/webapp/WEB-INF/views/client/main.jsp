<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div data-role= "header" ><h1>Coder : 회원</h1></div> 
<div data-role= "content" >
<!-- 작성시작부분 -->
<h2>Coffee Shops:</h2>

<img src="resources/img/angelinus.JPG">
    <ul data-role="listview" inset="true"> 
      <li><a href="#"><img src="resources/img/angelinus.JPG" ><h1>Angelinus</h1></a></li>
      <li ><a href="#">data-icon="plus"</a></li>
      <li><a href="#">data-icon="minus"</a></li>
      <li><a href="#">data-icon="delete"</a></li>
      <li><a href="#">data-icon="location"</a></li>
      <li><a href="#">data-icon="false"</a></li>
    </ul>


<!-- 종료부분 -->
</div>
<div data-role= "footer" >
</div>
</div>
</body>
</html>