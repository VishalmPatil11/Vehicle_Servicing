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
        <ul class="navbar-nav ml-auto"> 
                <li class="nav-item active">
              <a class="nav-link" href="<spring:url value='/vendor/profile' /> " > My Profile </a>
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
         Hello,  ${sessionScope.session_vendor.ven_first_name} 
           <a  href="<spring:url value="/user/login"> </spring:url>" class="alert-link"> </a>
           </div>	
			</div>
	
			<div class="container">		
         <div class="row" >
    
         <div class="col-lg-3" >
			</div>


         <div class="col-lg-9" >		
	<s:form method="post" modelAttribute="offer">

	
 	<div class="form-group">
      <label for="offername">Offer Name</label>
      	<s:input path="ofr_name"  class="form-control" id="offername" placeholder="Enter Offer Name" required="required"/>
    	<s:errors path="ofr_name" />    
    </div>

	<div class="form-group">
      <label for="offerdiscount">Offer Discount Percentage</label>
      	<s:input type="number" path="ofr_discount"  class="form-control" id="offerdiscount" placeholder="Enter Offer Percentage Discount" required="required"/>
    	<s:errors path="ofr_discount" />
    </div>

	<div class="form-group">
      <label for="offervalidity">Offer Validity Date</label>
      	<s:input  type="date" path="ofr_validity"  class="form-control" id="offervalidity" placeholder="Choose The Validity Date" required="required"/>
    	<s:errors path="ofr_validity" />
    </div>

	<div class="form-group">
      <label for="offercode">Offer Code</label>
      	<s:input path="ofr_code"  class="form-control" id="offercode" placeholder="Enter Offer Code" required="required"/>
    	<s:errors path="ofr_code" />
    </div>


<button type="submit" class="btn btn-success btn-block ">Add My Offer</button>
</s:form>
<br>

	</div>
    </div>
    </div>
    
</body>
</html>