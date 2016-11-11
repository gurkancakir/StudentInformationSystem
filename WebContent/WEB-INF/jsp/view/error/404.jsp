<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>

<template:header title="404"></template:header>

<body>
	<template:content>
		<jsp:attribute name="content">
			<div class="row m-n">
		      <div class="col-sm-4 col-sm-offset-4">
		        <div class="text-center m-b-lg">
		          <h1 class="h text-white animated fadeInDownBig">404</h1>
		        </div>
		      </div>
		    </div>
		</jsp:attribute>
	</template:content>
	<template:footer></template:footer>
</body>
</html>