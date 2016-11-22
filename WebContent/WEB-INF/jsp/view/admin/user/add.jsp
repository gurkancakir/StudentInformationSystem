<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html class="app js no-touch no-android no-chrome firefox no-iemobile no-ie no-ie10 no-ie11 no-ios">

<spring:message var="user" code="leftmenu.admin.user.list" />
<template:header title="${ user }"></template:header>

<c:url var="actionURL" value="/admin/user/add"/>
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
			                  <form:form modelAttribute="newUser" class="form-horizontal" method="post" action="${actionUrl}">
								<fieldset>
				                    <section class="panel panel-default">
				                      <header class="panel-heading">
				                        <span class="h4"><spring:message code="user.add" /></span>
				                      </header>
				                      <div class="panel-body">
				                        <p class="text-muted"><spring:message code="user.add.inf" /></p>
				                        <div class="col-md-12">
				                        	<label><spring:message code="user.add.role.name" /></label>
											<select class="form-control" id="roleId" name="roleId">
												<option value="-1"><spring:message code="dropdown.default" /></option>
												 <c:forEach var="role" items="${allRole}">
												 	<option value="<c:out value='${role.id }' />"><c:out value="${role.title}"></c:out></option>
												 </c:forEach>
											</select>
				                        </div>
				                        <form:hidden path="id"/>
				                        <div class="col-md-6">
				                        	<label><spring:message code="user.add.name" /></label>
				                        	<form:input id="name" path="name" name="name" type="text" class="form-control"/>
				                        </div>
				                        <div class="col-md-6">
				                        	<label><spring:message code="user.add.surname" /></label>
				                        	<form:input id="surname" path="surname" name="surname" type="text" class="form-control"/>
				                        </div>
				                        <div class="col-md-6">
				                        	<label><spring:message code="user.add.email" /></label>
				                        	<form:input id="email" path="email" name="email" type="email" class="form-control"/>
				                        </div>
				                        <div class="col-md-6">
				                        	<label><spring:message code="user.add.password" /></label>
				                        	<form:input id="password" path="password" name="password" type="password" class="form-control"/>
				                        </div>
				                        <div class="col-md-6">
				                        	<label><spring:message code="user.add.tcNo" /></label><br />
				                        	<form:input id="tcNo" path="tcNo" name="tcNo" type="text" maxlength="11" class="form-control"/>
				                        </div>
				                        <div class="col-sm-6">
				                        	<label><spring:message code="user.add.active" /></label><br />
					                        <label class="switch">
					                          <input type="checkbox" path="active" name="active" id="active">
					                          <span></span>
					                        </label>
					                    </div>
					                    <div class="col-md-12">
					                    	<label><spring:message code="user.add.avatar" /></label>
					                    	<input type="file" class="filestyle" data-icon="false" accept=".png,.PNG,.JPEG,.jpg" data-classButton="btn btn-default" data-classInput="form-control inline input-s">
					                    </div>
				                      </div>
				                      <footer class="panel-footer text-right bg-light lter">
				                        <button type="submit" class="btn btn-success btn-s-xs"><spring:message code="user.add.submit" />
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