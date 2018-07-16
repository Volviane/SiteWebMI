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
<title>Math-Info home teacher</title>
<meta name="description"
	content="Free Bootstrap Theme by BootstrapMade.com">
<meta name="keywords"
	content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
	<!-- DEFINITION DES STYLES CSS -->
 	<%@include file="includesTeacher/teacherCSS.jsp"%>
 	<!-- FIN DEFINITION DES STYLES -->
 	
<style type="text/css">
</style>

</head>

<body>
	<div id="preloader"></div>


	<!-- DEBUT DU HEADER -->
	<%@include file="includesTeacher/headerTeacher.jsp"%>
	<!-- FIN DU HEADER-->
	<div
		style="clear: both; display: block; margin-top: 88px; height: 60px;">
			<ol class="breadcrumb">
 				 <li><a href="homeTeacher" class="active gras">Espace Personnel</a></li>
			</ol>
		</div>
	
	<!-- DEBUT DU MENU -->
		<%@include file="includesTeacher/teacherMenu.jsp"%>
		
    <!-- FIN DU MENU -->


		<div class="col-md-7" style="padding: 0px">
			<!--Contenu-->
			<h3>Bienvenue ${teacher.firstName} ${teacher.lastName}</h3>
			
			<section>
				 <div class="media-left">
					<c:if test="${teacher.pictureName==null }">
						<img src="${pageContext.request.contextPath}/resources/userResources/img/defaultImage.PNG"
							style="height:200px;" alt=""
							class="img-thumbnail img-circle media-object" />
					</c:if>
					<c:if test="${teacher.pictureName!=null }">
						<img
							src="${pageContext.request.contextPath}/resources/userResources/img/${teacher.pictureName }"
							style="height:200px;" alt=""
							class="img-thumbnail img-circle media-object" />
					</c:if>
			</div>
				<div class="media-body">
					<h4 class="media-heading">
<%-- 						<c:out value="${teacher.firstName }"></c:out> --%>
					</h4>
					<p></p>
				</div> 
				
			</section>
			<!--/ Contenu-->
		</div>

		<!-- DEBUT DE L'ASIDE -->
		<%@include file="../includes/aside.jsp"%>
		<!-- FIN DE L'ASIDE -->
	
<div
		style="clear: both; display: block; margin-top: 88px; height: 60px;"></div>
	

	<!--Footer-->
	<%@include file="../includes/footer.jsp"%>
	<!--/ Footer-->
	
	<!-- INCLUSION DES JS -->
	
	<%@include file="includesTeacher/teacherJS.jsp"%>
	<!-- FIN INCLUSION DES JS -->
</body>

</html>