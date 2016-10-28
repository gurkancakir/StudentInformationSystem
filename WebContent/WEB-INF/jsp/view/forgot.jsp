<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!-- JSTL ve Spring form tagini ekleylelim.. -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<template:header title="Forgot"></template:header>

<body>
<c:url var="actionURL" value="/login.check"/>
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
			<div class="col-md-5 col-xs-12 border-right">
				<img class="logo" align="right" alt="logo" src="http://bilecik.edu.tr/Tema/images/bLogo.jpg" />
			</div>
			<div class="col-md-5 col-xs-12">
			    <span class="big-bold-text"><spring:message code="forgot.title"/></span>
				<div class="login-container">
					<form:form  modelAttribute="loginPerson" class="form-horizontal" method="post" action="${actionURL}">
						<fieldset>
						  <div class="form-group">
						    <label for="email" class="col-sm-4 control-label"><spring:message code="forgot.email"/>:</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" path="email" id="email" placeholder=<spring:message code="forgot.email"/>>
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
</body>
</html>