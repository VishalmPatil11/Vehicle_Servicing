<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
<style>
body {
    background-image: url("https://wallpapercave.com/wp/wp4366488.jpg");
}
.no-background {
    background-image: url("images/blank.jpg");
}
</style>
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
        <ul class="navbar-nav ml-auto">  <li class="nav-item active">
              <a class="nav-link" href="<spring:url value="/"> </spring:url>" > Home </a>
            </li>
          </ul>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
<%--             <li class="nav-item active">
              <a class="nav-link" href="<spring:url value="/user/login"> </spring:url>" > User Login
                <span class="sr-only">(current)</span>
              </a>
            </li>
 --%>            <li class="nav-item">
              <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
	
			<div align="center">

           <div class="alert alert-success">
           ${requestScope.status} 	 
           ${sessionScope.session_vendor.ven_first_name} 
           <a  href="<spring:url value="/user/login"> </spring:url>" class="alert-link"> </a>
           </div>	
			</div>
	
			<div class="container">		
         <div class="row" >
         <div class="col-lg-3" >

		<br/>		
		<div class="form-group">
		<a href="<spring:url value="/user/login"> </spring:url>" class="btn btn-warning btn-block "> User Login  </a>	
		</div>

		<div class="form-group">
		<a href="<spring:url value="/vendor/login"> </spring:url>" class="btn btn-danger btn-block "> Vendor Login  </a>	
		</div>
		
		<div class="form-group">
		<a href="<spring:url value="/vendor/register"> </spring:url>" class="btn btn-danger btn-block "> Sign Up Vendor  </a>	
		</div>
		</div>


         <div class="col-lg-9" >		
	<s:form method="post" modelAttribute="service"> 
    
    <div class="form-group">
      <label for="services">Choose Services For Your Shop</label>
        <c:forEach var="s" items="${masterservices_list}" >
      	<s:checkbox path="s_id" value="${s.s_id}"  class="form-control" id="serviceid"/>${s.s_id} ${s.s_name} ${s.s_price}
        </c:forEach>
    </div>

<button type="submit" class="btn btn-success btn-block ">Submit </button>
</s:form>

<br>

	</div>
    </div>
    </div>
    
</body>
</html>