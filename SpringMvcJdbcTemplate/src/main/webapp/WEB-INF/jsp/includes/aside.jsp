<aside class="col-md-3 pull-right" style="padding: 0px;">
	<section>
		
		<h5>Actualité</h5>
		<hr>
<%-- 		<c:forEach items="" var="com"> --%>
<!-- 		<hr> -->
<!-- 			<div> -->
<%-- 				<h6 class="gras"><c:out value="${com.communiqueTitle}"></c:out></h6> --%>
<%-- 				<p><c:out value="${com.communiqueContent}"></c:out></p> --%>
<%-- 				<p>Publié le <c:out value="${com.publicationDate}"/></p> --%>
<!-- 				<a href="" class="btn btn-primary text-center">Lire la suite</a> -->
<!-- 			</div> -->
<!-- 			<hr> -->
<%-- 		</c:forEach>		 --%>
		<a href="${pageContext.request.contextPath}/viewNews" class="btn btn-info">Voir tous les Communiqués</a>
	</section>
	
	
	<!-- Début section des évènements -->
	<section style="margin-top: 10px;">
			<hr>
<%-- 		<c:forEach items="" var="com"> --%>
<!-- 		<hr> -->
<!-- 			<div> -->
<%-- 				<h6 class="gras"><c:out value="${com.communiqueTitle}"></c:out></h6> --%>
<%-- 				<p><c:out value="${com.communiqueContent}"></c:out></p> --%>
<%-- 				<p>Publié le <c:out value="${com.publicationDate}"/></p> --%>
<!-- 				<a href="" class="btn btn-primary text-center">Lire la suite</a> -->
<!-- 			</div> -->
<!-- 			<hr> -->
<%-- 		</c:forEach> --%>
		<a href="${pageContext.request.contextPath}/viewEvent" class="btn btn-success">Voir tous les évènements</a>
	
	</section>
	<!-- Fin section des évènements -->
	<hr>
	<!-- Début section des résultats -->
	<section>
<!-- 		<h3>résultats</h3> -->
	<hr> 
<!-- 			<div> -->
<!-- 				<h6 class="gras">Résultats de RSD438</h6> -->
<!-- 				<p>Session de Juin 2018</p> -->
<!-- 				<p>Publié le 23/06/2018</p> -->
<!-- 				<a href="" class="btn btn-primary text-center">Consulter</a> -->
<!-- 			</div> -->
			
<%-- 		<c:forEach items="" var="result"> --%>
<!-- 		<hr> -->
<!-- 			<div> -->
<%-- 				<h6 class="gras"><c:out value="${result.resultTitle}"></c:out></h6> --%>
<%-- 				<p>Session de <c:out value="${result.session}"></c:out></p> --%>
<%-- 				<p>Publié le <c:out value="${result.publicationDate}"/></p> --%>
<!-- 				<a href="" class="btn btn-primary text-center">Consulter</a> -->
<!-- 			</div> -->
<!-- 			<hr> -->
<%-- 		</c:forEach> --%>
		<a href="${pageContext.request.contextPath}/viewResult" class="btn btn-warning">Voir tous les résultats</a>
	</section>
</aside>
