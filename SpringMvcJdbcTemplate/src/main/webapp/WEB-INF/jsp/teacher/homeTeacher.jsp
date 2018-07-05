<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.mi.model.User"%>
<%@ page import="com.mi.model.Student"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:if test="${teacher==null}">
			<c:redirect  url="/"></c:redirect>
	     </c:if>
<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Math-Info Accueil</title>
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
	<c:import url="includesTeacher/headerTeacher.jsp"></c:import>
	<!-- FIN DU HEADER-->
	<div
		style="clear: both; display: block; margin-top: 88px; height: 60px;">
			<ol class="breadcrumb">
 				 <li><a href="homeTeacher" class="active gras">Espace Personnel</a></li>
			</ol>
		</div>
	
	<!-- DEBUT DU MENU -->
		<c:import url="includesTeacher/teacherMenu.jsp"></c:import>
    <!-- FIN DU MENU -->


		<div class="col-md-7" style="padding: 0px">
			<!--Contenu-->
			<div class="media">
				<div class="media-left">
					<a href="#"> <img
						src="${pageContext.request.contextPath}/resources/userResources/img/prNkenlifack.jpg"
						alt="" class="img-thumbnail img-circle media-object" />
						<h5>Chef de Département</h5>
					</a>
				</div>
				<div class="media-body">
					<h4 class="media-heading"><c:out value="${teacher.firstName }" />  <c:out value="${teacher.lastName }" /></h4>
					<h5>
						<c:out value="${teacher.grade.gradeName }" />
					</h5>
					<p>
<%-- 						<c:out value="${teacher.teacherDescription}" /> --%>
					</p>

				</div>
			</div>
			<!--/ Contenu-->
		</div>

		<!-- DEBUT DE L'ASIDE -->
		<c:import url="../includes/aside.jsp"></c:import>
		<!-- FIN DE L'ASIDE -->
	
<div
		style="clear: both; display: block; margin-top: 88px; height: 60px;"></div>
	

	<!--Footer-->
	<c:import url="../includes/footer.jsp"></c:import>
	<!--/ Footer-->
	
	<!-- INCLUSION DES JS -->
	<c:import url="includesTeacher/teacherJS.jsp"></c:import>
	<!-- FIN INCLUSION DES JS -->
</body>

</html>