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
<title>Math-Info s'enregistrer à un évènement</title>
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
</style>

</head>

<body>
	<div id="preloader"></div>


	<!-- DEBUT DU HEADER -->
	<%@include file="../includes/headerUser.jsp"%>
	<div class="container space">
			<h4 class="page-head-line">S'ENREGISTRER A UN EVENEMENT</strong></h4>
			<div class="col-md-6">
				<form action="<c:url value='registrationStudent'/>" method="post">
				   <label>Nom de l'évènement</label> <span class="text-danger gras">*</span>
<%-- 				           <input type="text" class="validate[required] form-control" name="eventName" value="${events.eventTitle}"  required /> --%>
							
							<select class="form-control" name="eventName"> 
							<c:forEach items="${eventList}" var="i">
										<option value='<c:out value="${i.eventTitle}"/>'>${i.eventTitle}</option>	
						     </c:forEach>
						     </select> 
				   <label>Matricule</label><span class="text-danger gras">*</span> 
							<input type="text"  name="matricule" required data-msg="" class="form-control">
                   <label>Email</label> <span class="text-danger gras">*</span>
                           <input type="email" class="validate[required,custom[email]] form-control" name="email" required /> 
                        
 					
                    <label>Nom</label><span class="text-danger gras">*</span>
                        <input type="text" class="validate[required] form-control" name="firstName"  required />
                     <label>Prénom</label>
                        <input type="text" class=" validate[required] form-control" name="lastName"  required />
                     <label class="">Cycle</label>
								<select class="form-control" name="cycleName"> 
                     				<c:forEach items="${cycles}" var="i">
                     					<option value="${i.cycleName }" ><c:out value="${i.cycleName }"></c:out></option>
                     				</c:forEach>
                			    </select>
                	 <label class="">Option</label>
							 <select class="form-control" name="optionName">
                     			<c:forEach items="${options}" var="i">
                     				<option value="${i.optionName }" ><c:out value="${i.optionName }"></c:out></option>
                     			</c:forEach>
                      	     </select>
                      <label class="">Niveau</label>
						<select class="form-control" name="studentLevel">
                     			<c:forEach items="${levels}" var="i">

                     				<option value="${i.levelName }"><c:out value="${i.levelName }"></c:out></option>


                     			</c:forEach>
                   	 </select> 
                        <hr />
					<input type="submit" value="s'inscrire" class="btn btn-info">
               </form>
                <hr />
                          <c:if test="${error!=null}">
							<h6 class="alert"> <font color="red">${error}</font></h1>
			       		</c:if>
			        	<c:if test="${error==null}">
							<h6 class="alert alert-success"> <font color="green">inscription reussie</font></h1>
			       		</c:if>
             </div>
	</div>
	<!-- DEBUT DE L'ASIDE -->
		<%@include file="../includes/aside.jsp"%>
		<!-- FIN DE L'ASIDE -->
<div class="spaces"></div>

	<!--Footer-->
	 <%@include file="../includes/footer.jsp"%>
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