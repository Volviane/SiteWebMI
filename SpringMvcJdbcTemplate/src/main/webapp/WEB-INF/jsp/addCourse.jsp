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
    <title>ajouter ue</title>
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
         <h4 class="page-head-line">Ajouter une unité de valeur</strong></h4>
      </section>
      <!-- Header Section-->
      <section class="dashboard-header padding">
       <div class="row">
             <div class="col-md-6">
                 <form action="<c:url value='addCourse'/>" method="post">
                     <label>niveau</label>
                    
                    	 <select class="form-control" name="levelName">
                     			<c:forEach items="${levels}" var="i">

                     				<option value="${i.levelName }"><c:out value="${i.levelName }"></c:out></option>

                     				<option value="${i.levelName }" ><c:out value="${i.levelName }"></c:out></option>

                     			</c:forEach>
                     	 </select>
                     
                     		<label>code de l'uv </label>
                    		<div class="form-group">
                     			
                      			  <input type="text" class="form-control" name="courseCode" />
                             </div>
                             <label>nom de l'uv </label>
                    		<div class="form-group">
                     			
                      			  <input type="text" class="form-control" name="courseName" />
                             </div>
                             <label>semestre </label>
                    		<div class="form-group">
                     			
                      			  <select class="form-control" name="semester">

                     				<option value="sem1">Semestre 1</option>

                     				<option value="sem2" >Semestre 2</option>
                     	          </select>
                     
                             </div>
                    
                        <hr />
                  <input type="submit" value="Enregistrer" class="btn btn-info">
                </form>
                </div>
           </div>
      </section>
      <!-- Statistics Section-->
      
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