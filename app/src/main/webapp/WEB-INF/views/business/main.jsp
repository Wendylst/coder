<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coder : 업체용</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

</head>
<body>
<div data-role= "page"  data-theme="a">
<%=session.getAttribute("business_name")%> / <%=session.getAttribute("manager_name")%> 님 안녕하세요.

<div data-role= "header" ><h1>Coder : 업체용</h1></div> 

<div data-role= "content" > <!-- BS_NO 세션처리하기  -->
<form method="post" action="business/insertShop"><input type="submit" value="매장등록"></form>
<form method="post" action="business/shopUpdate"><input type="submit" value="매장정보수정"><input type="hidden" name="bs_no" value="${user.bs_no}"></form>
<form method="post" action="business/bs_update"><input type="submit" value="업체정보수정"><input type="hidden" name="bs_no" value="${user.bs_no}"></form>
<a href="http://localhost:9999/testsol/login"><button>홈</button></a>
</div>
<div data-role= "footer" ><h2>Copyright ⓒToBeNull Corp. All Rights Reserved.</h2></div>
</div>
</body>
</html>