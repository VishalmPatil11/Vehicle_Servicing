<%@ page language="java"
	contentType="text/html;application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
<link href="<spring:url value='/bootstrap/css/bootstrap.min.css'/>"
	type="text/css" rel="stylesheet" />
<script src="<spring:url value='/bootstrap/jquery/jquery.min.js'/>">  </script>
<script src="<spring:url value='/bootstrap/js/bootstrap.min.js'/>">  </script>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
		<div class="container">
			<a class="navbar-brand"
				href="<spring:url value='/vendor/profile' /> ">Bike Doctor</a>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="<spring:url value='/vendor/profile' /> "> My Profile </a></li>
			</ul>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">



					<li class="nav-item active"><a class="nav-link"
						href="<spring:url value="/vendor/showservices"> </spring:url>">
							Add Services </a></li>

					<li class="nav-item active"><a class="nav-link" href="#">Welcome
							${sessionScope.session_vendor.ven_first_name}</a></li>

					<li class="nav-item"><a href="logout" class="btn btn-danger">Logout</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<br>

	<div class="container">
		<div class="row">





<%-- 			<div class="form-group">
					<h2>Choose Services For Your Shop</h2>
					<br>
 

	     <c:if test="${not empty sessionScope.masterservices_list}">
   
    <div class="table-responsive">
<table class="table table-hover table-bordered">

 <tr><td> Service Name </td><td>Price</td><td>Select Service</td> </tr>     
 <c:forEach var="s" items="${sessionScope.masterservices_list}" >       

 <tr>
 <s:form method="post" modelAttribute="service_taken_vendor">
 <s:hidden path="stv_name" class="form-control" value="${s.s_name}" id="mstservicename" />
 <s:hidden path="stv_price" class="form-control" value="${s.s_price}" id="mstserviceprice" />
 <td> ${s.s_name}  </td>
 <td> ${s.s_price} </td>
 <td> <button type="submit" class="btn btn-warning btn-block ">Add It</button> </td>  

 </s:form>
 </tr> 
 </c:forEach>
 </table> 
 </div>

 </c:if>
  --%>



<%-- 	<c:if test="${not empty sessionScope.masterservices_list}">


  <s:form method="post" modelAttribute="service_taken_vendor">
 <table>
 <c:forEach items="${sessionScope.masterservices_list}" var="s">
            <tr>
            <td>${s.s_name}</td>
            <td>
            
<s:checkbox path="stv_vendor" value="${sessionScope.session_vendor}" />
<s:hidden path="stv_name" class="form-control" value="${s.s_name}" id="mstservicename" /> 
<s:hidden path="stv_price" class="form-control" value="${s.s_price}" id="mstserviceprice" />
            </td>
            </tr>
  </c:forEach>
        

<button type="submit" class="btn btn-success btn-block ">Submit </button>
</table>
</s:form>
 --%>


<%-- <s:form method="post" modelAttribute="service_taken_vendor">
 <table>
 
 <c:forEach items="${sessionScope.masterservices_list}" var="s">
            <tr>
            <td>
<s:input path="stv_name" class="form-control" value="${s.s_name}" id="mstserviceprice" />
</td>

<td> <s:input path="stv_price" class="form-control" value="${s.s_price}" id="mstserviceprice" />
   
   </td>
<td><button type="submit" class="btn btn-success btn-block ">Submit </button>
 </td>
            </tr>
  </c:forEach>
  
  </table>
</s:form> </s:if>
 --%>


	<c:if test="${not empty sessionScope.masterservices_list}">
			<div class="form-group">
					<h2>Choose Services For Your Shop</h2>
					<br>
   <div class="col-lg-9" >		
	<s:form method="post" modelAttribute="service_taken_vendor">
 	<div class="form-group">
      <label for="servicename">Service Name</label>
      	<s:input path="stv_name"  class="form-control" id="servicename" placeholder="Enter Service Name" required="required"/>
    	<s:errors path="stv_name" />    
    </div>

 	<div class="form-group">
      <label for="serviceprice">Service Price</label>
      	<s:input type="number" path="stv_price"  class="form-control" id="serviceprice" placeholder="Enter Service Price" required="required"/>
    	<s:errors path="stv_price" />    
    </div>


<button type="submit" class="btn btn-success btn-block ">Submit Service</button>
</s:form>
<br>

	</div>

	</c:if>


	</div>

	<c:if test="${empty sessionScope.masterservices_list}">
				
	 <div class="col-lg-9" >		
	<s:form method="post" modelAttribute="service_taken_vendor">
	
 	<div class="form-group">
      <label for="servicename">Service Name</label>
      	<s:input path="stv_name"  class="form-control" id="servicename" placeholder="Enter Service Name" required="required"/>
    	<s:errors path="stv_name" />    
    </div>

 	<div class="form-group">
      <label for="serviceprice">Service Price</label>
      	<s:input type="number" path="stv_price"  class="form-control" id="serviceprice" placeholder="Enter Service Price" required="required"/>
    	<s:errors path="stv_price" />    
    </div>


<button type="submit" class="btn btn-success btn-block ">Submit Service</button>
</s:form>
<br>

	</div>
	
	
					<div class="alert alert-info">
						<center>
							<strong>Information : </strong> No Services Available. Please Add The Services For Your Shop.
					</div>
					</center>
				</c:if>
			

	 

	 	</div>
		
</body>
</html>