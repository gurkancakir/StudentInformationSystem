<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html class="app js no-touch no-android no-chrome firefox no-iemobile no-ie no-ie10 no-ie11 no-ios">

<spring:message var="season" code="leftmenu.admin.season.list" />
<template:header title="${ season }"></template:header>

<c:url var="actionURL" value="/admin/season/update"/>
<body>
<section class="vbox">
	<template:top_menu></template:top_menu>
	<section>
		<section class="hbox stretch">
			<template:admin_menu></template:admin_menu>
			<template:content>
				<jsp:attribute name="content">
					<section class="vbox">
            			<div class="content padder">
            				<div class="row">
			                <div class="col-sm-12">
			                  <form:form modelAttribute="updateSeason" class="form-horizontal" method="post" action="${actionUrl}">
								<fieldset>
				                    <section class="panel panel-default">
				                      <header class="panel-heading">
				                        <span class="h4"><spring:message code="season.update" /></span>
				                      </header>
				                      <div class="panel-body">
				                       	<p class="text-muted"><spring:message code="season.update.inf" /></p>
				                        <form:hidden path="id"/>
										  <div class="col-md-12">
											  <label><spring:message code="season.update.title" /></label>
											  <form:input id="title" path="title" name="title" type="text" class="form-control"/>
										  </div>
										  <div class="col-md-12">
											  <label><spring:message code="season.update.startDate" /></label>
											  <form:input name="startDate" id="startDate" path="startDate" type="text" class="form-control combodate" data-format="DD.MM.YYYY HH:mm:ss" data-template="DD MMM YYYY HH : mm : ss" />
										  </div>
										  <div class="col-md-12">
											  <label><spring:message code="season.update.endDate" /></label>
											  <form:input name="endDate" id="endDate" path="endDate" type="text" class="form-control combodate" data-format="DD.MM.YYYY HH:mm:ss" data-template="DD MMM YYYY HH : mm : ss" />
										  </div>
				                      </div>
				                      <footer class="panel-footer text-right bg-light lter">
				                        <button type="submit" class="btn btn-success btn-s-xs"><spring:message code="season.update.submit" />
				                      </footer>
				                    </section>
			                  </fieldset>
			                  </form:form>
			                </div>
			              </div>
            			</div>
            		</section>
				</jsp:attribute>
			</template:content>
		</section> <!-- <section class="hbox stretch"> -->
	</section>
</section>


<template:footer></template:footer>

</body>
</html>