<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>View Suppliers</title>
</head>
<body>

      <%@ include file="AdminHome.jsp"%>

<h2>Edit Supplier</h2>
  <form:form commandName="Supplier" method="post" action="updatesupplier">
       <table class="table table-bordered" >
           <tr><td><form:label path="id"> Id:</form:label></td>
               <td><form:input path="id" value="${supplier.id}"/></td>
           </tr>
		  
           <tr><td><form:label path="supid">Supplier Id:</form:label></td>
               <td><form:input path="supid" value="${supplier.supid}"/></td>
           </tr>
           <tr><td><form:label path="supname">Supplier Name :</form:label></td>
               <td><form:input path="supname" value="${supplier.supname}"/></td>
           </tr>           
           <tr><td><form:label path="suplocation">Supplier Location:</form:label></td>
               <td><form:input path="suplocation" value="${supplier.suplocation}"/></td>
           </tr>
                      
                    <td><input type="submit" value="Submit" class="btn-success"/></td>
       </table>
   </form:form>
   <%@ include file="Footer.jsp"%> 
</html>