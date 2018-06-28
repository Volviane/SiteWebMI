<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.mi.model.User"%>
<%@ page import="com.mi.model.Student"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Créer un enseignant</title>
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
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/css/style.blue.css" id="theme-stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/assets/plugins/validationengine/css/validationEngine.jquery.css" />
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
          <h4 class="page-head-line">Créer un enseignant</strong></h4>
      </section>
      <!-- Header Section-->
      <section class="dashboard-header padding">
         <div class="row">
                <div class="col-md-6">
		             <form action="<c:url value='createTeacher'/>" method="post">
                    <label>nom</label>
                        <input type="text" class="validate[required] form-control" name="firstName"  required />
                     <label>prénom</label>
                        <input type="text" class=" validate[required] form-control" name="lastName"  required />
                     <label>email</label>
                        <input type="email" class="validate[required,custom[email]] form-control" name="emailAdress"  />
                     <label>grade</label>
                        <select class="form-control validate[required]" name="gradeName">
                     			<c:forEach items="${grades}" var="i">
                     				<option value="${i.gradeName }" ><c:out value="${i.gradeName }"></c:out></option>
                     			</c:forEach>
                       </select>
                        <hr />
					<input type="submit" value="créer" class="btn btn-info">
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
     <!--Validate -->
    <script src="${pageContext.request.contextPath}/resources/css/assets/assets/plugins/jquery-2.0.3.min.js"></script>
     <script src="${pageContext.request.contextPath}/resources/css/assets/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/assets/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <!-- END GLOBAL SCRIPTS -->

    <!-- PAGE LEVEL SCRIPTS -->

     <script src="${pageContext.request.contextPath}/resources/css/assets/assets/plugins/validationengine/js/jquery.validationEngine.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/assets/plugins/validationengine/js/languages/jquery.validationEngine-en.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/assets/plugins/jquery-validation-1.11.1/dist/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/assets/js/validationInit.js"></script>
    <script>
        $(function () { formValidation(); });
        </script>
  </body>
</html>