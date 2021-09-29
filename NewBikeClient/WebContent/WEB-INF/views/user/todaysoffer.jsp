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
        <a class="navbar-brand" href="<spring:url value="/"> </spring:url>" >Bike Doctor</a>
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
	
			<%--           
			  <li class="nav-item active">
              <a class="nav-link" href="<spring:url value="/user/login"> </spring:url>" > User Login
                <span class="sr-only">(current)</span>
              </a>
            </li>
         	 --%>
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
 <div align="center">

	  <!-- Navbar Search -->
      <form class="d-none d-lg-inline-block form-inline col-md-8" method="get" action="vendorshopssearch">
        <div class="input-group">
          <input type="text" name="search"  required="required" class="form-control" placeholder="Search for Service Centers..." aria-label="Search" aria-describedby="basic-addon2">
          <div class="input-group-append">
            <button type="submit" class="btn btn-warning" type="button">
              <i class="fas fa-search">Get The Shops</i>
            </button>
          </div>
        </div>
          </form>
         <a class="btn btn-primary" href="<spring:url value='/user/vendorshops'/>">See All Shops</a>
</div>
<br>   
      
	
<div align="center">
<c:if test="${empty sessionScope.session_vendor}">
<div class="alert alert-info">
 	<strong>Information : </strong> Oops!! No Service Center Available For Offer.

</div>
</c:if>
</div>
 <div class="row"> 


  	</div>
<c:if test="${not empty sessionScope.session_vendor}">

<div class="row">
 	 <c:forEach var="v" items="${sessionScope.session_vendor}" >

          <c:forEach var="offer" items="${v.ven_offer}" >
  <div class="col-sm-6 mb-3 mb-md-0">
         
         <div class="card">
  <h5 class="card-header h5 ">${v.ven_shop_name} [ ${offer.ofr_discount}% OFF ]</h5>
  <div class="card-body">
    <h5 class="card-title"> OFFER CODE : ${offer.ofr_code}</h5>
    <p class="card-text"> ADDRESS : ${v.ven_address}  </p>
          <a class="btn btn-primary" href="<spring:url value='/user/visitvendorshop?ven_id=${v.ven_id}'/>">Visit Shop >></a>
  </div>
</div>



    
  </div>
          </c:forEach>
      	</c:forEach>

  </div>
</c:if> 		


 	</div>

        

</body>
</html>