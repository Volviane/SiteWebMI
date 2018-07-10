<c:forEach items="${teachers}" var="i" varStatus="pos">
        <div class="col-lg-4 col-md-4 col-sm-4">
          <div class="pm-staff-profile-container">
            <div class="pm-staff-profile-image-wrapper text-center">
              <div class="pm-staff-profile-image">
                <img src="${pageContext.request.contextPath}/resources/userResources/img/defaultImg.PNG" alt="" class="img-thumbnail img-circle" />
              </div>
            </div>
            <div class="pm-staff-profile-details text-center">
              <p class="pm-staff-profile-name">${i.lastName }</p>
              <p class="pm-staff-profile-title">${i.grade }</p>

              <p class="pm-staff-profile-bio"></p>
            	<p>
             <a 
				href="${pageContext.request.contextPath}/viewPersonalPage?idTeacher=<c:out value="${i.idTeacher }"></c:out>">             <button name="submit" type="submit" class="btn btn-block btn-submit">
            Voir sa page personnelle <i class="fa fa-arrow-right"></i></button> </a>
          </p>
            </div>
          </div>
        </div>
        </c:forEach>
        