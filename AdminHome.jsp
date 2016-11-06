
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
    </div>
        
    <div class="navbar-collapse collapse"></div>
    <ul class="nav navbar-nav navbar-right">
   
     
     
      <li class="active"><a href="Home">Home</a></li>
      <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
             
    </ul>
  </div>
</nav>
	

<div style=text-align:center>
  <a href="Managesupplier" class="btn btn-primary"> Manage Suppliers</a>
  <a href="Manageproduct" class="btn btn-primary">Manage Products</a>
  <a href="Manageuser" class="btn btn-primary">Manage Users</a>
</div>
 	
 
  