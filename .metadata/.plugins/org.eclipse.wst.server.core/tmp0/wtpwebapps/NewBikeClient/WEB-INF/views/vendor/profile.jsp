<%@ page language="java" contentType="text/html;application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
        <a class="navbar-brand" href="<spring:url value='/vendor/profile' /> " >Bike Doctor</a>
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
	
	 
			          
	 		  <li class="nav-item active">
              <a class="nav-link" href="<spring:url value="/vendor/showservices"> </spring:url>" > Add Services </a>
 	          </li>
         	
         	  <li class="nav-item active">
              <a class="nav-link" href="#">Welcome ${sessionScope.session_vendor.ven_first_name}</a>
            </li>

            <li class="nav-item">
  			<a href="logout" class="btn btn-danger">Logout</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
	
	


<div class="container">
<br> <br>
	<div align="center"> ${requestScope.status}</div>

 <div class="row">
	
  
  <div  class="col-md-8" >
       
		
<h4> 
User Name : ${sessionScope.session_vendor.ven_first_name} ${sessionScope.session_vendor.ven_last_name} <br>
Email ID : ${sessionScope.session_vendor.ven_email} <br>
Mobile Number : ${sessionScope.session_vendor.ven_mobile} <br> 
Address : ${sessionScope.session_vendor.ven_address} <br>
</h4>		


	<c:if test="${empty sessionScope.session_vendor.ven_offer}">
	<div class="alert alert-info">
<center>	  <strong>Information : </strong> No Offers For Your Shop.
	</div></center>
</c:if>

<c:if test="${not empty sessionScope.session_vendor.ven_offer}">

                    <div class="panel panel-default">
                        <div class="panel-heading">
             	       <h3 class="text success"> My Offers </h3>   
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                  	  <tr>
                                  	        <th>#</th>
                                            <th>Offer Name</th>
                                            <th>Offer Code </th>
                                            <th>Offer Validity</th>
                                        </tr>
                                    
                                    </thead>
                                    <tbody>
                                    	<c:forEach var="v" items="${sessionScope.session_vendor.ven_offer}" > 
                	                        <tr class="success">
                    	                        <td>${j=j+1}</td>
                        	                    <td>${v.ofr_name}</td>
                            	                <td>${v.ofr_code}</td>
                            	                
                            	                <td>
                            	           <fmt:formatDate type = "both" value = "${v.ofr_validity}" />                              	                                           	                
                            	                </td>
                                	            <td><a class="btn btn-danger btn-block " href="<spring:url value='/vendor/deleteoffer?ofr_id=${v.ofr_id}'/>">Delete</a><td>                             
            	                            </tr>
        	                             </c:forEach>
                                     </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
          
 	
</c:if>


<c:if test="${empty sessionScope.session_vendor.ven_mechanic}">
	<div class="alert alert-info">
<center>	  <strong>Information : </strong> No Mechanic For Your Shop.
	</div></center>
</c:if>


<c:if test="${not empty sessionScope.session_vendor.ven_mechanic}">

                    <div class="panel panel-default">
                        <div class="panel-heading">
             	       <h3 class="text success"> My Mechanics </h3>   
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                  	  <tr>
                                  	        <th>#</th>
                                            <th>Mechanic's Name</th>
                                            <th>Mobile Number </th>
                                        </tr>
                                    
                                    </thead>
                                    <tbody>
                                    	<c:forEach var="v" items="${sessionScope.session_vendor.ven_mechanic}" > 
                	                        <tr class="success">
                    	                        <td>${i=i+1}</td>
                        	                    <td>${v.mech_first_name} ${v.mech_last_name}</td>
                            	                <td>${v.mech_mobile}</td>
                                	            <td><a class="btn btn-danger btn-block " href="<spring:url value='/vendor/deletemechanic?mech_id=${v.mech_id}'/>">Delete</a><td>                             
            	                            </tr>
        	                             </c:forEach>
                                     </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
          
</c:if>



	
	
</div>
	
    
  <div class="col-md-4" align="right">
       
              <div class="card text-white bg-primary o-hidden h-40">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-comments"></i>
                  </div>
                  <div class="mr-5">You Can Now Create New Offer Everyday, Hurray !!</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="addoffer">
                  <span class="float-left">>> Click Here To Create New Offer !!</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right"></i>
                  </span>
                </a>
             </div>
      		<br>
             
              
			<br>
              
              <div class="card text-white bg-success o-hidden h-40">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-shopping-cart"></i>
                  </div>
                  <div class="mr-5">You Can Now Add New Mechanic To Service Center !!</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="<spring:url value='/vendor/addmechanic'/>">
                  <span class="float-left">>> Click To Add New Mechanic !!</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right"></i>
                  </span>
                </a>
              </div>
                   
       
    </div>
 	</div>
 	</div>

</body>
</html>