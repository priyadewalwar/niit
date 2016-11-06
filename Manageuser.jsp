<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Manage Users</title>
</head>
<body>
 <%@ include file="AdminHome.jsp"%>
<h2>Manage Users</h2>
    <div class="container">
        
<div ng-app="myApp" ng-controller="customersCtrl">
<input type="text" class="form-control" ng-model="searchBy.Name"/>
<table class="table table-striped table-hover">
  <tr>
       <th> Id</th>
       <th> Name</th>
       <th> Password</th>
       <th> Role</th>
       <th> Status</th>
       <th> Action</th>
  </tr>
  <tr ng-repeat="y in names | filter:searchBy">
    <td>{{y.id}}</td>
    <td>{{y.name}}</td>
    <td>{{y.password}}</td>
    <td>{{y.role}}</td>
    <td>{{y.status}}</td>
    <td>
    <a href="${pageContext.servletContext.contextPath}/Viewuser?id={{y.id}}" class="btn btn-info"><span>View</span></a>
    <a href="${pageContext.servletContext.contextPath}/Edituser?id={{y.id}}" class="btn btn-primary"><span>Edit</span></a>
    <a href="${pageContext.servletContext.contextPath}/deleteuser?id={{y.id}}" class="btn btn-danger"><span>Delete</span></a>
   
   </td>  
  </tr>
</table>
</div>

<script>
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("listusers")
    .then(function (response) {$scope.names = response.data;});
});
</script>
</div>
<%@ include file="Footer.jsp"%>
</body>
</html>



