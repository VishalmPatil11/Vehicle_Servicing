<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bike Doctor - Vendor</title>
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

           <div class="alert alert-info">
           ${requestScope.status} <a  href="<spring:url value="/vendor/login"> </spring:url>" class="alert-link"> </a>
           </div>	
			</div>
	
			<div class="container">		
         <div class="row" >


		<div class="form-group">
		<a href="<spring:url value="/user/register"> </spring:url>" class="btn btn-danger btn-block "> Sign Up User  </a>	
		</div>

         <div class="col-lg-12" >		
	<s:form method="post" modelAttribute="vendor">


	<div class="form-group">
      <label for="shop">Shop Name</label>
      	<s:input path="ven_shop_name"  class="form-control" id="shop" placeholder="Enter Shop Name" required="required"/>
    	<s:errors path="ven_shop_name" />
    </div>
    

 	<div class="form-group">
      <label for="firstname">First Name</label>
      	<s:input path="ven_first_name"  class="form-control" id="firstname" placeholder="Enter First Name" required="required"/>
    	<s:errors path="ven_first_name" />    
    </div>

	<div class="form-group">
      <label for="lastname">Last Name</label>
      	<s:input path="ven_last_name"  class="form-control" id="lastname" placeholder="Enter Last Name" required="required"/>
    	<s:errors path="ven_last_name" />
    </div>

	<div class="form-group">
      <label for="email">Enter Email ID</label>
      	<s:input path="ven_email"  class="form-control" id="email" placeholder="Enter Email ID" required="required"/>
    	<s:errors path="ven_email" />
    </div>

	<div class="form-group">
      <label for="mobile">Enter Mobile Number</label>
      	<s:input path="ven_mobile"  class="form-control" id="mobile" placeholder="Enter Mobile Number" required="required"/>
    	<s:errors path="ven_mobile" />
    </div>

	<div class="form-group">
      <label for="address">Enter Address</label>
      	<s:input path="ven_address"  class="form-control" id="address" placeholder="Enter Address" required="required"/>
    	<s:errors path="ven_address" />
    </div>

	<div class="form-group">
      <label for="proof">Enter Aadhar Number</label>
      	<s:input path="ven_proof"  class="form-control" id="proof" placeholder="Enter Identity Proof" required="required"/>
    	<s:errors path="ven_proof" />
    </div>



	<div class="form-group">
      <label for="password">Enter Password</label>
      	<s:password path="ven_password"  class="form-control" id="password" placeholder="Enter Secure Password" required="required"/>
    	<s:errors path="ven_password" />
    </div>

<button type="submit" class="btn btn-success btn-block ">Register Me</button>
</s:form>
<br>

	</div>
    </div>
    </div>
    </div>
</body>
</html>