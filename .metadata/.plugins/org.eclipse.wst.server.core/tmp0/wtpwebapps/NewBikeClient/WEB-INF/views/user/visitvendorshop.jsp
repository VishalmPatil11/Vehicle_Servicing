<%@ page language="java" contentType="text/html;application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bike Doctor</title>
<link href="<spring:url value='/bootstrap/css/bootstrap.min.css'/>" type="text/css" rel="stylesheet" />
<script src="<spring:url value='/bootstrap/jquery/jquery.min.js'/>">  </script>
<script src="<spring:url value='/bootstrap/js/bootstrap.min.js'/>">  </script>
</head>

<body>


	<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
      <div class="container">
        <a class="navbar-brand" href="<spring:url value='/user/profile' /> " >Bike Doctor</a>
        <ul class="navbar-nav ml-auto"> 
         <li class="nav-item active">
             <a class="nav-link" href="<spring:url value='/user/profile' /> " > My Profile </a>
            </li>
          </ul>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
      	  <li class="nav-item active">
              <a class="nav-link" href="#">Welcome ${sessionScope.session_user.u_first_name}</a>
            </li>
            <li class="nav-item">
  			<a href="logout" class="btn btn-danger">Logout</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
	
	


<div class="container">
<br>	
	<c:if test="${not empty sessionScope.session_vendor}">
 	<c:forEach var="v" items="${sessionScope.session_vendor}" >
 	  <div align="center"> <h1 class="text-success">  ${v.ven_shop_name}     
 	  </h1>  
 	  
 	  </div>
	</c:forEach>
	</c:if>
<br>

	<div align="center"> ${requestScope.status}</div>
		 <div class="row">
 
 <div class="col-lg-3" > </div>
 <div class="col-lg-6" >
 
	<c:if test="${empty sessionScope.session_vendor}">
	<div class="alert alert-info"><center>	  
	<strong>Information : </strong> Oops!! Requested Page Not Found.
	</div></center>
	</c:if>


<c:if test="${not empty sessionScope.session_vendor}">
 	<c:forEach var="v" items="${sessionScope.session_vendor}" >
	<c:if test="${empty v.ven_services}">
	<div class="alert alert-info"><center>	  
	<strong>Information : </strong> Oops!! No Services Available Today.
	</div></center>
	</c:if>
     
	<c:if test="${not empty v.ven_services}">
	<center>
	<a class="btn btn-info text-white" href="<spring:url value='/user/bookservice?ven_id=${v.ven_id}'/>">Book A Service</a>
	</center>
	<br>
	<div class="table-responsive">
  	<table class="table">
  	<tr> <th class="bg-warning text-white" colspan="2"> <h4><center> Location Of Shop :-  ${v.ven_address} </center> </h4> </th></tr>
  	<tr> <th class="bg-info text-white" colspan="2"> <h4> <center> Available Services </center> </h4> </th></tr>
    <tr><td class="bg-danger text-white"> Services Name </td> <td class="bg-success text-white"> Price </td></tr>     
    <c:forEach var="s" items="${v.ven_services}" >
	<tr><td  class="bg-danger text-white"> ${s.stv_name} </td> <td class="bg-success text-white"> Rs. ${s.stv_price}  </td></tr>
    </c:forEach>
    </table>
	</div>

        </c:if>
        
        
 
     	</c:forEach>
   </c:if>
   </div>
	</div>
		</div>

</body>
</html>