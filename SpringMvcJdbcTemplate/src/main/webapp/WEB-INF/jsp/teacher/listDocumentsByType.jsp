<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <c:if test="${teacher==null}">
			<c:redirect  url="/"></c:redirect>
	     </c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIUDS- Liste des <c:out value="${documentType}"/></title>
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
 				 <li class="active gras"><c:out value="${documentType}"/></li>
			</ol>
		</div>

	<!-- DEBUT DU MENU -->
	<c:import url="includesTeacher/teacherMenu.jsp"></c:import>
	<!-- FIN DU MENU -->


	<div class="col-md-7" style="padding: 0px">
		<!--Contenu-->
		<section class="col-md-11">
			
              <div class="card">
                <div class="card-header">
                  <h3>Liste des <c:out value="${documentType}"/></h3>
                  <hr>
                </div>
                <div class="card-body">
                <c:out value="${documents}"></c:out>
                  <div class="table-responsive">
                    <table class="table table-striped table-hover">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>Titre</th>
                          <th>Type</th>
                          <th>Description</th>
                          <th>Date d'ajout</th>
                          <th></th>
                        </tr>
                      </thead>
                      <tbody>
                      	<c:forEach items="${documents}" var="doc" varStatus="i">
                      		<tr>
	                          <th scope="row"><c:out value="${i.count}"/></th>
	                          <td><c:out value="${doc.documentTitle}"/></td>
	                          <td><c:out value="${doc.documentType}"/></td>
	                          <td><c:out value="${doc.documentDescription}"/></td>
	                          <td><c:out value="${doc.createDate}"/></td>
	                          <td><a href="${pageContext.request.contextPath}/resources/userResources/img/${doc.documentName }" class="btn btn-info">Consulter</a></td>
	                        </tr>
                      	
                      	</c:forEach>
                        
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
           
	
<!-- 	<nav aria-label="Page navigation"> -->
<!--   <ul class="pagination"> -->
<!--     <li> -->
<!--       <a href="#" aria-label="Previous"> -->
<!--         <span aria-hidden="true">&laquo;</span> -->
<!--       </a> -->
<!--     </li> -->
<!--     <li><a href="#">1</a></li> -->
<!--     <li><a href="#">2</a></li> -->
<!--     <li><a href="#">3</a></li> -->
<!--     <li><a href="#">4</a></li> -->
<!--     <li><a href="#">5</a></li> -->
<!--     <li> -->
<!--       <a href="#" aria-label="Next"> -->
<!--         <span aria-hidden="true">&raquo;</span> -->
<!--       </a> -->
<!--     </li> -->
<!--   </ul> -->
<!-- </nav> -->
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