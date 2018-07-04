<aside class="col-md-3 pull-right" style="padding: 0px;">
	<section>
		<h3>Communiqués</h3>
		<hr>
		<div>
				<h4>Titre du communiqué</h4>
				<p>Bienvenu à tous sur le site du département de Maths-Info de l'université de Dschang</p>
				<p>Publié le 02 Juillet 2018</p>
				<a href="" class="btn btn-primary text-center">Lire la suite</a>
			</div>
		
		<c:forEach items="" var="com">
		<hr>
			<div>
				<h4><c:out value="${com.communiqueTitle}"></c:out></h4>
				<p><c:out value="${com.communiqueContent}"></c:out></p>
				<p>Publié le <c:out value="${com.publicationDate}"/></p>
				<a href="" class="btn btn-primary text-center">Lire la suite</a>
			</div>
		</c:forEach>
		<hr>
		<a href="" class="btn btn-primary">Voir toutes les Publications</a>
	</section>
	<hr>
	<section>
		<h3>Evènements</h3>
		<div>
				<h4>Titre de l'évènement</h4>
				<p>Bienvenu à tous sur le site du département de Maths-Info de l'université de Dschang</p>
				<p>Publié le 02 Juillet 2018</p>
				<a href="" class="btn btn-primary text-center">Lire la suite</a>
			</div>
			<hr>
		<c:forEach items="" var="com">
			<div>
				<h4><c:out value="${com.communiqueTitle}"></c:out></h4>
				<p><c:out value="${com.communiqueContent}"></c:out></p>
				<p>Publié le <c:out value="${com.publicationDate}"/></p>
				<a href="" class="btn btn-primary text-center">Lire la suite</a>
			</div>
			<hr>
		</c:forEach>
		<a href="" class="btn btn-primary">Voir toutes les Publications</a>
	</section>
</aside>
