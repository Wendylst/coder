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
<link rel="stylesheet" type="text/css" href="css/modal.css">

</head>
<body>
<div data-role= "page" >
<div data-role= "header" ><h1>Coder : 회원</h1></div> 
<div data-role= "content" >
<!-- 작성시작부분 -->
<h2>Coffee Shops</h2>

    <ul data-role="listview" inset="true"> 
      <li><a href="aroundMe"><img src="resources/img/aroundMe.JPG" >Around me</a></li>
      <li><a href="#"><img src="resources/img/angelinus.JPG" ><h1>Angelinus</h1></a></li>
      <li><a href="#"><img src="resources/img/caffebene.JPG" ><h1>Caffebene</h1></a></li>
      <li><a href="#"><img src="resources/img/coffeeBean.JPG" ><h1>Coffe Bean</h1></a></li>
      <li><a href="#"><img src="resources/img/pascucci.JPG" ><h1>Passcucci</h1></a></li>
      <li><a href="#"><img src="resources/img/starBucks.JPG" ><h1>Star Bucks</h1></a></li>
      <li><a href="#"><img src="resources/img/tomNtoms.JPG" ><h1>Tom N Toms</h1></a></li>
    </ul>
    
    <button id="myBtn">Open Modal</button>
    
<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">×</span>
      <h2>Modal Header</h2>
    </div>
    <div class="modal-body">
      <p>Some text in the Modal Body</p>
      <p>Some other text...</p>
    </div>
    <div class="modal-footer">
      <h3>Modal Footer</h3>
    </div>
  </div>

</div>

<script src="js/modal.js"></script>
<!-- 종료부분 -->
</div>
<div data-role= "footer" >
</div>
</div>
</body>
</html>