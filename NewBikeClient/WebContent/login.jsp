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
<title>Bike Doctor - Login</title>
<link href="bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery.min.js">  </script>
<script src="bootstrap/js/bootstrap.min.js">  </script>

</head>
<body>

    <!-- Page Content -->
    <div class="container">
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="index.jsp">Bike Doctor</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="user/about">About</a>
            </li>
            
            <li class="nav-item">
              <a class="nav-link" href="vendor/contact">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

</div>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

<div class="container">
        <div class="row">
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
                                            <label>Select Role</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="role" id="user" value="user" checked required="required">User
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="role" id="vendor" value="vendor" required="required">Vendor
                                            </label>
                                        </div>
                                
                                <!-- Change this to a button or input when using this as a form -->
                                 <button type="submit" class="btn btn-success btn-block">Login</button>
<!--                                 <a href="index.html" class="btn btn-lg btn-success btn-block">Login</a>
 -->                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>












</body>
</html>