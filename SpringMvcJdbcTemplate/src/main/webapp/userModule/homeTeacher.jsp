<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.mi.model.User"%>
<%@ page import="com.mi.model.Student"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="fr">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Math-Info Accueil</title>
  <meta name="description" content="Free Bootstrap Theme by BootstrapMade.com">
  <meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">

  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/userResources/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/userResources/css/bootstrap.min.css">
    
   
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/userResources/css/imagehover.min.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/userResources/css/style.css">
  
  <!-- Styles peso -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/userResources/css/stylePerso.css">

<!-- Libraries CSS Files -->
  <link href="${pageContext.request.contextPath}/resources/userResources/lib/nivo-slider/css/nivo-slider.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/userResources/lib/owlcarousel/owl.carousel.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/userResources/lib/owlcarousel/owl.transitions.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/userResources/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/userResources/lib/animate/animate.min.css" rel="stylesheet">
<!--   <link href="${pageContext.request.contextPath}/resources/userResources/lib/venobox/venobox.css" rel="stylesheet"> -->
 <!-- Nivo Slider Theme -->
  <link href="${pageContext.request.contextPath}/resources/userResources/css/nivo-slider-theme.css" rel="stylesheet">
 <!-- Main Stylesheet File -->
  <link href="${pageContext.request.contextPath}/resources/userResources/css/style1.css" rel="stylesheet">

  <!-- Responsive Stylesheet File -->
  <link href="${pageContext.request.contextPath}/resources/userResources/css/responsive.css" rel="stylesheet">


</head>

<body>
     <div id="preloader"></div>
     
 

  <c:import url="includes/headerUser.jsp"></c:import>
  
  

  
  
  
  <div style="clear:both;display:block;margin-top:88px;"></div>
  
   <div class="col-md-2">
  	<h4>Menu de navigation</h4>
  	<nav class="">
  		<ul class="nav nav-pills nav-stacked">
		  <li role="presentation" class="active"><a href="homeTeacher">Accueil</a></li>
		  <li role="presentation"><a href="">Profile</a></li>
		  <li role="presentation"><a href="#">Messages</a></li>
		</ul>
  	</nav>
  </div>
  
  
  <div class="container">
  
  <div class="col-md-10">
  	<!--Contenu-->
  	<div class="media">
  <div class="media-left">
    <a href="#">
     	<img src="${pageContext.request.contextPath}/resources/userResources/img/prNkenlifack.jpg" alt="" class="img-thumbnail img-circle media-object" />
    	<h5>Chef de Département</h5>
    </a>
  </div>
  <div class="media-body">
    <h4 class="media-heading">Pr Marcellin NKENLIFACK</h4>
    
  </div>
</div>
  	<!--/ Contenu-->    
  </div>
  
  <div class="col-md-2">
  	<aside>
  		<h4>Les Nouvelles du département</h4>
  	</aside>
  </div>
  </div>
  
  <!--Footer-->
  <footer id="footer" class="footer">
    <div class="container text-center">

      <h3>Souscrire à notre Newsletter!</h3>

      <form action="" method="get" class="mc-trial row">
        <div class="form-group col-md-3 col-md-offset-2 col-sm-4">
          <div class=" controls">
            <input name="name" placeholder="Enter Your Name" class="form-control" type="text">
          </div>
        </div>
        <!-- End email input -->
        <div class="form-group col-md-3 col-sm-4">
          <div class=" controls">
            <input name="EMAIL" placeholder="Enter Your email" class="form-control" type="email">
          </div>
        </div>
        <!-- End email input -->
        <div class="col-md-2 col-sm-4">
          <p>
            <button name="submit" type="submit" class="btn btn-block btn-submit">
            Submit <i class="fa fa-arrow-right"></i></button>
          </p>
        </div>
      </form>
      <!-- End newsletter-form -->
      <ul class="social-links">
        <li><a href="#link"><i class="fa fa-twitter fa-fw"></i></a></li>
        <li><a href="#link"><i class="fa fa-facebook fa-fw"></i></a></li>
        <li><a href="#link"><i class="fa fa-google-plus fa-fw"></i></a></li>
        <li><a href="#link"><i class="fa fa-dribbble fa-fw"></i></a></li>
        <li><a href="#link"><i class="fa fa-linkedin fa-fw"></i></a></li>
      </ul>
     Maths-info &copy; 2018. All rights reserved
      <div class="credits">
        Designed by <a href="#">Coders</a>
      </div>
    </div>
  </footer>
  <!--/ Footer-->

  <script src="${pageContext.request.contextPath}/resources/userResources/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/js/jquery.easing.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/js/custom.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/contactform/contactform.js"></script>

	<!-- JavaScript Libraries -->
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/bootstrap/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/owlcarousel/owl.carousel.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/venobox/venobox.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/knob/jquery.knob.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/wow/wow.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/parallax/parallax.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/easing/easing.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/nivo-slider/js/jquery.nivo.slider.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/appear/jquery.appear.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/isotope/isotope.pkgd.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8HeI8o-c1NppZA-92oYlXakhDPYR7XMY"></script>

  <!-- Contact Form JavaScript File -->
  <script src="${pageContext.request.contextPath}/resources/userResources/contactform/contactform.js"></script>

  <script src="${pageContext.request.contextPath}/resources/userResources/js/main.js"></script> 
</body>

</html>