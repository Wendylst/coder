<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coder : 업체용</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>


<body>
	<div data-role="page">
		<div data-role="header">
			<h1>Coder : 업체용</h1>
		</div>
		<div data-role="content">
			<!-- 작성시작부분 -->
			─업체 정보 수정─<br>
			<br>
			<form method="post" action="../bs_updateInfo">
				<table class="tr1">
					<tr>
						<td>대표이메일</td>
						<td><input type="text" name="bs_email" value="${user.bs_email}" disabled="disabled"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="text" name="bs_password"  value="${user.bs_password}"></td>
					</tr>
					<tr>
						<td>비밀번호확인</td>
						<td><input type="text" name="bs_password_chk"></td>
					</tr>
				</table>
				<table class="tr1">
					<tr>
						<td>업체명</td>
						<td><input type="text" name="business_name"  value="${user.business_name}"></td>
					</tr>
					<tr>
						<td>대표전화</td>
						<td><input type="text" name="business_phone" value="${user.business_phone}" ></td>
					</tr>
					<tr>
						<td>대표자명</td>
						<td><input type="text" name="representative" value="${user.representative}"></td>
					</tr>
					<tr>
						<td>사업자등록번호</td>
						<td><input type="number" name="cr_no" value="${user.cr_no}"></td>
					</tr>
					<tr>
						<td>담당자이름</td>
						<td><input type="text" name="manager_name" value="${user.manager_name}"></td>
					</tr>
					<tr>
						<td>담당자전화번호</td>
						<td><input type="text" name="manager_phone" value="${user.manager_phone}"></td>
					</tr>
					<tr>
						<td>담당자이메일</td>
						<td><input type="email" name="manager_email" value="${user.manager_email}">	<input type="hidden" value="${user.bs_no}"></td>
					</tr>
				</table>
				<input type="submit" value="수정">
				</form>
			<!-- </form><form method="get" action="main"><input type="submit" value="취소"></form> -->
		
			<!-- 종료부분 -->
		</div>
		<a href="localhost:9999/testsol/login"><button>홈</button></a>
		<div data-role="footer"></div>
	</div>
</body>
</html>