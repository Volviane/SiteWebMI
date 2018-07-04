<aside class="col-md-3 pull-right" style="padding: 0px;">
	<section>
		<h3>Communiqu�s</h3>
		<hr>
		<div>
				<h4>Titre du communiqu�</h4>
				<p>Bienvenu � tous sur le site du d�partement de Maths-Info de l'universit� de Dschang</p>
				<p>Publi� le 02 Juillet 2018</p>
				<a href="" class="btn btn-primary text-center">Lire la suite</a>
			</div>
		
		<c:forEach items="" var="com">
		<hr>
			<div>
				<h4><c:out value="${com.communiqueTitle}"></c:out></h4>
				<p><c:out value="${com.communiqueContent}"></c:out></p>
				<p>Publi� le <c:out value="${com.publicationDate}"/></p>
				<a href="" class="btn btn-primary text-center">Lire la suite</a>
			</div>
		</c:forEach>
		<hr>
		<a href="" class="btn btn-primary">Voir toutes les Publications</a>
	</section>
	<hr>
	<section>
		<h3>Ev�nements</h3>
		<div>
				<h4>Titre de l'�v�nement</h4>
				<p>Bienvenu � tous sur le site du d�partement de Maths-Info de l'universit� de Dschang</p>
				<p>Publi� le 02 Juillet 2018</p>
				<a href="" class="btn btn-primary text-center">Lire la suite</a>
			</div>
			<hr>
		<c:forEach items="" var="com">
			<div>
				<h4><c:out value="${com.communiqueTitle}"></c:out></h4>
				<p><c:out value="${com.communiqueContent}"></c:out></p>
				<p>Publi� le <c:out value="${com.publicationDate}"/></p>
				<a href="" class="btn btn-primary text-center">Lire la suite</a>
			</div>
			<hr>
		</c:forEach>
		<a href="" class="btn btn-primary">Voir toutes les Publications</a>
	</section>
</aside>
