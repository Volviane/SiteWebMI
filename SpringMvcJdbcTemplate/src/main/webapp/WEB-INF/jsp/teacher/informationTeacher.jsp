<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:if test="${teacher==null}">
	<c:redirect url="/"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIUDS- Mes Informations</title>
<c:import url="includesTeacher/teacherCSS.jsp"></c:import>

</head>
<body>

	<div id="preloader"></div>


	<!-- DEBUT DU HEADER -->
	<c:import url="includesTeacher/headerTeacher.jsp"></c:import>
	<!-- FIN DU HEADER-->

	<div
		style="clear: both; display: block; margin-top: 88px; margin-bottom: 20px; height: 60px;">
		<ol class="breadcrumb">
			<li><a href="homeTeacher">Espace Personnel</a></li>
			<li><a href="#">Informations Personnelles</a></li>
			<li class="active gras">Mes Informations</li>
		</ol>
	</div>

	<!-- DEBUT DU MENU -->
	<c:import url="includesTeacher/teacherMenu.jsp"></c:import>
	<!-- FIN DU MENU -->


	<div class="col-md-7" style="padding: 0px">
		<!--Contenu-->
		<section>
			<h3>Mes Informations</h3>
			<hr>
			<div class="media">
				<div class="media-left">
					<a href="#"> <img
						src="${pageContext.request.contextPath}/resources/userResources/img/defaultImage.PNG"
						alt="" class="img-thumbnail img-circle media-object" />
						<h4 class="media-heading">
							<c:out value="${teachs.firstName }" />
							<c:out value="${teachs.lastName }" />
						</h4> <%-- 					   <h5><c:out value="${teachs.gradeName }" /></h5> --%>
					</a>
				</div>
				<div class="media-body"></div>
			</div>
		</section>



		<!--/ Contenu-->
	</div>
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