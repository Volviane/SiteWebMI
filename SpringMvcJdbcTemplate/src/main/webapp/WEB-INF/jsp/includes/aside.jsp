<aside class="col-md-3 pull-right" style="padding: 0px;">
	<section>
		
		<h5>Actualit�</h5>
		<hr>
<%-- 		<c:forEach items="" var="com"> --%>
<!-- 		<hr> -->
<!-- 			<div> -->
<%-- 				<h6 class="gras"><c:out value="${com.communiqueTitle}"></c:out></h6> --%>
<%-- 				<p><c:out value="${com.communiqueContent}"></c:out></p> --%>
<%-- 				<p>Publi� le <c:out value="${com.publicationDate}"/></p> --%>
<!-- 				<a href="" class="btn btn-primary text-center">Lire la suite</a> -->
<!-- 			</div> -->
<!-- 			<hr> -->
<%-- 		</c:forEach>		 --%>
		<a href="${pageContext.request.contextPath}/viewNews" class="btn btn-info">Voir tous les Communiqu�s</a>
	</section>
	
	
	<!-- D�but section des �v�nements -->
	<section style="margin-top: 10px;">
			<hr>
<%-- 		<c:forEach items="" var="com"> --%>
<!-- 		<hr> -->
<!-- 			<div> -->
<%-- 				<h6 class="gras"><c:out value="${com.communiqueTitle}"></c:out></h6> --%>
<%-- 				<p><c:out value="${com.communiqueContent}"></c:out></p> --%>
<%-- 				<p>Publi� le <c:out value="${com.publicationDate}"/></p> --%>
<!-- 				<a href="" class="btn btn-primary text-center">Lire la suite</a> -->
<!-- 			</div> -->
<!-- 			<hr> -->
<%-- 		</c:forEach> --%>
		<a href="${pageContext.request.contextPath}/viewEvent" class="btn btn-success">Voir tous les �v�nements</a>
	
	</section>
	<!-- Fin section des �v�nements -->
	<hr>
	<!-- D�but section des r�sultats -->
	<section>
<!-- 		<h3>r�sultats</h3> -->
	<hr> 
<!-- 			<div> -->
<!-- 				<h6 class="gras">R�sultats de RSD438</h6> -->
<!-- 				<p>Session de Juin 2018</p> -->
<!-- 				<p>Publi� le 23/06/2018</p> -->
<!-- 				<a href="" class="btn btn-primary text-center">Consulter</a> -->
<!-- 			</div> -->
			
<%-- 		<c:forEach items="" var="result"> --%>
<!-- 		<hr> -->
<!-- 			<div> -->
<%-- 				<h6 class="gras"><c:out value="${result.resultTitle}"></c:out></h6> --%>
<%-- 				<p>Session de <c:out value="${result.session}"></c:out></p> --%>
<%-- 				<p>Publi� le <c:out value="${result.publicationDate}"/></p> --%>
<!-- 				<a href="" class="btn btn-primary text-center">Consulter</a> -->
<!-- 			</div> -->
<!-- 			<hr> -->
<%-- 		</c:forEach> --%>
		<a href="${pageContext.request.contextPath}/viewResult" class="btn btn-warning">Voir tous les r�sultats</a>
	</section>
</aside>
