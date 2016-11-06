<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta Name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Edit Users</title>
</head>
<body>
 <%@ include file="AdminHome.jsp"%>
<h2>Edit User</h2>
<form:form commandName="User" method="post" action="updateuser">
       <table class="table table-bordered" >

		   <tr><td><form:label path="id">User Id:</form:label></td>
               <td><form:input path="id" value="${user.id}"/></td>
            </tr>             
           <tr><td><form:label path="username">User Name :</form:label></td>
               <td><form:input path="username" value="${user.username}"/></td>
           </tr>
           <tr><td><form:label path="password">User password :</form:label></td>
               <td><form:input path="password" value="${user.password}"/></td>
           </tr>           
           <tr><td><form:label path="role">User Role :</form:label></td>
               <td><form:input path="role" value="${user.role}"/></td>
           </tr>
           <tr><td><form:label path="status">User Status :</form:label></td>
               <td><form:input path="status" value="${user.status}"/></td>
           </tr>           
              <tr> <td><input type="submit" value="Submit" class="btn-success"/></td>
           </tr>
           
              </table>        
  </form:form>   
  <%@ include file="Footer.jsp"%>
  
</body>
</html>
