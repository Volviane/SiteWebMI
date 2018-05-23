<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.doctoriales.mi.model.User"%>
<%@ page import="com.doctoriales.mi.model.Student"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Inscription</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/reset.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/layout.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/formulaire.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	type="text/css" media="all">
</head>

<body id="page1">
	<div class="body1">
		<!--div class="container">
			<!-- header -->
		<%-- <%@include file="includeFile/header.jsp" %> --%>
		<header>
			<%-- <%@include file="includeFile/navIndex.jsp" %> --%>
			<div class="container">
				<nav>
					<ul id="menu">
						<li><a href="${pageContext.request.contextPath}/">Acceuil</a></li>
						<li><a href="${pageContext.request.contextPath}/registration">Inscription</a></li>
						<li><a
							href="${pageContext.request.contextPath}/uploadArticle">Soumettre
								un article</a></li>
						<li><a
							href="${pageContext.request.contextPath}/updateParameter">modifier
								vos parametres</a></li>
						<li><a href="${pageContext.request.contextPath}/">Modifier
								un article</a></li>
					</ul>
				</nav>
				<ul id="icon">
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/resources/css/icon1.jpg"
							alt=""></a></li>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/resources/css/icon2.jpg"
							alt=""></a></li>
				</ul>
			</div>
			<figure>
				<a href="#"><img
					src="${pageContext.request.contextPath}/resources/css/doctoriales2018.jpg"
					alt="" width="1360px" height="477px"></a>
			</figure>

		</header>
	</div>
	<div class="container" id="monformulaire">
		<h2>Présentation</h2>
		<h4>
			Cette année, le département de Mathématiques et Informatique
			organisera ses Doctoriales du 06 au 10 Juin 2018 au campus C de
			l’université de Dschang. Ce séminaire entre dans le cadre des
			formations proposées aux doctorants de l’Université de Dschang pour
			réfléchir à leur projet et se préparer à <b>l'après-thèse</b>. Les
			Doctoriales sont une véritable formation à la valorisation des
			projets ou produits de recherche ou professionnel validé par les
			écoles doctorales au titre de la formation.
		</h4>
	</div>
	<div  id="monformulaire">
		<h2>Les objectifs pour les participants</h2>
		<h4>
			<ol>
				<li>Rencontrer d’autres chercheurs ou professionnels et
					réfléchir à l'après-thèse</li>
				<li>Améliorer ses capacités à présenter et à convaincre les
					auditeurs</li>
				<li>Apprendre à défendre des travaux de recherche devant un
					public</li>
				<li>Prendre conscience de ses acquis : compétences, capacité
					d’innovation...</li>
				<li>Travailler en équipes pluridisciplinaires</li>
				<li>Communiquer avec un auditoire non expert</li>
				<li>Se familiariser à la conception et à la gestion de projet
					en équipe pluridisciplinaire</li>
				<li>Explorer leur capacité d'innovation et de créativité</li>
				<li>Identifier et valoriser leurs compétences</li>
				<li>S'informer sur l'emploi des docteurs</li>
				<li>Réfléchir à leur avenir professionnel</li>
			</ol>
			
			Ce séminaire s’organise en sessions plénières et en sessions
			parallèles pendant trois jours. Ce cadre permet au doctorant de
			prendre du recul et du temps pour réfléchir et échanger avec de
			nouveaux interlocuteurs : doctorants d’autres disciplines,
			intervenants, recruteurs, créateurs et personnes ressources encadrant
			le séminaire,…
		</h4>
		</div>
		<div  id="monformulaire">
		<h2>Pourquoi les doctoriales?</h2>
		<h4>
			<ol>
				<li>Les doctorants doivent pouvoir en tirer le meilleur parti,
					notamment pour préparer l'après thèse</li>
				<li>Les Doctoriales ont donc pour objectif de sensibiliser les
					doctorants aux différentes opportunités de carrière qui s'offrent à
					eux.</li>
				<li>Les débouchés le plus souvent souhaité par les doctorants
					sont un poste d'enseignant-chercheur, ou de chercheur dans un
					organisme de recherche public ou privé. En fait, les situations
					professionnelles ouvertes par le doctorat sont beaucoup plus
					larges, tant vers le secteur public que vers le secteur privé</li>

			</ol>
		</h4>
		</div>
	</div>
	<div class="body2">
		<div class="main">
			<!-- content -->
			<section id="content">
				<div class="wrapper">
					<div class="pad1 pad_top1">
						<article class="cols marg_right1">
							<figure>
								<a href="#"><img
									src="${pageContext.request.contextPath}/resources/css/page1_img1.jpg"
									alt="" width="282px" height="179px"></a>
							</figure>
							<span class="font1">Informatique</span>
						</article>
						<article class="cols marg_right1">
							<figure>
								<a href="#"><img
									src="${pageContext.request.contextPath}/resources/css/images.png"
									alt="" width="282px" height="179px"></a>
							</figure>
							<span class="font1">Mathematique Algebre</span>
						</article>
						<article class="cols">
							<figure>
								<a href="#"><img
									src="${pageContext.request.contextPath}/resources/css/index.jpeg"
									alt="" width="282px" height="179px"></a>
							</figure>
							<span class="font1">Mathematique Analyse</span>
						</article>
					</div>
				</div>
			</section>
			<!-- content -->
			<!-- footer -->
			<%-- <%@include file="includeFile/footer.jsp" %> --%>
			<!-- 			<footer> -->
			<!-- 				<div class="wrapper"> -->
			<!-- 					<div class="pad1"> -->
			<!-- 						<div class="pad_left1"> -->
			<!-- 							<div class="wrapper"> -->
			<!-- 								<article class="col_1"> -->
			<!-- 									<h3>Etablissement</h3> -->
			<!-- 									<p class="col_address"> -->
			<!-- 										<strong>Faculte<br> Nom<br> filier<br> -->
			<!-- 											niveau -->
			<!-- 										</strong> -->
			<!-- 									</p> -->
			<!-- 									<p> -->
			<!-- 										FS<br> Informatique<br> 4<br> <a href="mailto:">lcenter@mail.com</a> -->
			<!-- 									</p> -->
			<!-- 								</article> -->
			<!-- 								<article class="col_2 pad_left2"> -->
			<!-- 									<h3>Nous joindre:</h3> -->
			<!-- 									<ul class="list2"> -->
			<!-- 										<li><a href="#">Sign Up</a></li> -->
			<!-- 										<li><a href="#">Forums</a></li> -->
			<!-- 										<li><a href="#">Promotions</a></li> -->
			<!-- 										<li><a href="#">Lorem</a></li> -->
			<!-- 									</ul> -->
			<!-- 								</article> -->
			<!-- 								<article class="col_3 pad_left2"> -->
			<!-- 									<h3>pourquoi nous:</h3> -->
			<!-- 									<ul class="list2"> -->
			<!-- 										<li><a href="#">Lorem ipsum dolor </a></li> -->
			<!-- 										<li><a href="#">Aonsect adipisic</a></li> -->
			<!-- 										<li><a href="#">Eiusmjkod tempor </a></li> -->
			<!-- 										<li><a href="#">Incididunt ut labore </a></li> -->
			<!-- 									</ul> -->
			<!-- 								</article> -->
			<!-- 								<article class="col_4 pad_left2"> -->
			<!-- 									<h3>Newsletter:</h3> -->
			<%-- 									<form id="newsletter" method="post"> --%>
			<!-- 										<div class="wrapper"> -->
			<!-- 											<div class="bg"> -->
			<!-- 												<input type="text"> -->
			<!-- 											</div> -->
			<!-- 										</div> -->
			<!-- 										<a href="#" class="button" -->
			<!-- 											onclick="document.getElementById('newsletter').submit()"><span><span><strong>Souscrire</strong></span></span></a> -->
			<%-- 									</form> --%>
			<!-- 								</article> -->
			<!-- 							</div> -->

			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 				</div> -->
			<!-- 			</footer> -->
			<!-- / footer -->
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery-1.5.2.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/cufon-yui.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/cufon-replace.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/Molengo_400.font.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/Expletus_Sans_400.font.js"></script>
	<script type="text/javascript">
		Cufon.now();
	</script>

</body>
</html>