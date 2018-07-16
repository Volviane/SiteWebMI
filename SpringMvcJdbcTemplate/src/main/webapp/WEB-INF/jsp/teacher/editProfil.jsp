<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:if test="${teacher==null}">
	<c:redirect url="/"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIUDS- Editer Profil</title>
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
			<li class="active gras">Edition du Profil</li>
		</ol>
	</div>

	<!-- DEBUT DU MENU -->
	<c:import url="includesTeacher/teacherMenu.jsp"></c:import>
	<!-- FIN DU MENU -->

	<div class="col-md-7" style="padding-left: 100px">
		<!--Contenu-->
		<section>
			<h3>
				<span class="fa fa-edit"></span> Edition du Profil
			</h3>
			<hr>
			<p>Vous pouvez ici modifier vos informations personnelles</p>
		
			<form id="form-1" class=" form-horizontal col-md-10" action="<c:url value='editProfil'/>" method="post" enctype="multipart/form-data">
				<table id="table-1" class="table table-hover" >
					<tbody>
						<tr>
							<td>
							<div class="form-group">
								<label for="lastName" class="">Nom</label>
								<input class="form-control" id="firstName" name="firstName" type="text" value="<c:out value="${teacher.firstName}"/>" >
							</div>
							</td>
						</tr>
						<tr>
							<td>
							<div class="form-group">
								<label for="firstName" class="">Prenom</label>
								<input class="form-control" id="lastName" name="lastName" type="text" value="<c:out value="${teacher.lastName}"/>">
							</div>
							</td>
						</tr>
						<tr>
							<td>
							</td>
						</tr>
						
						<tr>
							<td>
							<div class="form-group">
								<label for="emailAdress" class="">Adresse mail</label>
								<input class="form-control" id="emailAdress" name="emailAdress" type="text" value="<c:out value="${teacher.emailAdress}"/>">
							</div>
							</td>
						</tr>
						
						<tr>
							<td>
							<div class="form-group">
								<label for="phoneNumber" class="">Numéro de Téléphone</label>
								<input class="form-control" id="phoneNumber" name="phoneNumber" type="text" value="<c:out value="${teacher.phoneNumber}"/>">
							</div>
							</td>
						</tr>
						<tr>
							<td>
								<label for="sexe" >Sexe</label>
								<div class="radio">
									<label for="male" class="radio-inline">
									    <input type="radio" id="male" name="sex" value="Homme">
									    Homme 
									  </label>
									  
								 	<label for="female" class="radio-inline">
									    <input type="radio" id="female" name="sex" value="Femme">
									   	Femme
								    </label>
								</div>
							  
							 
							</td>
				</tr>
						
						<tr>
							<td>
							<div class="form-group">
								<label for="birthDate" class="">Date de Naissance</label>
								<input class="form-control" id="birthDate" name="birthDate" type="date" value="<c:out value="${teacher.birthDate}"/>">
							</div>
							</td>
						</tr>
						
						<tr>
							<td>
							<div class="form-group">
								<label for="birthPlace" class="">Lieu de Naissance</label>
								<input class="form-control" id="birthDate" name="birthPlace" type="text" value="<c:out value="${teacher.birthPlace}"/>">
							</div>
							</td>
						</tr>
						
						<tr>
							<td>
							<div class="form-group">
								<label for="grade" class="">Grade</label>
								
						<input class="form-control" id="grade" name="grade" type="text" value="<c:out value="${teacher.grade.gradeName}"/>">
							</div>
							</td>
						</tr>
						
						<tr>
							<td>
							<div class="form-group">
								<label for="domainLabel" class="">Domaine de Recherche</label>
								<select name="domainLabel" class="form-control" id="domainLabel" >
									<c:forEach items="${researchDomains }" var="dom">
										<option value='<c:out value="${dom.domainLabel}"/>'><c:out value="${dom.domainLabel}"/></option>
									</c:forEach>
							   </select>
							</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="form-group">
									<label	for="teacherDescription" class="">Brève descripton de Vous</label>
									<textarea class="form-control" name="teacherDescription" id="teacherDescription" rows="5" cols="30"></textarea>
								</div>
							</td>
						</tr>
						<tr>
							<td>
							<div class="form-group">
								<label for="photo" class="">Choisir une photo</label>
<%-- 								<input class="form-control" id="photo" name="files" type="file" value="<c:out value="${pageContext.request.contextPath}/resources/userResources/img/${teachers.pictureName }"/>"> --%>
	     							<input class="form-control" id="photo" name="files" type="file" value="">
							
							</div>
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<th>
								<div class="form-group">
									<input type="submit" value="ENREGISTRER" class="btn btn-primary pull-right">
								</div>
							</th>
							<th><div class="form-group">
									<input type="reset" value="REINITIALIZER TOUT" class="btn btn-danger pull-right">
								</div></th>
							
						</tr>
						
					</tfoot>
				</table>
				
			</form>
			<hr>
                          <c:if test="${error!=null}">
							<h6 class="alert"> <font color="red">${error}</font></h1>
			       		</c:if>
			        	<c:if test="${error==null}">
							<h6 class="alert alert-success"> <font color="green">ajout reussi</font></h1>
			       		</c:if>
			<hr />
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
<<<<<<< HEAD
	
	
=======

	<script type="text/javascript">
	
	/* 	function setEditableOn(target){
			console.log("debut: rendre "+target+" éditable");
			 document.getElementById(target).setAttribute("readonly", "false");
			//$(target).setAttribute("readonly","false");
				console.log("fin: rendre "+target+" éditable");
		}
	/* 
		function setEditableOff(target){
			//setAttribute("readonly",true);
			document.getElementById(target).setAttribute("readonly", "true");
		} */
	/*function setDisabled(target1,target2){
		 document.getElementById(target1).setAttribute("disabled","false");
		 document.getElementById(target2).setAttribute("disabled","false");
	} */
	</script>

>>>>>>> 54c00452e7a7a5c173d5d5a876024f545cdb0968
</body>
</html>