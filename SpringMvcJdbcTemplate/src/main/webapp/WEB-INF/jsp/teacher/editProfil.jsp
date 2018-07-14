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


	<div class="col-md-7" style="padding: 15px">
		<!--Contenu-->
		<section>
			<h3>
				<span class="fa fa-edit"></span> Edition du Profil
			</h3>
			<hr>

			<div class="row panel panel-default marges-in">
				<form class="col-md-8"
					action="<c:url value='editProfil'/>" method="post"
					enctype="multipart/form-data">
					<fieldset class="well marges-out">
						<legend>Informations Personelles</legend>
						<div class="form-group">
							<label for="lastName" class="">Nom <span class="text-danger gras">*</span></label> <input
								class="form-control" id="lastName" name="lastName" type="text"
								value="<c:out value="${teacher.lastName}"/>" required>
						</div>

						<div class="form-group">
							<label for="firstName" class="">Prenom</label> <input
								class="form-control" id="firstName" name="firstName" type="text"
								value="<c:out value="${teacher.lastName}"/>">
						</div>

						<label for="sexe">Sexe <span class="text-danger gras">*</span></label>
						<div class="radio">
							<label for="male" class="radio-inline"> <input
								type="radio" id="male" name="sex" value="Homme" checked>
								Homme
							</label> <label for="female" class="radio-inline"> <input
								type="radio" id="female" name="sex" value="Femme"> Femme
							</label>
						</div>



						<div class="form-group">
							<label for="birthDate" class="">Date de Naissance</label> <input
								class="form-control" id="birthDate" name="birthDate" type="date"
								value="<c:out value="${teacher.birthDate}"/>"
								onblur="setEditableOff('birthDate')">
						</div>

						<div class="form-group">
							<label for="birthPlace" class="">Lieu de Naissance</label> <input
								class="form-control" id="birthDate" name="birthPlace"
								type="text" value="<c:out value="${teacher.birthPlace}"/>"
								onblur="setEditableOff('birthPlace')">
						</div>
					</fieldset>

					<fieldset class="well">
						<legend>Adresses</legend>
						<div class="form-group">
							<label for="emailAdress" class="">Adresse mail <span class="text-danger gras">*</span></label> <input
								class="form-control" id="emailAdress" name="emailAdress"
								type="text" value="<c:out value="${teacher.emailAdress}"/>"
								required>
						</div>

						<div class="form-group">
							<label for="phoneNumber" class="">Numéro de Téléphone</label> <input
								class="form-control" id="phoneNumber" name="phoneNumber"
								type="text" value="<c:out value="${teacher.phoneNumber}"/>"
								onblur="setEditableOff('phoneNumber')">
						</div>
					</fieldset>

					<fieldset class="well">
						<legend>Inforamations Professionnelles</legend>
						<div class="form-group">
							<label for="grade" class="">Grade <span class="text-danger gras">*</span></label> <select name="grade"
								class="form-control" id="grade" required>
								<option
									value='<c:out value="${teacher.grade.gradeName}"/>'
									selected><c:out value="${teacher.grade.gradeName}"></c:out></option>
								<c:forEach items="${grades }" var="grade">
									<option value='<c:out value="${grade.gradeName}"/>'><c:out
											value="${grade.gradeName}" /></option>
								</c:forEach>
								<!-- 									<option value='Chargé de cours'>Chargé de Cours</option> -->
								<!-- 									<option value='Assistant'>Assistant</option> -->
								<!-- 									<option value='Professeur'>Professeur</option> -->
								<!-- 									<option value='Maitre de Conférence'>Maitre de Conférence</option> -->

							</select>
						</div>

						<div class="form-group">
							<label for="domainLabel" class="">Domaine de Recherche</label> <select
								name="domainLabel" class="form-control" id="domainLabel"
								onblur="setEditableOff('domainLabel')">
								<option
									value='<c:out value="${teacher.researchDomain.domainLabel}"></c:out>'
									selected><c:out
										value="${teacher.researchDomain.domainLabel}"></c:out></option>
								<c:forEach items="${domains }" var="dom">
									<option value='<c:out value="${dom.domainLabel}"/>'><c:out
											value="${dom.domainLabel}" /></option>
								</c:forEach>
								<!-- 									<option value='Génie Logiciel'>Support de Cours</option> -->
								<!-- 									<option value='Réseaux et services distribués'>Réseaux et services distribués</option> -->
								<!-- 									<option value='Algèbre'>Algèbre</option> -->
								<!-- 									<option value='Analyse'>Analyse</option> -->
								<!-- 									<option value='Intelligence Artificielle'>Intelligence Artificielle</option> -->
							</select>
						</div>



						<div class="form-group">
							<label for="teacherDescription" class="">Brève descripton
								de Vous</label>
							<textarea class="form-control" name="teacherDescription"
								id="teacherDescription" rows="5" cols="30"
								onblur="setEditableOff('teacherDescription')"></textarea>
						</div>
					</fieldset>

					<div class="form-group">
						<label for="photo" class="">Choisir une photo</label> <input
							id="photo" name="files" type="file"
							value="<c:out value="${teacher.pictureName}"/>">
					</div>





					<div class="form-group">
						<input type="submit" value="ENREGISTRER" class="btn btn-primary gras">
						<input type="reset" value="REMETTRE A ZERO"
							class="btn btn-danger gras">
					</div>
					<div class="form-group"></div>

				</form>
				<div class="col-md-4 pull-right marges-out">
					<p class="alert alert-info">
						<span class="fa fa-info-circle"></span> Remplissez les champs suivant
						pour éditer votre profil. Les champ portant la mention <span
							class="text-danger gras">*</span> Sont obligatoires
					</p>
					<p class="alert alert-warning">
						<span class="fa fa-warning"></span> Les champ portant la mention <span
							class="text-danger gras">*</span> Sont obligatoires.
					</p>
				</div>
			</div>
			<div class="row">
				<c:if test="${error!=null}">
					<div class="alert alert-danger" role="alert">Erreur lors de
						l'édition du profil</div>
				</c:if>
				<c:if test="${success!=null}">
					<div class="alert alert-success" role="alert">Profil Edité
						avec Succès</div>
				</c:if>
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

</body>
</html>