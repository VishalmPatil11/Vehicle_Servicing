<%@ page language="java" contentType="text/html;application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html>
<html>
<style>
body {
    background-image: url("https://wallpapercave.com/wp/wp4366488.jpg");
}
.no-background {
    background-image: url("images/blank.jpg");
}
</style>
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
      </div>

	 <br>

	<div align="center"> ${requestScope.status}</div>

 <div class="row">
	
  
  <div  class="col-md-8" >
       
		
<h4> 
User Name : ${sessionScope.session_user.u_first_name} ${sessionScope.session_user.u_last_name} <br>
Email ID : ${sessionScope.session_user.u_email} <br>
Mobile Number : ${sessionScope.session_user.u_mobile} <br> 
Address : ${sessionScope.session_user.u_address} <br>
</h4>		


	
 	

	<c:if test="${empty sessionScope.session_user.u_vehicles}">
	<div class="alert alert-info">
<center>	  <strong>Information : </strong> You Have Not Registered Any Bike Yet...
	</div></center>
</c:if>

<c:if test="${not empty sessionScope.session_user.u_vehicles}">

                    <div class="panel panel-default">
                        <div class="panel-heading">
             	       <h3 class="text success"> My Bikes</h3>   
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                      
                                  	  <tr>
                                  	        <th>#</th>
                                            <th>Company Name</th>
                                            <th>Bike Model </th>
                                            <th>Registration Number</th>
                                        </tr>
                                    
                                    </thead>
                                    <tbody>
                                    	<c:forEach var="v" items="${sessionScope.session_user.u_vehicles}" > 
                	                        <tr class="success">
                    	                        <td>${j=j+1}</td>
                        	                    <td>${v.v_company_name}</td>
                            	                <td>${v.v_model}</td>
                                	            <td>${v.v_regNo}</td> 
                                	            <td><a class="btn btn-danger btn-block " href="<spring:url value='/user/deletevehicle?v_id=${v.v_id}'/>">Delete</a><td>                             
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


		<%-- for each for date and other format		
			<td><fmt:formatDate value="${v.v_Id}" pattern="dd-MM-yyyy" /></td>
			<td><a href="<spring:url value='/vendor/update?vid=${v.v_id}'/>">Update</a></td>
			<td><a href="<spring:url value='/vendor/delete/${v.v_id}'/>">Delete</a></td>
			<td><a href="<spring:url value='/vendor/add_part?vid=${v.v_id}'/>">Add
					Part</a></td>
			<td><a href="<spring:url value='/vendor/details/${v.v_id}'/>">Details</a></td>
			<td><a href="<spring:url value='/company/list?id=${v.v_id}'/>">Company-Vendor Management</a></td>
	 	 --%>			
 
	

</div>
	
    
  <div class="col-md-4" align="right">
       
              <div class="card text-white bg-primary o-hidden h-40">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-comments"></i>
                  </div>
                  <div class="mr-5">You Can Add Your Vehicle Any Time!</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="registerVehicle">
                  <span class="float-left">>> Click Here To New Vehicle</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right"></i>
                  </span>
                </a>
             </div>
      		<br>
              <div class="card text-white bg-danger o-hidden h-40">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-life-ring"></i>
                  </div>
                  <div class="mr-5">Choose Your Favorite Service Center.<br> Book Your Service !!</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="<spring:url value='/user/vendorshops'/>">
                  <span class="float-left">>> Click To See The Service Centers</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right"></i>
                  </span>
                </a>
              </div>    
              
			<br>
              
              <div class="card text-white bg-success o-hidden h-40">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-shopping-cart"></i>
                  </div>
                  <div class="mr-5">Today's Offers By Service Centers</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="<spring:url value='/user/todaysoffer'/>">
                  <span class="float-left">>> Click To See The Offers</span>
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