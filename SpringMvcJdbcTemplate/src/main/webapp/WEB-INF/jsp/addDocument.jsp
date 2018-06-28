<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/vendor/bootstrap/css/bootstrap.css"
	type="text/css" media="all">
	<!-- Font Awesome CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/css/fontastic.css">
    <!-- Google fonts - Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/css/assets/css/img/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/css/style.blue.css" id="theme-stylesheet">
   

</head>
<body>
<div class="page login-page">
	<div class="container">
		<div class="form-outer text-center d-flex align-items-center">
			<div class="form-inner">
				<div class="logo text-uppercase">
					<strong class="text-primary">AJOUTER DOCUMENT</strong>
				</div>
				<form action="<c:url value='addDocument'/>" method="post"
					class="text-left form-validate" enctype="multipart/form-data" >
					
					<div class="form-group-material">
						<input id="title-document" type="text" name="documentTitle" required
							data-msg="veuillez entrer le titre du document" class="input-material">
						<label for="title-document" class="label-material">Titre du document</label>
					</div>
					<c:if test="${errorLogin!=null}">
						<h6 class="text-error">
							<font color="red">${errorLogin}</font>
						</h6>
					</c:if>
					
					<div class="form-group-material">
						<%-- <select name="documentType">
							<c:forEach items="documentTypes" var="type">
								<option value='<c:out value="${type.name}"/>'>${type.name}</option>
							</c:forEach>
						</select> --%>
						<label for="titre-document" class="label-material">Type du document</label>
						<select name="documentType" class="form-control" id="titre-document">							
								<option value='Support de cours'>Support de Cours</option>
								<option value='fiche de TD'>Fiche de TD</option>
								<option value='Epreuve'>Epreuve</option>
								<option value='Notes de CC'>Notes de CC</option>	
								<option value='Article de Recherche'>Article de Recherche</option>
								<option value='Correction Epreuves'>Correction Epreuves</option>				
						</select>
						
					</div>
					<c:if test="${errorLogin!=null}">
						<h6 class="text-error">
							<font color="red">${errorLogin}</font>
							</h1>
					</c:if>
					
					<div class="form-group-material">						
						<input id="description-document" type="text" name="documentTitle" required
							data-msg="veuillez entrer le titre du document" class="input-material">
						<label for="description-document" class="label-material">Descripton du document</label>
						<textarea rows="5" cols="30" ></textarea>
					</div>
					
					<div class="form-group-material">		
						<label for="file-document" class="label-material">Choisir le fichier</label>				
						<input id="file-document" type="file" name="file" required
							data-msg="veuillez entrer le titre du document" class="input-material">
						
					</div>
					
					<div class="form-group text-center">
						<input type="submit" value="AJOUTER" class="btn btn-info">
						<!-- This should be submit button but I replaced it with <a> for demo purposes-->
					</div>
				</form>
				
		</div>
	</div>
	    </div>
	    </div>
	   
  <!-- JavaScript files-->
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/bootstrap/js/bootstrap.min.js"></script>    
 <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/jquery-validation/jquery.validate.min.js"></script>
       <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/js/charts-home.js"></script>
    <!-- Main File-->
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/js/front.js"></script>
</body>
</html>