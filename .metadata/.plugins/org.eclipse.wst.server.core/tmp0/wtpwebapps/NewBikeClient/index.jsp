<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bike Doctor</title>
<link href="bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery.min.js">  </script>
<script src="bootstrap/js/bootstrap.min.js">  </script>
</head>

<body>

    <!-- Page Content -->
    <div class="container">

<!--  	<img alt="imgname" src="bootstrap/images/myimg.jpg"/>   -->
   <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Vehicle Servicing Platform</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="vendor/register">Register Vendor
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item  active">
              <a class="nav-link" href="user/register">Register User</a>
            </li>
            
            <li class="nav-item  active">
              <a class="nav-link" href="vendor/contact">Contact</a>
            </li>
             <li class="nav-item  active">
              <a class="nav-link" href="user/about">About</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>


      <!-- Jumbotron Header -->
      <header class="jumbotron my-4">
        <h1 class="display-3">Vehicle Servicing Platform</h1>
        <p class="lead"></p>
        <a href="login.jsp" class="btn btn-success btn-lg">Sign In</a>
      </header>
      
      
<h3>${requestScope.status}</h3>
<br><br><br><br><br><br><br>
  <!--     Page Features
      <div class="row text-center">

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card">
            <img class="card-img-top" src="http://placehold.it/500x325" alt="">
            <div class="card-body">
              <h4 class="card-title">Card title</h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Find Out More!</a>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card">
            <img class="card-img-top" src="http://placehold.it/500x325" alt="">
            <div class="card-body">
              <h4 class="card-title">Card title</h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo magni sapiente, tempore debitis beatae culpa natus architecto.</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Find Out More!</a>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card">
            <img class="card-img-top" src="http://placehold.it/500x325" alt="">
            <div class="card-body">
              <h4 class="card-title">Card title</h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Find Out More!</a>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card">
            <img class="card-img-top" src="http://placehold.it/500x325" alt="">
            <div class="card-body">
              <h4 class="card-title">Card title</h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo magni sapiente, tempore debitis beatae culpa natus architecto.</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Find Out More!</a>
            </div>
          </div>
        </div>

      </div>
      /.row -->

    </div>
    <!-- /.container -->

   


	



</body>
</html>