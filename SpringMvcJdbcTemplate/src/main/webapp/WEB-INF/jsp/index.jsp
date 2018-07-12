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
	<!-- DEFINITION DES STYLES CSS -->
 	<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/userResources/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/userResources/css/bootstrap.min.css">


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/userResources/css/imagehover.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/userResources/css/style.css">

<!-- Styles peso -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/userResources/css/stylePerso.css">

<!-- Libraries CSS Files -->
<link
	href="${pageContext.request.contextPath}/resources/userResources/lib/nivo-slider/css/nivo-slider.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/userResources/lib/owlcarousel/owl.carousel.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/userResources/lib/owlcarousel/owl.transitions.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/userResources/lib/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/userResources/lib/animate/animate.min.css"
	rel="stylesheet">
<!--   <link href="${pageContext.request.contextPath}/resources/userResources/lib/venobox/venobox.css" rel="stylesheet"> -->
<!-- Nivo Slider Theme -->
<link
	href="${pageContext.request.contextPath}/resources/userResources/css/nivo-slider-theme.css"
	rel="stylesheet">
<!-- Main Stylesheet File -->
<link
	href="${pageContext.request.contextPath}/resources/userResources/css/style1.css"
	rel="stylesheet">

<!-- Responsive Stylesheet File -->
<link
	href="${pageContext.request.contextPath}/resources/userResources/css/responsive.css"
	rel="stylesheet">

<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/assets/css/css/custom.css">
<!-- Favicon-->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/css/assets/css/img/favicon.ico">
<!-- CSS-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styleAdmin.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" media="all">


<style>
	.gras{ font-weight: bolder;}
	.vertical-align-middle{vertical-align: middle;}
</style>

 	<!-- FIN DEFINITION DES STYLES -->
 	
<style type="text/css">
</style>
</head>

<body>
	<div id="preloader"></div>


	<!-- DEBUT DU HEADER -->
	<c:import url="includes/headerUser.jsp"></c:import>
	<!-- FIN DU HEADER-->
	<!-- Start Slider Area -->
  <div id="home" class="slider-area"  style="display: block; height:400px;">
    <div class="bend niceties preview-2">
      <div id="ensign-nivoslider" class="slides" style="display: block; height:400px;">
<!--         <img src="${pageContext.request.contextPath}/resources/userResources/img/slider/banniere-2.png" alt="" title="#slider-direction-1" height="500px"/> -->
       <img src="${pageContext.request.contextPath}/resources/userResources/img/slider/banniere_1.png" alt="" title="#slider-direction-2" height="500px" style="display: block"/>
        <img src="${pageContext.request.contextPath}/resources/userResources/img/slider/banniere-3.png" alt="" title="#slider-direction-3" height="400px" style="display: block" />
      </div>
<!-- 
      direction 1
      <div id="slider-direction-1" class="slider-direction slider-one">
        <div class="container">
          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="slider-content">
                layer 1
                <div class="layer-1-1 hidden-xs wow slideInDown" data-wow-duration="2s" data-wow-delay=".2s">
                  <h2 class="title1">The Best Business Information </h2>
                </div>
                layer 2
                <div class="layer-1-2 wow slideInUp" data-wow-duration="2s" data-wow-delay=".1s">
                  <h1 class="title2">We're In The Business Of Helping You Start Your Business</h1>
                </div>
                layer 3
                <div class="layer-1-3 hidden-xs wow slideInUp" data-wow-duration="2s" data-wow-delay=".2s">
                  <a class="ready-btn right-btn page-scroll" href="#services">See Services</a>
                  <a class="ready-btn page-scroll" href="#about">Learn More</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      direction 2
      <div id="slider-direction-2" class="slider-direction slider-two">
        <div class="container">
          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="slider-content text-center">
                layer 1
                <div class="layer-1-1 hidden-xs wow slideInUp" data-wow-duration="2s" data-wow-delay=".2s">
                  <h2 class="title1">The Best Business Information </h2>
                </div>
                layer 2
                <div class="layer-1-2 wow slideInUp" data-wow-duration="2s" data-wow-delay=".1s">
                  <h1 class="title2">We're In The Business Of Get Quality Business Service</h1>
                </div>
                layer 3
                <div class="layer-1-3 hidden-xs wow slideInUp" data-wow-duration="2s" data-wow-delay=".2s">
                  <a class="ready-btn right-btn page-scroll" href="events.jsp">Voir les évènements</a>
                  <a class="ready-btn page-scroll" href="event/id">Lire la suite</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      direction 3
      <div id="slider-direction-3" class="slider-direction slider-two">
        <div class="container">
          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="slider-content">
                layer 1
                <div class="layer-1-1 hidden-xs wow slideInUp" data-wow-duration="2s" data-wow-delay=".2s">
                  <h2 class="title1">The Best business Information </h2>
                </div>
                layer 2
                <div class="layer-1-2 wow slideInUp" data-wow-duration="2s" data-wow-delay=".1s">
                  <h1 class="title2">Helping Business Security  & Peace of Mind for Your Family</h1>
                </div>
                layer 3
                <div class="layer-1-3 hidden-xs wow slideInUp" data-wow-duration="2s" data-wow-delay=".2s">
                  <a class="ready-btn right-btn" href="formations.jsp">Voir les Formations</a>
                  <a class="ready-btn" href="#about">Learn More</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
  -->   
  </div>
  </div>
  <!-- End Slider Area -->
  
  
  <div style="clear:both;display:block;"></div>
  
  <!--Feature-->
  <section id="feature" class="section-padding">
    <div class="container">
      <div class="row">
        <div class="header-section text-center">
          <h2>Présentation du Département</h2>
          <p>Le Département de mathématiques-informatique,est un des départements de la faculté des sciences de l'université 
              de Dschang. Il offre beaucoup de formations, notemment une licence en mathématique-informatique, un master en réseau
              et services distriués, un master en algèbre et un master en analyse.
           </p>
          <hr class="bottom-line">
        </div>
        <div class="feature-info">
          <div class="fea">
            <div class="col-md-4">
              <div class="heading pull-right">
                <h4>consulter les communiqués</h4>
                   <a
							href="${pageContext.request.contextPath}/viewNews">
							<button name="submit" type="submit"
								class="btn btn-info">
								consulter 
							</button>
						</a>
              </div>
              <div class="fea-img pull-left">
                <i class="fa fa-css3"></i>
              </div>
            </div>
          </div>
          <div class="fea">
            <div class="col-md-4">
              <div class="heading pull-right">
                <h4> consulter les évènements </h4>
                      <a
							href="${pageContext.request.contextPath}/viewEvent">
							<button name="submit" type="submit"
								class="btn btn-warning">
								consulter 
							</button>
						</a>
                   
              </div>
              <div class="fea-img pull-left">
                <i class="fa fa-drupal"></i>
              </div>
            </div>
          </div>
          <div class="fea">
            <div class="col-md-4">
              <div class="heading pull-right">
                <h4> consulter les resultats</h4>
                	<a
							href="${pageContext.request.contextPath}/viewResult">
							<button name="submit" type="submit"
								class="btn btn-success">
								consulter 
							</button>
						</a>
                
              </div>
              <div class="fea-img pull-left">
                <i class="fa fa-trophy"></i>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--/ feature-->
  
  
  <!--Faculity member-->
  <section id="faculity-member" class="section-padding">
    <div class="container">
      <div class="row">
        <div class="header-section text-center">
          <h2>Découvrez les membres du département de Mathématiques-Informatique</h2>
          <hr class="bottom-line">
        </div>
				<c:forEach items="${teachers}" var="i">
					<div class="col-lg-4 col-md-4 col-sm-4">
						<div class="pm-staff-profile-container">
							<div class="pm-staff-profile-image-wrapper text-center">
								<div class="pm-staff-profile-image">
									<img
										src="${pageContext.request.contextPath}/resources/userResources/img/defaultImage.PNG"
										alt="" class="img-thumbnail img-circle" />
								</div>
							</div>
							<div class="pm-staff-profile-details text-center">
								<p class="pm-staff-profile-name">${i.firstName }</p>

								<p class="pm-staff-profile-bio"></p>
								<p>
									<a
										href="${pageContext.request.contextPath}/viewPersonalPage?idTeacher=<c:out value="${i.idTeacher }"></c:out>">
										<button name="submit" type="submit"
											class="btn btn-block btn-submit">
											Voir sa page personnelle <i class="fa fa-arrow-right"></i>
										</button>
									</a>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>


			</div>
    </div>
  </section>
  <!--/ Faculity member-->
  
  <%@include file="includes/footer.jsp"%>
	
	

  <<!-- INCLUSION DES JS -->
	<script
		src="${pageContext.request.contextPath}/resources/userResources/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/userResources/js/jquery.easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/userResources/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/userResources/js/custom.js"></script>
	
	<!-- JavaScript Libraries-->
	<script
		src="${pageContext.request.contextPath}/resources/userResources/lib/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/userResources/lib/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/userResources/lib/venobox/venobox.min.js"></script>
	 <script
		src="${pageContext.request.contextPath}/resources/userResources/lib/knob/jquery.knob.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/userResources/lib/parallax/parallax.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/userResources/lib/easing/easing.min.js"></script>
	
	<script
		src="${pageContext.request.contextPath}/resources/userResources/lib/isotope/isotope.pkgd.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/userResources/js/main.js"></script>
		
	    <!-- JavaScript files-->
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/js/grasp_mobile_progress_circle-1.0.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/userResources/js/custom.js"></script>
      <script src="${pageContext.request.contextPath}/resources/userResources/lib/owlcarousel/owl.carousel.min.js"></script>
     <script src="${pageContext.request.contextPath}/resources/userResources/lib/nivo-slider/js/jquery.nivo.slider.js" type="text/javascript"></script>
   <script src="${pageContext.request.contextPath}/resources/userResources/lib/venobox/venobox.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/knob/jquery.knob.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/wow/wow.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/parallax/parallax.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/easing/easing.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/userResources/lib/appear/jquery.appear.js"></script>
  <script src="${pageContext.request.contextPath}/resources/userResources/lib/isotope/isotope.pkgd.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8HeI8o-c1NppZA-92oYlXakhDPYR7XMY"></script>
  <!-- Contact Form JavaScript File -->
  <script src="${pageContext.request.contextPath}/resources/userResources/contactform/contactform.js"></script>

  <script src="${pageContext.request.contextPath}/resources/userResources/js/main.js"></script> 
    <!-- Main File-->
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/js/front.js"></script>
	<!-- FIN INCLUSION DES JS -->
  <c:if test="${!empty errorLogin || !empty errorPassword }">
	  <script type="text/javascript">
			$(window).on('load', function() {
			   $('#login').modal('show')
			  });
	</script>
</c:if>
</body>

</html>