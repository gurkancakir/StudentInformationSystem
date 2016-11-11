<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<template:header title="Forgot"></template:header>

<body>
<c:url var="actionURL" value="/forgot-password"/>

<c:set var="error" value="${ error }"/> 
<c:if test="${ !empty error}">
	<c:set var="code" value="${ error.code }" />
	<spring:message var="message" code="${ error.errors }" />
</c:if>

<c:set var="success" value="${ success }"/> 
<c:if test="${ !empty success}">
	<spring:message var="title" code="${ success.title }" />
	<spring:message var="body" code="${ success.body }" />
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
			    <span class="big-bold-text"><spring:message code="forgot.title"/></span>
				<div class="login-container">
					<form:form  modelAttribute="forgotPerson" class="form-horizontal" method="post" action="${actionURL}">
						<fieldset>
						  <div class="form-group">
						    <label for="email" class="col-sm-4 control-label"><spring:message code="forgot.email"/>:</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" path="email" name="email" id="email" placeholder=<spring:message code="forgot.email"/>>
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <div class="col-sm-offset-9 col-sm-3">
						      <button type="submit" align="right" style="min-width: 92px;" class="btn btn-default"><spring:message code="forgot.send"/></button>
						    </div>
						  </div>
						  
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

	if ('<c:out value="${success}"/>' !== ''){
		toastr.success('<c:out value="${body}"/>','<c:out value="${title}"/>');
		setTimeout(function(){
			window.location = "login";
		},2000);//2 sn sonra login'e yonlendirme
	}
</script>

</body>
</html>