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
<title>Math-Info liste des enseignants</title>
<meta name="description"
	content="Free Bootstrap Theme by BootstrapMade.com">
<meta name="keywords"
	content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
	<!-- DEFINITION DES STYLES CSS -->
 	<c:import url="includesTeacher/teacherCSS.jsp"></c:import>
 	<!-- FIN DEFINITION DES STYLES -->
 	
<style type="text/css">
</style>

</head>

<body>
	<div id="preloader"></div>


	<!-- DEBUT DU HEADER -->
	<c:import url="includes/headerUser.jsp"></c:import>
	<!-- FIN DU HEADER-->

	<div class="container">

	
	</div>


	<!--Footer-->
	 <%@include file="includes/footer.jsp"%>
	<!--/ Footer-->
	
	<!-- INCLUSION DES JS -->
	<c:import url="includesTeacher/teacherJS.jsp"></c:import>
	<!-- FIN INCLUSION DES JS -->
</body>

</html>