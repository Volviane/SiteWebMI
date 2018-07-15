<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<c:if test="${teacher==null}">
			<c:redirect  url="/"></c:redirect>
	     </c:if>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIUDS- Ajouter un nouveau Resultat</title>
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
 				 <li><a href="hometeacher">Espace Personnel</a></li>
 				 <li class="active gras">Nouveau Resultat</li>
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
					<h3>Nouveau Resultat</h3>
					<hr>
						<p class="alert alert-warning"><span class="fa fa-warning"></span> Les champ portant la mention <span class="text-danger gras">*</span> Sont obligatoires</p>
						<form action="<c:url value='editResult'/>" method="post"
							class="" enctype="multipart/form-data">
<!--                   <label>cycle</label> -->
                    
<!--                     	 <select class="form-control" name="cycleName"> -->
<%--                      			<c:forEach items="${cycles}" var="i"> --%>
<%--                      				<option value="${i.cycleName }"><c:out value="${i.cycleName }"></c:out></option> --%>
<%--                      			</c:forEach> --%>
<!--                      	 </select> -->
<!--                       <label>option</label> -->
<!--                          <select class="form-control" name="optionName"> -->
<%--                      			<c:forEach items="${options}" var="i"> --%>
<%--                      				<option value="${i.optionName }"><c:out value="${i.optionName }"></c:out></option> --%>
<%--                      			</c:forEach> --%>
<!--                      	 </select> -->
<!--                      <label>niveau</label> -->
                    
<!--                     	 <select class="form-control" name="levelName"> -->
<%--                      			<c:forEach items="${level}" var="i"> --%>
<%--                      				<option value="${i.levelName }"><c:out value="${i.levelName }"></c:out></option> --%>
<%--                      			</c:forEach> --%>
<!--                      	 </select> -->
                           <label>Session </label>
                    		<div class="form-group">
                     			
                      			  <input type="text"  name="session"  class="form-control" name="fileResult" />
                             </div>
                             <label>Anné académique </label>
                    		<div class="form-group">
                     			
                      			  <input type="text"  name=" academicYear"  class="form-control"  />
                             </div>
                             <label>Titre </label>
                    		<div class="form-group">
                     			
                      			  <input type="text"  name="resultTitle"  class="form-control" />
                             </div>
                     		<label>fichier </label>
                    		<div class="form-group">
                     			
                      			  <input type="file"  name="files"  class="form-control" />
                             </div>
                            
                    
                        <hr />
                  <input type="submit" value="poster" class="btn btn-info">
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