<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coder : Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script>
	$(function(){
		$("#regist1").on("click", function(){
			location.href="client/register";
		})
		$("#regist2").on("click", function(){
			location.href="business/register";
		})
	});
	
</script>
</head>
<body>
<div data-role= "page"  data-theme="a">
<div data-role= "header" ><h1>Coder</h1></div> 
<div data-role= "content" >
<form method="post" action="loginChk">
<table>
<tr><td size="20%">EMAIL</td><td><input type="text" name ="email" size="30%"></td></tr>
<tr><td>비밀번호</td><td><input type="password" name ="pass" size="30%"></td></tr>
<tr><td></td><td><input type="submit" value="로그인"></td></tr>
</table>
</form>
<br><br><br><br><br>
<button id="regist1">회원 가입(개인)</button><button id="regist2">회원 가입(업체)</button>
</div>
<div data-role= "footer" ><h2>Copyright ⓒToBeNull Corp. All Rights Reserved.</h2></div>
</div>
</body>
</html>