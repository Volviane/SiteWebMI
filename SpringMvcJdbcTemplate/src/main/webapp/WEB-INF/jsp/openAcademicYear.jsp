<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ouvrir une année académique</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/vendor/bootstrap/css/bootstrap.css"
	type="text/css" media="all">
	<!-- Font Awesome CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/css/fontastic.css">
    <!-- Google fonts - Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
    <!-- jQuery Circle-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/css/grasp_mobile_progress_circle-1.0.0.min.css">
    <!-- Custom Scrollbar-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/css/assets/css/img/favicon.ico">
     <!-- CSS-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleAdmin.css" type="text/css" media="all">
    
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
    <!-- Side Navbar -->
    <%@include file="includeFile/sideBarAdmin.jsp"%>
    
    <div class="page">
      <!-- navbar-->
     <%@include file="includeFile/navAdmin.jsp"%>
      <!-- Counts Section -->
      <section class="dashboard-counts padding">
          <h4 class="page-head-line">ouvrir une année académique</strong></h4>
      </section>
      <!-- Header Section-->
      <section class="dashboard-header padding">
         <div class="row">
              <div class="col-md-6">
		       <form action="<c:url value='openAcademicYear'/>" method="post">
                    <label>année</label>
                        <input type="text" class="form-control" name="academicYear"  />
                    <label>niveau</label>
                    
                    	 <select class="form-control" name="juryLevelName">
                     			<c:forEach items="${levels}" var="i">
                     				<option value="${i.levelName }" ><c:out value="${i.levelName }"></c:out></option>
                     			</c:forEach>
                     	 </select>
                    <label>coordonnateur</label>
                    
                    	 <select class="form-control" name="cordo">
                     			<option> </option>
                     	 </select>
                    <label>président du jury </label>
                    
                    	 <select class="form-control" name="juryPresidentName">
                     			<c:forEach items="${teachers}" var="i">
                     				<option value="${i.lastName }" ><c:out value="${i.lastName }"></c:out></option>
                     			</c:forEach>
                     	 </select>
                        <hr />
                  <input type="submit" value="ouvrir" class="btn btn-info">
                 </form>
                </div>
           </div>
      </section>
      
    	<%@include file="includeFile/footerAdmin.jsp"%>
    </div>
    <!-- JavaScript files-->
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/js/grasp_mobile_progress_circle-1.0.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/chart.js/Chart.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/js/charts-home.js"></script>
    <!-- Main File-->
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/js/front.js"></script>
  </body>
</html>