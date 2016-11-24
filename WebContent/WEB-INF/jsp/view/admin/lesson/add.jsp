<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html class="app js no-touch no-android no-chrome firefox no-iemobile no-ie no-ie10 no-ie11 no-ios">

<spring:message var="lesson" code="leftmenu.admin.lesson.add" />
<template:header title="${ lesson }"></template:header>

<c:url var="actionURL" value="/admin/lesson/add"/>
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
			                  <form:form modelAttribute="newLesson" class="form-horizontal" method="post" action="${actionUrl}">
								<fieldset>
				                    <section class="panel panel-default">
				                      <header class="panel-heading">
				                        <span class="h4"><spring:message code="lesson.add" /></span>
				                      </header>
				                      <div class="panel-body">
				                        <p class="text-muted"><spring:message code="lesson.add.inf" /></p>

										  <div class="col-md-6">
											  <label><spring:message code="lesson.add.code" /></label>
											  <form:input id="code" path="code" name="code" type="text" class="form-control"/>
										  </div>
										  <div class="col-md-6">
											  <label><spring:message code="lesson.add.name" /></label>
											  <form:input id="name" path="name" name="name" type="text" class="form-control"/>
										  </div>
										  <div class="col-md-12">
											<label><spring:message code="lesson.add.season" /></label>
											<select class="form-control" id="seasonId" name="seasonId">
												<option value="-1"><spring:message code="dropdown.default" /></option>
												 <c:forEach var="season" items="${allSeason}">
													<option value="<c:out value='${season.id }' />"><c:out value="${season.title}"></c:out></option>
												 </c:forEach>
											</select>
										</div>
										<div class="col-md-12">
											<label><spring:message code="lesson.add.department" /></label>
											<select class="form-control" id="departmentId" name="departmentId">
												<option value="-1"><spring:message code="dropdown.default" /></option>
												 <c:forEach var="dep" items="${allDepartment}">
													<option value="<c:out value='${dep.id }' />"><c:out value="${dep.name}"></c:out></option>
												 </c:forEach>
											</select>
										</div>
										  <div class="col-md-12">
											  <label><spring:message code="lesson.add.instructor" /></label>
											  <select class="form-control" id="instructorId" name="instructorId">
												  <option value="-1"><spring:message code="dropdown.default" /></option>
												  <c:forEach var="ins" items="${allInstructor}">
													<option value="<c:out value='${ins.id }' />"><c:out value="${ins.name.concat(' ').concat(ins.surname)}"></c:out></option>
												 </c:forEach>
											  </select>
										  </div>
				                        <form:hidden path="id"/>

				                        <div class="col-md-6">
				                        	<label><spring:message code="lesson.add.abstract" /></label>
				                        	<form:input id="lessonAbstract" path="lessonAbstract" name="lessonAbstract" type="text" class="form-control"/>
				                        </div> 
				                        <div class="col-md-3">
				                        	<label><spring:message code="lesson.add.credit" /></label>
				                        	<form:input id="credit" path="credit" name="credit" type="number" class="form-control"/>
				                        </div>
				                        <div class="col-md-3">
				                        	<label><spring:message code="lesson.add.ects" /></label>
				                        	<form:input id="ects" path="ects" name="ects" type="number" class="form-control"/>
				                        </div>

				                      </div>
				                      <footer class="panel-footer text-right bg-light lter">
				                        <button type="submit" class="btn btn-success btn-s-xs"><spring:message code="lesson.add.submit" />
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