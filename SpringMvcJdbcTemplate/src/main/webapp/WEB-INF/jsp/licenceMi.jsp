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
<title>Math-Info licenceMI</title>
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
			<c:import url="includes/headerUser.jsp"></c:import>


	<!-- FIN DU HEADER-->
	<div class="container space">
			<h4 class="page-head-line"> LICENCE MI</strong></h4>
			<div class="media">
				<div class="media-left">
					<img
						src="${pageContext.request.contextPath}/resources/userResources/img/page1_img1.jpg"
						alt="" class="img-thumbnail  media-object" />
			
				</div>
				<div class="media-body">
					<div class="offset-3 col-lg-6" style="text-align: justify;"> 
				Les études dans le cycle de Licence dure trois (3) ans et sont réparties en six (6) semestres.
Ces études visent à faire acquérir à l’étudiant, les connaissances fondamentales larges de la
discipline à travers l’apprentissage des concepts et des méthodes de base. Le passage d’un
niveau d’étude donné à un niveau supérieur est subordonné aux conditions cumulées
suivantes:
<p>
- Valider individuellement 70% des Cours de l’ensemble des Unités d’Enseignement (UE) du
niveau ou acquérir au moins 75% des crédits du niveau;
- Ne pas avoir plus de deux (02) semestres consécutifs de retard dans le rythme de progression
sur le parcours choisi.
Les études dans ce cycle sont sanctionnées par le diplôme de Licence ou Bachelor of Science
(BSc.)</p>
 <h3> Objectifs de la formation</h3>
L’objectif ici consiste à fournir aux étudiants les connaissances scientifiques fondamentales
fortes dans le domaine des mathématiques et de l’informatique permettant à l’étudiant à
l’issue de sa formation d‘intégrer des Ecoles d’Ingénieurs de haut niveau dans le domaine des
sciences et technologie. C’est ainsi que les deux premières années sont constituées des cours
en tronc commun et qui se poursuit par une spécialisation en informatique ou en
mathématiques 3è année.
<h3>Débouchés</h3>
L’étudiant nanti d’un diplôme de Licence en Mathématiques et Informatique peut :
<p> -  Entrer en 3ème année ou 4ème année selon les cas de certaines Grandes Ecoles (Normale
Supérieur des Travaux Publics, ENSET, ENS, Ecole de Police, ENSPT, ISSEA, ENSAI filière
Informatique industrielle, Ecole d’aviation Civile, etc.)</p>
<p>-  faire carrière dans les entreprises
comme Ingénieur d’étude pour gérer et exploiter les systèmes d’information,
administrer les systèmes.</p>
			</div>
				</div>
			</div>
			
	</div>
	<!-- DEBUT DE L'ASIDE -->
		<c:import url="includes/aside.jsp"></c:import>
		<!-- FIN DE L'ASIDE -->
<div class="spaces"></div>

	<!--Footer-->
	 <%@include file="includes/footer.jsp"%>
	<!--/ Footer-->
	
	<!--js-->
	 <%@include file="includes/jsFile.jsp"%>
	<!--/ js-->
</body>

</html>