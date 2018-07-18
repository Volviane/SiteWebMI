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
<title>Math-Info liste des évènements</title>
<meta name="description"
	content="Free Bootstrap Theme by BootstrapMade.com">
<meta name="keywords"
	content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
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
	.space{ padding-top: 100px;}
	.spaces{ height: 3000px;}
	.pad{ padding-left: 400px;}
</style>

</head>

<body>
	<div id="preloader"></div>

    <!-- DEBUT DU HEADER -->
	<c:import url="includes/headerUser.jsp"></c:import>
	<!-- FIN DU HEADER-->
	<%-- <!-- DEBUT DU HEADER -->
	<c:if test="${teacher==null  || student==null  }">
			<c:import url="includes/headerUser.jsp"></c:import>
  </c:if>
  <c:if test="${teacher!=null  || student!=null  }">
			<c:import url="teacher/includesTeacher/headerTeacher.jsp"></c:import>
  </c:if>
	<!-- FIN DU HEADER--> --%>
	<div class="container space">
			<h4 class="page-head-line">LISTE DES EVENEMENTS
			
			</h4>
       <c:forEach items="${events}" var="i" varStatus="pos">
       			  <div class="pullRight pad">
       			   <a
							href="${pageContext.request.contextPath}/registrationStudent?idEvent=<c:out value="${i.idEvent }"></c:out>">
							<button name="submit" type="submit"
								class="btn  btn-submit">
								s'inscrire a un evenement <i class="fa"></i>
							</button>
						</a>
					</div>
					<hr>
		<div class="media">
		
			<div class="media-left">
				<h4> <c:out value="${i.eventTitle }"></c:out> </h4>
				
			</div>
				<div class="media-body">
					<h6 class="media-heading">
						du <b> <c:out value="${i.eventBeginDate }"></c:out></b> au <b> <c:out value="${i.eventEndDate }"></c:out> </b>
					</h6>
					<p><c:out value="${i.eventDescription }"></c:out></p>
					<p>
					</p>
				</div>

			</div>
			<hr>
	  </c:forEach>
	</div>
	<!-- DEBUT DE L'ASIDE -->
		<c:import url="includes/aside.jsp"></c:import>
		<!-- FIN DE L'ASIDE -->
	
<div class="spaces"></div>

	<!--Footer-->
	 <%@include file="includes/footer.jsp"%>
	<!--/ Footer-->
	
	<!-- INCLUSION DES JS -->
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
    <!-- Main File-->
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/js/front.js"></script>
	<!-- FIN INCLUSION DES JS -->
</body>

</html>