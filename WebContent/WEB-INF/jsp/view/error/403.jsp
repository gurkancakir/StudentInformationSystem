<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<template:header title="403"></template:header>

<body>
	<template:content>
		<jsp:attribute name="content">
			<div class="row m-n">
		      <div class="col-sm-4 col-sm-offset-4">
		        <div class="text-center m-b-lg">
		          <h1 class="h text-white animated fadeInDownBig">403</h1>
		        </div>
		      </div>
		    </div>
		</jsp:attribute>
	</template:content>
	<template:footer></template:footer>
</body>
</html>