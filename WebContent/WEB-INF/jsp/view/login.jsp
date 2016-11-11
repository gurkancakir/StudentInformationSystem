<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page session="true"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<template:header title="Login"></template:header>

<body>
<c:url var="actionJSecurity" value='/j_spring_security_check' />
<c:url var="forgotPassword" value="/forgot-password"/>

<c:set var="error" value="${ error }"/> 
<c:if test="${ !empty error}">
	<c:set var="code" value="${ error.code }" />
	<spring:message var="message" code="${ error.errors }" />
</c:if>

<c:set var="msg" value="${ msg }"/> 
<c:if test="${ !empty msg}">
	<c:set var="msgCode" value="${ msg.code }" />
	<spring:message var="msgMessage" code="${ msg.errors }" />
</c:if>

<div class="container">
<br />
	<div align="right">
		<a href="?lang=en">
	       <img alt="en" src="resources/img/en_language.gif" />
	    </a>
	    <a href="?lang=tr">
	       <img alt="tr" src="resources/img/tr_language.gif" />
	    </a>
	</div>
 	<div class="login-container">
		<div class="row">
			<div class="hidden-xs col-md-5  col-sm-5 border-right">
				<img class="logo" align="right" alt="logo" src="http://bilecik.edu.tr/Tema/images/bLogo.jpg" />
			</div>
			<div class="visible-xs col-xs-12 text-center">
				<img class="logo" alt="logo" src="http://bilecik.edu.tr/Tema/images/bLogo.jpg" />
			</div>
			<div class="col-md-5 col-sm-5 col-xs-12">
			    <span class="big-bold-text"><spring:message code="login.title"/></span>
				<div class="login-container">
					<form:form class="form-horizontal" method="post" action="${ actionJSecurity}">
						<fieldset>
						  <div class="form-group">
						    <label for="email" class="col-sm-4 control-label"><spring:message code="login.email"/>:</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" path="email" name="email" id="email" placeholder=<spring:message code="login.email"/>>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="password" class="col-sm-4 control-label"><spring:message code="login.password"/>:</label>
						    <div class="col-sm-8">
						      <input type="password" class="form-control" path="password" name="password" id="password" placeholder=<spring:message code="login.password"/>>
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <div class="col-sm-offset-9 col-sm-3">
						      <button type="submit" align="right" style="min-width: 92px;" class="btn btn-default"><spring:message code="login.login"/></button>
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <div class="col-sm-offset-1 col-sm-11">
						      <a class="underline" href="${ forgotPassword }"><spring:message code="login.lost"/></a>
						    </div>
						  </div>
						  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</fieldset>
					</form:form>
				</div>
			</div>
			<div class="clearfix" />
		</div>
	</div>
</div>

<template:footer></template:footer>
<script type="text/javascript">
	if ('<c:out value="${error}"/>' !== '')
		toastr.error('<c:out value="${message}"/>','<c:out value="${code}"/>');
	
	if ('<c:out value="${msg}"/>' !== '')
		toastr.success('<c:out value="${msgMessage}"/>','<c:out value="${msgCode}"/>');
</script>
</body>
</html>