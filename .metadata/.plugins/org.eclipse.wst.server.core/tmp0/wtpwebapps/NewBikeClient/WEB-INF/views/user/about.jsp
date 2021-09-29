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
    background-image: url("https://wallpapercave.com/wp/wp2432641.jpg");
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
 --%>            
          </ul>
        </div>
      </div>
    </nav>
    
	<h2> <i>Vehicle Servicing Platform</i></h2><br/><br/>
<h3>Vehicle Servicing Platform lets the users to sort among <br>vehicle garages having best offers and price making vehicle<br>servicing hastle free...! </h3><br/>

 <img class="img-fluid rounded mb-3 mb-md-0" src="<spring:url value='/bootstrap/images/Akki.jpeg'/>" alt="${v.ven_shop_name}">
 
          
          <h6><i>Name:- Akshay Shitole</i></h6>
          <h6><i>Email:- shitoleakshay11@gmail.com</i></h6>
           <h6><i>Mobile no:- 8888889490</i></h6>
         <br><br>
         
       <img class="img-fluid rounded mb-3 mb-md-0" src="<spring:url value='/bootstrap/images/ram.jpeg'/>" alt="${v.ven_shop_name}">
 
          <h6><i>Name:- Baliram Pophale</i></h6>
          <h6><i>Email:- pophalebaliram94@gmail.com</i></h6>
           <h6><i>Mobile no:- 8007902804</i></h6>
         <br><br>
         
         <img class="img-fluid rounded mb-3 mb-md-0" src="<spring:url value='/bootstrap/images/Ud.jpeg'/>" alt="${v.ven_shop_name}">
 
          <h6><i>Name:- Uddhav Dabhade</i></h6>
          <h6><i>Email:- uddhavdabhade07@gmail.com</i></h6>
           <h6><i>Mobile no:- 8275325408</i></h6>
         <br><br>  

         <img class="img-fluid rounded mb-3 mb-md-0" src="<spring:url value='/bootstrap/images/VishalP.jpeg'/>" alt="${v.ven_shop_name}">
 
          <h6><i>Name:- Vishal Patil</i></h6>
          <h6><i>Email:- patilvishal1121@gmail.com </i></h6>
           <h6><i>Mobile no:- 9975328188</i></h6>
         <br><br>  
          <img class="img-fluid rounded mb-3 mb-md-0" src="<spring:url value='/bootstrap/images/VishalS.jpeg'/>" alt="${v.ven_shop_name}">
 
          <h6><i>Name:- Vishal  Saste</i></h6>
          <h6><i>Email:- saste.vishal1@gmail.com </i></h6>
           <h6><i>Mobile no:- 9324310760</i></h6>
         <br><br>  
<h2><i></i></h2>
<h2><i>Thank You For visit...!</i></h2>



		

</body>

</html>




	