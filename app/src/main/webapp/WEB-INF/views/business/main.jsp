<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coder : 매장등록</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script>

</script>
</head>
<body>
<div data-role= "page"  data-theme="a">
${user.business_name} / 
${user.manager_name}님 안녕하세요.

<div data-role= "header" ><h1>Coder : 매장등록</h1></div> 
<div data-role= "content" >

			<form method="post" action="insertShop"><input type="submit" value="매장등록">
			<input type="hidden" name ="business_name" value="${user.business_name}">
			<input type="hidden" name ="manager_name" value="${user.manager_name}">
			</form>
			
</div>
<div data-role= "footer" ><h2>Copyright ⓒToBeNull Corp. All Rights Reserved.</h2></div>
</div>
</body>
</html>