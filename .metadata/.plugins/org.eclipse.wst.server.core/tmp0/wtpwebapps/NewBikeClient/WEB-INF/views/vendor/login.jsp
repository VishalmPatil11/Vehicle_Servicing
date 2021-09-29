<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style>
body {
    background-image: url("https://images.unsplash.com/photo-1530248809527-ee069dc8373a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
}
.no-background {
    background-image: url("images/blank.jpg");
}
</style>
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
<c:if test="${not empty requestScope.status}">
<div class="alert alert-info">
 <a  href="<spring:url value="/vendor/login"> </spring:url>" class="alert-link"> ${requestScope.status} </a>
 </div>
</c:if>
</div>
			
		<br>
	  
	  


<div class="container">
        <div class="row">
      
       <div  class="col-md-3 col-md-offset-3" >
          <br><br>
		<div class="form-group">
		<a href="<spring:url value="/user/register"> </spring:url>" class="btn btn-warning btn-block "> Sign Up As A User   </a>	
		</div>
		
		<div class="form-group">
		<a href="<spring:url value="/vendor/register"> </spring:url>" class="btn btn-danger btn-block "> Sign Up As A Vendor  </a>	
		</div>
		
		</div>
       <div  class="col-md-5 col-md-offset-5" >
		</div>
        
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="checklogin">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus required="required">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" required="required">
                                </div>
                                   <div class="form-group">
                                            <label>Select Role &nbsp;</label>
                                             <label class="radio-inline">
                                                <input type="radio" name="role" id="vendor" value="vendor" checked required="required">Vendor
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="role" id="user" value="user"  required="required">User
                                            </label>
                                           
                                        </div>
                                
                                <!-- Change this to a button or input when using this as a form -->
                                 <button type="submit" class="btn btn-success btn-block">Login</button>
                                 		
			<!--  <a href="index.html" class="btn btn-lg btn-success btn-block">Login</a>  -->                            
 		
 		
 					</fieldset>
                        </form>
                    </div>
                </div>
            </div> 
         </div>
    </div>

</body>

</html>




	<!-- jQuery 1.9 -->
	<%--Bootstrap JS --%>
	<%-- 	<script src="<spring:url value='/js/jquery.1.9.1.min.js'/>"></script>
	<script src="<spring:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
 --%>
</body>
</html>