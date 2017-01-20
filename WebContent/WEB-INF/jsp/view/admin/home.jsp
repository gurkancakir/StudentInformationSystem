<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html class="app js no-touch no-android no-chrome firefox no-iemobile no-ie no-ie10 no-ie11 no-ios">

<spring:message var="home" code="leftmenu.admin.home" />
<template:header title="${ home }"></template:header>

<body>
<section class="vbox">
	<template:top_menu></template:top_menu>
	<section>
		<section class="hbox stretch">
			<template:admin_menu></template:admin_menu>
			<template:content>
				<jsp:attribute name="content">
					<section class="vbox">
            			<section class="scrollable padder">
            				<br />
            				<div class="row">
            				  <!-- Donem -->
							  <div class="col-xs-6 col-sm-6 col-md-3">
							    <a href="#" class="thumbnail text-center bg-danger">
							      <i class="fa fa-book" style="font-size: 25em !important;"></i>
							    </a>
							  </div>
							  <!-- Fakulte -->
							  <div class="col-xs-6 col-sm-6 col-md-3">
							    <a href="#" class="thumbnail text-center bg-info">
							      <i class="fa fa-columns icon" style="font-size: 25em !important;"></i>
							    </a>
							  </div>
							  <!-- Bolum -->
							  <div class="col-xs-6 col-sm-6 col-md-3">
							    <a href="#" class="thumbnail text-center bg-default">
							      <i class="fa fa-columns icon" style="font-size: 25em !important;"></i>
							    </a>
							  </div>
							  <!-- Ders -->
							  <div class="col-xs-6 col-sm-6 col-md-3">
							    <a href="#" class="thumbnail text-center bg-warning">
							      <i class="fa fa-columns icon" style="font-size: 25em !important;"></i>
							    </a>
							  </div>							  
							</div>
							<div class="row">
            				  <!-- Donem -->
							  <div class="col-xs-6 col-sm-6 col-md-3">
							    <a href="#" class="thumbnail text-center bg-danger">
							      <i class="fa fa-book" style="font-size: 25em !important;"></i>
							    </a>
							  </div>
							  <!-- Fakulte -->
							  <div class="col-xs-6 col-sm-6 col-md-3">
							    <a href="#" class="thumbnail text-center bg-info">
							      <i class="fa fa-columns icon" style="font-size: 25em !important;"></i>
							    </a>
							  </div>
							  <!-- Bolum -->
							  <div class="col-xs-6 col-sm-6 col-md-3">
							    <a href="#" class="thumbnail text-center bg-default">
							      <i class="fa fa-columns icon" style="font-size: 25em !important;"></i>
							    </a>
							  </div>
							  <!-- Ders -->
							  <div class="col-xs-6 col-sm-6 col-md-3">
							    <a href="#" class="thumbnail text-center bg-warning">
							      <i class="fa fa-columns icon" style="font-size: 25em !important;"></i>
							    </a>
							  </div>							  
							</div>
            			</section>
            		</section>
				</jsp:attribute>
			</template:content>
		</section> <!-- <section class="hbox stretch"> -->
	</section>
</section>


<template:footer></template:footer>

</body>
</html>