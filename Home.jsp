<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
  <title>Shopping Cart</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 60%;
      margin: auto;
  }
  h1{
  color:purple;
  }
  h1{
  text-align:center;
  }
  </style>
</head>

<body>
  <%@ include file="Header.jsp"%>
<div class="container">
  
    <div class="center-block">  
    
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>
 
   <!-- Wrapper for slides -->
    
    
    <div class="carousel-inner" role="listbox">
    
    
    
    
      <div class="item active">
         <img src="<c:url value="/resources/images/1.jpg"/>" alt="Chania" width="1000" height="500">
      </div>

      <div class="item">
        <img src="<c:url value="/resources/images/2.jpg"/>" alt="Chania" width="1000" height="500">
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/images/3.jpg"/>" alt="Chania" width="1000" height="500"> 
      </div>
      
      
       <div class="item">
         <img src="<c:url value="/resources/images/4.jpg"/>" alt="Chania" width="1000" height="500">
      </div>
      
      <div class="item">
         <img src="<c:url value="/resources/images/5.jpg"/>" alt="Chania" width="1000" height="500">
      </div>
      
     
      
             
          <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div></div></div>
  <br/>
 

<div class="container">
            
  <div class="row">
    <div class="col-sm-4">
      <a href="Products">
          
         <img src="<c:url value="/resources/images/1.jpg"/>" alt="Pulpit Rock" style="width:300px;height:150px">
             </div>
    <div class="col-sm-4">
           
         <img src="<c:url value="/resources/images/2.jpg"/>" alt="Moustiers Sainte Marie" style="width:300px;height:150px">
         
    </div>
    <div class="col-sm-4">
      <a href="Products">
         <img src="<c:url value="/resources/images/3.jpg"/>" alt="Cinque Terre" style="width:300px;height:150px">
      </a>
       </div>
    <div class="col-sm-4">
      <a href="Products">
         <img src="<c:url value="/resources/images/4.jpg"/>" alt="Cinque Terre" style="width:300px;height:150px">
      </a>
       </div>
    <div class="col-sm-4">
      <a href="Products">
         <img src="<c:url value="/resources/images/5.jpg"/>" alt="Cinque Terre" style="width:300px;height:150px">
      </a>
    <div class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
  <div class="container"></div>
  <div class="navbar-text pull-left">cameras </div>
</div>
    
  </div>
</div>
</body>
</html>