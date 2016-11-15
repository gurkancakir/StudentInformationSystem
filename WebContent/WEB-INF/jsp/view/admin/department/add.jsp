<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html class="app js no-touch no-android no-chrome firefox no-iemobile no-ie no-ie10 no-ie11 no-ios">

<spring:message var="department" code="leftmenu.admin.department.list" />
<template:header title="${ department }"></template:header>

<c:url var="actionURL" value="/admin/department/add"/>
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
			                  <form:form modelAttribute="newDepartment" class="form-horizontal" method="post" action="${actionUrl}">
								<fieldset>
				                    <section class="panel panel-default">
				                      <header class="panel-heading">
				                        <span class="h4"><spring:message code="department.add" /></span>
				                      </header>
				                      <div class="panel-body">
				                        <p class="text-muted"><spring:message code="department.add.inf" /></p>
				                        <label><spring:message code="department.add.faculty.name" /></label>
<%-- 				                        <form:select path="faculty" items="${allFaculty}" itemLabel="name" itemValue="id" class="form-control"/> --%>
										<select class="form-control" id="facultyId" name="facultyId">
											<option value="-1"><spring:message code="dropdown.default" /></option>
											 <c:forEach var="faculty" items="${allFaculty}">
											 	<option value="<c:out value='${faculty.id }' />"><c:out value="${faculty.name}"></c:out></option>
											 </c:forEach>
										</select>
				                        <label><spring:message code="department.add.name" /></label>
				                        <form:hidden path="id"/>
				                        <form:input id="name" path="name" name="name" type="text" class="form-control"/>
				                      </div>
				                      <footer class="panel-footer text-right bg-light lter">
				                        <button type="submit" class="btn btn-success btn-s-xs"><spring:message code="department.add.submit" />
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