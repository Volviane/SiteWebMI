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
<title>Math-Info page personnelle</title>
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
	.space{ padding-top: 10px;}
	.spaces{ height: 3000px;}
	.backgroundInfo  {
			    width: 300px;
			    heigh: 400px;
			    background-color:#f5f5f5;
			    margin-bottom:10px;
			     padding: 10px;
				}
 .backgroundInfoTitle {
			    height: 30px;
			    background-color:#c0c0c0;
			     padding: 0px;
			     text-align: center;
			     font-weight:bold;
				}
	.padding {
			   margin-left:10px;
			  
				}
	.paddings {
			   margin-left:126px;
			  
				}
</style>

</head>

<body>
	<div id="preloader"></div>


	<!-- DEBUT DU HEADER -->
	<c:import url="includes/headerUser.jsp"></c:import>
	<!-- FIN DU HEADER-->
	<div
			style="clear: both; display: block; margin-top: 88px; height: 60px;">
			<ol class="breadcrumb">
				<li><a href="homeTeacher" class="active gras">Page
						Personnel</a></li>
			</ol>
	</div>
	<section class="col-md-2" style="min-height: 500px; font-size: 1em; padding: 5px;">
					<a
							href="${pageContext.request.contextPath}/viewTeacherList">
							<button name="submit" type="submit"
								class="btn btn-submit">
								 <i class="fa fa-arrow-left"></i> liste des enseignants 
							</button>
		         </a>

           </section>
	<div class="container space">

		<div class="col-md-7" style="padding: 0px">
			<!--Contenu-->

			<div class="media">
				<div class="media-left"></div>
				<div class="media-body">
					<c:if test="${teachers.pictureName==null }">
						<img
							src="${pageContext.request.contextPath}/resources/userResources/img/defaultImage.PNG"
							style="weight: 20px; height: 200px" alt=""
							class="img-thumbnail img-circle media-object" />
					</c:if>
					<c:if test="${teachers.pictureName!=null }">
						<img
							src="${pageContext.request.contextPath}/resources/userResources/img/${teachers.pictureName }"
							style="weight: 20px; height: 200px" alt=""
							class="img-thumbnail img-circle media-object" />
					</c:if>
					<h4 class="media-heading">
						<c:out value="${teachers.firstName }" />
						<c:out value="${teachers.lastName }" />
					</h4>
				<div class="row">
					<div class="col-lg-4">
						<div class="backgroundInfo">
							<c:if test="${teachers.grade.gradeName==null }">
								<p>
									<label> Grade: </label> <i> non renseigné</i>
								</p>
							</c:if>
							<c:if test="${teachers.grade.gradeName!=null }">
								<p>
									<label> Grade: </label>
									<h7> <c:out value="${teachers.grade.gradeName }" /></h7>
								</p>
							</c:if>
							<c:if test="${researchDomains.domainLabel==null }">
								<p>
									<label> Domaines de Recherche: </label> <i> non renseigné</i>
								</p>
							</c:if>
							<c:if test="${researchDomains.domainLabel!=null }">
								<p>
									<label>Domaines de Recherche: </label>
									<h7> <c:out value="${researchDomains.domainLabel }" /></h7>
								</p>
							</c:if>
							<c:if test="${teachers.cv==null }">
								<p>
									<label> cv: </label> <i> non renseigné</i>
								</p>
							</c:if>
							<c:if test="${teachers.cv!=null }">
								<p>
									<label>CV: </label>
									<h7> <c:out value="${teachers.cv }" /> </h7>
								</p>
							</c:if>
						</div>
						<div class="backgroundInfo">
							<c:if test="${teachers.emailAdress==null }">
								<p>
									<label> Adresse email: </label> <i> non renseigné</i>
								</p>
							</c:if>
							<c:if test="${teachers.emailAdress!=null }">
								<p>
									<label> Adresse email: </label>
									<h7> <c:out value="${teachers.emailAdress }" /></h7>
								</p>
							</c:if>
							<c:if test="${teachers.phoneNumber==null }">
								<p>
									<label> télephone: </label><i>non renseigné</i>
								</p>
							</c:if>
							<c:if test="${teachers.phoneNumber!=null }">
								<p>
									<label>télephone: </label>
									<h7> <c:out value="${teachers.phoneNumber }" /></h7>
								</p>
							</c:if>
						</div>
						<div class="backgroundInfo">
							<c:if test="${teachers.sexe==null }">
								<p>
									<label>sexe: </label>
									<h7>non renseigné</h7>
								</p>
							</c:if>
							<c:if test="${teachers.sexe!=null }">
								<p>
									<label>sexe: </label>
									<h7> <c:out value="${teachers.sexe }" /></h7>
								</p>
							</c:if>
							<c:if test="${teachers.birthDate==null }">
								<p>
									<label>Date de naissance: </label><i>non renseigné</i>
								</p>
							</c:if>
							<c:if test="${teachers.birthDate!=null }">
								<p>
									<label>Date de naissance: </label>
									<h7> <c:out value="${teachers.birthDate }" /></h7>
								</p>
							</c:if>
							<c:if test="${teachers.birthPlace==null }">
								<p>
									<label>Lieu de naissance: </label> <i> non renseigné</i>
								</p>
							</c:if>
							<c:if test="${teachers.birthPlace!=null }">
								<p>
									<label>Lieu de naissance: </label>
									<h7> <c:out value="${teachers.birthPlace }" /></h7>
								</p>
							</c:if>
						</div>


					</div>
						<div class="col-lg-6 ">
							<div class="backgroundInfo paddings">
								<div class="backgroundInfoTitle">Articles</div>
								<c:if test="${articles==null }">
								<p>
								 <i> pas d'articles</i>
								</p>
							</c:if>
								<c:if test="${articles!=null }">
									<p><div class="panel">
										<div class="panel-body"
											style="min-height: 300px; padding: 0px;">
							<div class="table-responsive">
								<table class="table table-striped table-hover">
									<thead>
										<tr class="info">
											<th>#</th>
											<th>Titre</th>
											<th>Télécharger</th>
										</tr>
									</thead>
									<tbody>


										<c:forEach items="${articles}" var="doc" varStatus="i">
											<tr>
												<th scope="row"><c:out value="${i.count}" /></th>
												<td><c:out value="${doc.articleTitle}" /></td>
																<td><a
																	href="${pageContext.request.contextPath}/resources/userResources/img/${doc.documentName }">
																		<button name="submit" type="submit"
																			class="btn  btn-submit">
																			Télécharger le Document <i class="fa fa-arrow-righ"></i>
																		</button>
																</a></td>
															</tr>

										</c:forEach>
					

									</tbody>
								</table>
							</div>
						</div>
					</div></p>
									
							</c:if>
							</div>
							<div class="backgroundInfo paddings">
								<div class="backgroundInfoTitle">Support de cours</div>
								<c:if test="${supportDeCours==null }">
								<p>
								 <i> pas de Support de cours</i>
								</p>
							</c:if>
								<c:if test="${supportDeCours!=null }">
									<p><div class="panel">
										<div class="panel-body"
											style="min-height: 300px; padding: 0px;">
							<div class="table-responsive">
								<table class="table table-striped table-hover">
									<thead>
										<tr class="info">
											<th>#</th>
											<th>Titre</th>
											<th>télécharger</th>
										</tr>
									</thead>
									<tbody>


										<c:forEach items="${supportDeCours}" var="doc" varStatus="i">
											<tr>
												<th scope="row"><c:out value="${i.count}" /></th>
												
											 </tr>

										</c:forEach>
					

									</tbody>
								</table>
							</div>
						</div>
					</div></p>
									
							</c:if>
							</div>


						</div>
					</div>
				</div>
			</div>
			<!--/ Contenu-->
		</div>

	</div>
	<!-- DEBUT DE L'ASIDE -->
		<%@include file="includes/aside.jsp"%>
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