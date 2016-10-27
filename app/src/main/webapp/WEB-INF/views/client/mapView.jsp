<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Geolocation</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>

      #map {
        height: 70%;
      }
    </style>
<link rel="stylesheet" type="text/css" href="resources/css/modal.css">
  </head>
  <body>
  <h2>Animated Modal with Header and Footer</h2>

<!-- Trigger/Open The Modal -->
<button onclick="goMap()">Open Modal</button>
<!-- <div id="map"></div> -->
<!-- The Modal -->

<div id="myModal" class="modal">
   <div class="modal-header"> 
      <span class="close">×</span>
       <h2>Modal Header</h2>
    </div>
       <div id="map"></div>  
    <div class="modal-footer">
      <h3>Modal Footer</h3>
    </div>
</div>

	<script src="resources/js/modal.js"></script>
    <script src="resources/js/mapView.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCvT93KU6iH_E4lFXn3acnluHQK4x0k4uI"></script>
  </body>
</html>