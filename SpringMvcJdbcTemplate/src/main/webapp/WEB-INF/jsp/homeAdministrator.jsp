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
<html>
<head>
<title>homeAdministrator</title>
<meta charset="utf-8">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/assets/css/bootstrap.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styleAdmin.css"
	type="text/css" media="all">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" media="all">

</head>

<body id="homeAdmin">
	<%@include file="includeFile/navAdmin.jsp"%>
	<!-- MENU SECTION END-->
	<div class="space"></div>
	<form class="navbar-form pull-right">
					<input type="text" style="width: 150px" class="input-small"
						placeholder="Recherche">
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-eye-open"></span> Chercher
					</button>
	</form>
	<div class="content-wrapper">
		<div class="container">
			<div class="space"></div>
			<div class="row">
				<div class="col-md-12">
					<h4 class="page-head-line title">DEPARTEMENT DE
						MATHEMATIQUES-INFORMATIQUE</h4>

				</div>
		  </div>
		  <div class="space"></div>
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="dashboard-div-wrapper bk-clr-one">
						<a href="${pageContext.request.contextPath}/openAcademiqueYear">
							ouvrir une année </a>
					</div>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="dashboard-div-wrapper bk-clr-two">
						<a href="${pageContext.request.contextPath}/createTeacher">
							créer un enseignant </a>
					</div>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="dashboard-div-wrapper bk-clr-three">
						<a href="${pageContext.request.contextPath}/createEvent">
							créer un évènement </a>
					</div>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="dashboard-div-wrapper bk-clr-four">
						<a href="${pageContext.request.contextPath}/closeEvent">
							fermer un évènement </a>
					</div>
				</div>

			</div>
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="dashboard-div-wrapper bk-clr-four">
						<a href="${pageContext.request.contextPath}/validateDocument">
							Valider un document </a>
					</div>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="dashboard-div-wrapper bk-clr-three">
						<a href="${pageContext.request.contextPath}/editNews">
							editer un communiqué </a>
					</div>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="dashboard-div-wrapper bk-clr-two">
						<a href="${pageContext.request.contextPath}/postEvent">
							publier un evenement </a>
					</div>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="dashboard-div-wrapper bk-clr-one">
						<a href="${pageContext.request.contextPath}/postNews">
							publier un communiqué </a>
					</div>
				</div>

			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="notice-board">
						
					</div>
					<hr />

					<hr />
					<div>
							<figure>
								<a href="#"><img
									src="${pageContext.request.contextPath}/resources/images/page1_img1.jpg"
									alt="" width="300px" height="200px"></a>
							</figure>
							<div class="space"></div>
							<figure>
								<a href="#"><img
									src="${pageContext.request.contextPath}/resources/images/images.png"
									alt="" width="300px" height="200px"></a>
							</figure>
					</div>
				</div>
				<div class="col-md-6">
					<hr />
					<div class="Compose-Message">
						<div class="panel panel-info">
							<div class="panel-heading">contacter un utilisateur</div>
							<div class="panel-body">

								<label>email : </label> <input type="text"
									class="form-control" /> <label>objet : </label> <input
									type="text" class="form-control" /> <label>
									Message : </label>
								<textarea rows="9" class="form-control"></textarea>
								<hr />
								<a href="#" class="btn btn-primary"><span
									class="glyphicon glyphicon-envelope"></span> envoyer Message </a>&nbsp;
								<a href="#" class="btn btn-warning"><span
									class="glyphicon glyphicon-tags"></span> enregistrer comme brouillon </a>
							</div>
							<div class="panel-footer text-muted">
								<strong>Note : </strong>pour des messages d'urgence
	
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- CONTENT-WRAPPER SECTION END-->
	<%@include file="includeFile/footerAdmin.jsp"%>
	<!-- FOOTER SECTION END-->
	<!-- JAVASCRIPT AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
	<!-- CORE JQUERY SCRIPTS -->
	<script src="assets/js/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS  -->
	<script src="assets/js/bootstrap.js"></script>

</body>
</html>