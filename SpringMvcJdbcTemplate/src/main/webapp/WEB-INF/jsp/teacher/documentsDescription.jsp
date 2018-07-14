<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <c:if test="${teacher==null}">
			<c:redirect  url="/"></c:redirect>
	     </c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIUDS- <c:out value="${documents.documentTitle}"/></title>
	<c:import url="includesTeacher/teacherCSS.jsp"></c:import>

</head>
<body>

	<div id="preloader"></div>


	<!-- DEBUT DU HEADER -->
	<c:import url="includesTeacher/headerTeacher.jsp"></c:import>
	<!-- FIN DU HEADER-->

	<div
		style="clear: both; display: block; margin-top: 88px; margin-bottom:30px; height: 60px;">
			<ol class="breadcrumb">
 				 <li><a href="homeTeacher">Espace Personnel</a></li>
  				<li><a href="listDocuments">Documents</a></li>
 				 <li class=""><a href="listDocumentsByType?documentType=${documents.documentType}"><c:out value="${documents.documentType}"/></a></li>
 				 <li class="active gras"><c:out value="${documents.documentTitle}"/></li>
			</ol>
		</div>

	<!-- DEBUT DU MENU -->
	<c:import url="includesTeacher/teacherMenu.jsp"></c:import>
	<!-- FIN DU MENU -->


	<div class="col-md-7" style="padding: 0px">
		<!--Contenu-->
		<section>
			<h2></h2>
			<div class="media">
				<div class="media-left">
					<a href="#"> <img class="media-object" src="..." alt="...">
					</a>
				</div>
				<div class="media-body">
					<h4 class="media-heading">
						<c:out value="${documents.documentTitle}" />
					</h4>
					<h3>
						<c:out value="${documents.documentType}" />
					</h3>
					<p>
						<c:out value="${documents.documentDescription}" />
					<p>
				</div>
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