<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!-- JSTL ve Spring form tagini ekleylelim.. -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<template:header title="Login"></template:header>

<body>

<c:url var="actionURL" value="/login.check"/>

 <nav class="navbar navbar-default">
	 <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">Brand</a>
		    </div>
		 
		 <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		  <div class="container">
			  <ul class="nav navbar-nav">
				<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
			    <li><a href="#">Link</a></li>
			    <li><a href="#">Link</a></li>
			    <li><a href="#">Link</a></li>
			    <li><a href="#">Link</a></li>
			  </ul>
		  </div>
		</div>
	</div>
</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form:form  modelAttribute="loginPerson" class="form-horizontal" method="post" action="${actionURL}">
					<fieldset>
					
					  <div class="form-group">
					    <label for="email" class="col-sm-2 control-label">Email</label>
					    <div class="col-sm-10">
					      <input type="email" class="form-control" path="email" id="email" placeholder="Email">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="password" class="col-sm-2 control-label">Password</label>
					    <div class="col-sm-10">
					      <input type="password" class="form-control" path="password" id="password" placeholder="Password">
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-primary">Sign in</button>
					    </div>
					  </div>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>

	<template:footer></template:footer>
</body>
</html>