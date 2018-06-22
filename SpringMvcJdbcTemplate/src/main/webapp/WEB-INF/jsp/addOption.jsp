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
<title>ajouter cycle</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/assets/css/bootstrap.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styleAdmin.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" media="all">
</head>

<body id="page1">

	<div class="body1">
    <%@include file="includeFile/navAdmin.jsp"%>
    <!-- LOGO HEADER END-->
   
    <!-- MENU SECTION END-->
    <div class="content-wrapper">
        <div class="container">
            <div class="row">

            </div>
            <div class="row">
                <div class="col-md-6">
                     <h4 class="page-head-line">Ajouter une option</strong></h4>
                    <br />
                  <form action="<c:url value='addOption'/>" method="post">
                    
                     <label>cycle</label>
                    
                    	 <select class="form-control">
                     			<c:forEach items="${cycles}" var="i">
                     				<option value="${i.cycleName }"><c:out value="${i.cycleName }"></c:out></option>
                     			</c:forEach>
                     	 </select>
                     
                     
                     		<label>niveau</label>
                    		<div class="form-group">
                     			
                      			  <input type="text" class="form-control" name="optionName" />
                             </div>
                    
                        <hr />
                        <a href="homeAdministrator.jsp" class="btn btn-info"><span class="glyphicon glyphicon-user"></span> &nbsp;enregistrer</a>&nbsp;
                </form>
                </div>
                <div class="col-md-6">
                <div class="space"></div>
                    <div class="alert alert-info">
                        Vous allez pourvoir ici, enregistrer les différentes options retrouvées au département de mathématiques-informatiques.
                        <br />
                       
                    </div>
                    <div class="alert alert-success">
                         <strong> Instructions:</strong>
                        <ul>
                            <li>
                               choisir le cycle
                            </li>
                            <li>
                               entrer une option correspondant au cycle
                            </li>
                            <li>
                                puis l'enregistrer
                            </li>
                         
                        </ul>
                       
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- CONTENT-WRAPPER SECTION END-->
  <%@include file="includeFile/footerAdmin.jsp"%>
   
    <script src="assets/js/bootstrap.js"></script>
</body>
</html>