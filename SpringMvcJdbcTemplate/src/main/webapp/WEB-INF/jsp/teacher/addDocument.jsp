<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<c:if test="${teacher==null}">
			<c:redirect  url="/"></c:redirect>
	     </c:if>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIUDS- Ajouter un nouveau Document</title>
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
  				<li><a href="#">Documents</a></li>
 				 <li class="active gras">Nouveau Document</li>
			</ol>
		</div>

	<!-- DEBUT DU MENU -->
	<c:import url="includesTeacher/teacherMenu.jsp"></c:import>
	<!-- FIN DU MENU -->


	<div class="col-md-7" style="padding-left: 100px">
		<!--Contenu-->
		<section class="page login-page col-md-8">
		
				<div class="form-outer ">
					<div class="form-inner">
					<h3>Nouveau Document</h3>
					<hr>
<!-- 						<p class="alert alert-warning"><span class="fa fa-warning"></span> Les champ portant la mention <span class="text-danger gras">*</span> Sont obligatoires</p> -->
						<form action="<c:url value='addDocument'/>" method="post"
							class="" enctype="multipart/form-data">

							<div class="form-group">
								<label for="title-document"
									class="">Titre du document <span class="text-danger gras">*</span></label>
								<input id="title-document" type="text" name="documentTitle"
									required data-msg="veuillez entrer le titre du document"
									class="form-control" required> 
							</div>
							<c:if test="${errorLogin!=null}">
								<h6 class="text-error">
									<font color="red">${errorLogin}</font>
								</h6>
							</c:if>

							
							
								<%-- <select name="documentType">
							<c:forEach items="documentTypes" var="type">
								<option value='<c:out value="${type.name}"/>'>${type.name}</option>
							</c:forEach>
						</select> --%>
								<label for="titre-document" class="">Type
									du document <span class="text-danger gras">*</span></label> <select name="documentType" class="form-control"
									id="titre-document" required>
									<option value='Support de cours' selected>Support de Cours</option>
									<option value='fiche de TD'>Fiche de TD</option>
									<option value='Epreuve'>Epreuve</option>
									<option value='Notes de CC'>Notes de CC</option>
									<option value='Article de Recherche'>Article de
										Recherche</option>
									<option value='Correction Epreuves'>Correction
										Epreuves</option>
								</select>


							<div class="form-group">
							 <label
									for="description-document" class="">Descripton
									du document</label>
								<textarea class="form-control" rows="5" cols="30"></textarea>
							</div>

							<div class="form-group">
								<label for="file-document" class="">Choisir
									le fichier <span class="text-danger gras">*</span></label> <input id="file-document" type="file"
									
									name="files" required
									data-msg="veuillez entrer le titre du document"
									class="input-material">

							</div>
                            <hr>
							<div class="form-group">
								<input type="submit" value="AJOUTER" class="btn btn-info gras">
								<input type="reset" value="ANNULER" class="btn btn-danger gras">
								
							</div>
						</form>
						<hr>
                          <c:if test="${error!=null}">
							<h6 class="alert"> <font color="red">${error}</font></h1>
			       		</c:if>
			        	<c:if test="${error==null}">
							<h6 class="alert alert-success"> <font color="green">ajout reussi</font></h1>
			       		</c:if>
					</div>
				</div>
			
		</section>
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