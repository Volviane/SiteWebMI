<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> visualiser page Personnelle - MIUDS</title>
<c:import url="includesTeacher/teacherCSS.jsp"></c:import>

</head>
<body>

	<div id="preloader"></div>


	<!-- DEBUT DU HEADER -->
	<c:import url="includesTeacher/headerTeacher.jsp"></c:import>
	<!-- FIN DU HEADER-->

	<div
		style="clear: both; display: block; margin-top: 88px; height: 60px;"></div>

	<!-- DEBUT DU MENU -->
	<c:import url="includesTeacher/teacherMenu.jsp"></c:import>
	<!-- FIN DU MENU -->

<div class="col-md-7" style="padding: 0px">
			<!--Contenu-->
			<div class="media">
				<div class="media-left">
					photo
				</div>
				<div class="media-body">

				</div>
			</div>
			<div class="media">
				<div class="media-left">
					nom
				</div>
				<div class="media-body">
						<c:out value="${teacher.firstName }" /> 
				</div>
			</div>
			<div class="media">
				<div class="media-left">
					prénom
				</div>
				<div class="media-body">
						<c:out value="${teacher.lastName }" /> 
				</div>
			</div>
			<div class="media">
				<div class="media-left">
					grade
				</div>
				<div class="media-body">
						<c:out value="${teacher.gradeName }" /> 
				</div>
			</div>
			<!--/ Contenu-->
		</div>

	<!-- DEBUT DE L'ASIDE -->
	<c:import url="includes/aside.jsp"></c:import>
	<!-- FIN DE L'ASIDE -->

	<div
		style="clear: both; display: block; margin-top: 88px; height: 60px;"></div>


	<!--Footer-->
	<c:import url="../includes/footer.jsp"></c:import>
	<!--/ Footer-->

	<!-- INCLUSION DES JS -->
	<c:import url="../includesTeacher/teacherJS.jsp"></c:import>
	<!-- FIN INCLUSION DES JS -->
</body>
</html>