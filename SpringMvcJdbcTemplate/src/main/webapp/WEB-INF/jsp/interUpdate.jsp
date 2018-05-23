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
						<li><a
							href="${pageContext.request.contextPath}/">Modifier
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
			<c:if test="${operationResult!=null}">
			<h1 class="list2"> <font color="red">${operationResult }</font></h1>
				<script type="text/javascript">
   					alert('${operationResult }');
			    </script>
			</c:if>
		</header>
		<!-- header-->


		<div class="container">

			<div id="monformulaire" class="container">

				<h1>IDENTIFIEZ-VOUS</h1>

				<form action="<c:url value='updateParameter'/>" method="post"
					id="Myform" class="well col-xs-8">

					<div class="form-group">
						<label class="form-label col-xs-2" for="mail">Email:</label> <input
							class="form-control" type="text" size="50" required name="email"><br>
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input
							class="form-control" type="password" name="password" size="50"
							id="password" required/ onkeyup='prenom()'><br>
					</div>
					<div class="form-group" id="qualite">
						<label for="quality">Qualite :</label> <select name="quality"
							class="form-control" onkeyup='quality()'>
							<option value="enseignant" onclick="chooseGrade()">Enseignant</option>
							<option value="etudiant" onclick="chooseLevel()">Etudiant</option>
						</select>
					</div>
					<div class="form-group" id="fin">
						<input class="btn btn-danger" type="reset" value="annuler" /> <input
							class="btn btn-primary" type="submit" value="suivant" />
					</div>
				</form>
			</div>
		</div>

		<!-- / corps -->
	</div>
	<div class="body2">
		<div class="container">
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
		src="${pageContext.request.contextPath}/resources/css/inscription.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/css/bootstrap.js"></script>
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
	<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>