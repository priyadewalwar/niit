<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Add a product</title>
</head>
<body>
 <%@ include file="AdminHome.jsp"%>

<h2>Add a Product</h2>
    <div class="container" ng-app="imgApp" ng-controller="imgCtrl">
    <c:url var="Addproduct" value="Addproduct"></c:url>
   <form:form commandName="Product" method="post" action="storeproduct" enctype="multipart/form-data">
       <table class="table table-bordered" >
          <tr><td><form:label path="Id"> Id :</form:label></td>
               <td><form:input path="Id"/>
               <font color="red"><form:errors path="Id"></form:errors></font></td>
       
           <tr><td><form:label path="Name"> Name :</form:label></td>
               <td><form:input path="Name"/>
               <font color="red"><form:errors path="Name"></form:errors></font></td>
           </tr>
           <tr><td><form:label path="Description"> Description :</form:label></td>
               <td><form:input path="Description"/>
               <font color="red"><form:errors path="Description"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="Price">Price:</form:label></td>
               <td><form:input path="Price"/>
               <font color="red"><form:errors path="Price"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="style"> Style :</form:label></td>
               <td><form:input path="style"/>
               <font color="red"><form:errors path="style"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="warranty">Warranty :</form:label></td>
               <td><form:input path="warranty"/>
               <font color="red"><form:errors path="warranty"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="capacity"> Capacity :</form:label></td>
               <td><form:input path="capacity"/>
               <font color="red"><form:errors path="capacity"></form:errors></font></td>
           </tr> 
                      <tr><td><form:label path="img"> Image:</form:label></td>
               <td><form:input path="img" type="file"/>
               <font color="red"><form:errors path="img"></form:errors></font></td>  
           </tr>
           <tr><td><form:label path="supplier">Supplier Name:</form:label></td>
               <td><select name="supplier.id">
   				 <option value="">---Select---</option>
   				 <c:forEach var="supplier" items="${suppliers}">
   				 <option value="${supplier.id}">${supplier.supname}</option>
    		</c:forEach>
    		</select></td></tr>
             <td><input type="submit" value="Add Product" class="btn-success"/></td>
       </table>
   </form:form> 
   </div>
 	<%@ include file="Footer.jsp"%>
</body>
</html>