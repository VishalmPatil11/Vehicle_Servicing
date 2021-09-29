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
    background-image: url("https://www.idfreshfood.com/ae-en/wp-content/uploads/2017/09/contact_us_2.jpg");
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
    
	<h2 font color="cyan"> <i>Contact Numbers For More Queries Regarding Services</i></h2><br/><br/>
<h3>Ramkrushna Motors :-  8007902804 </h3><br/>
<h3>Rayat Motors :-  9225306070 </h3><br/>
<h3>Shitole Motors :-  8888889490 </h3><br/>
<h3>Dabhade Motors :-  9595952940 </h3><br/>
  
<h2><i>Thank You For visit...!</i></h2>


		

</body>

</html>




	