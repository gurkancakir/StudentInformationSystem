<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!-- JSTL ve Spring form tagini ekleylelim.. -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<template:header title="Person"></template:header>

<body>


<!-- butonun ismini ve url adresini dinamaik olarak degistirmek icin! -->

<c:url var="actionURL" value="/person.add"/>
<spring:message code="person.button.add" var="buttonName"/>
<c:if test="${ !empty update}">
	<c:url var="actionURL" value="/person.update"/>
	<spring:message code="person.button.update" var="buttonName"/>
</c:if>

<!-- http://www.layoutit.com/
https://datatables.net/examples/styling/bootstrap.html
 -->
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

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class=row>
					<span align="right"><a href="?language=en" >English</a>|<a href="?language=tr" >Turkce</a></span>
				</div>
				<div class="row">
					<div class="col-md-6">
					
						<!-- modelAttribute , form data bind  -->
						<!-- newPerson ismi ile Controller'daki newPerson attribute isminin ayni olduguna dikkat edelim!  -->
						<form:form  modelAttribute="newPerson" class="form-horizontal" method="post" action="${actionURL}">
							<fieldset>

								<!-- Form Name -->
								<legend><spring:message code="person.addlabel"/></legend>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="name"><spring:message code="person.name"/></label>
									<div class="col-md-4">		
										<!-- update isleminde kullanmak icin hidden olarak id ! -->								
										<form:hidden path="id" />
										<form:input id="name" path="name" type="text" class="form-control input-md"/>
									</div>
								</div>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="surname"><spring:message code="person.surname"/></label>
									<div class="col-md-4">
										<form:input id="surname" path="surname" type="text" class="form-control input-md"/>
									</div>
								</div>
								
								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="email"><spring:message code="person.email"/></label>
									<div class="col-md-4">
										<form:input id="email" path="email" type="email" class="form-control input-md"/>
									</div>
								</div>
								
								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="password"><spring:message code="person.password"/></label>
									<div class="col-md-4">
										<form:input id="password" path="password" type="password" class="form-control input-md"/>
									</div>
								</div>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="salary"><spring:message code="person.salary"/></label>
									<div class="col-md-4">
										<form:input id="salary" path="salary" type="number" class="form-control input-md"/>
									</div>
								</div>

								<!-- Button -->
								<div class="form-group">
									<label class="col-md-4 control-label" for="add"></label>
									<div class="col-md-4">
										<input type="submit" id="btnAdd" class="btn btn-primary" value ="${buttonName}"/>
									</div>
								</div>

							</fieldset>
						</form:form>
					</div>
					<div class="col-md-6"></div>
				</div>

				<div class="row">
					<div class="col-md-12">
					<legend><spring:message code="person.listlabel" /></legend>
						<table id="example" class="table table-striped table-bordered"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>Id</th>
									<th><spring:message code="person.name"/></th>
									<th><spring:message code="person.surname"/></th>
									<th><spring:message code="person.email"/></th>	
									<th><spring:message code="person.salary"/></th>
									<th><spring:message code="person.action"/></th>
								</tr>
							</thead>
							<tbody>

						<!-- Kayitlari listeleyelim... -->
								<c:forEach items="${allPersons}" var="person">
									<tr>
										<td><c:out value="${person.id}" /></td>
										<td><c:out value="${person.name}" /></td>
										<td><c:out value="${person.surname}" /></td>
										<td><c:out value="${person.email}" /></td>
										<td><c:out value="${person.salary}" /></td>
											<!-- Delete islemi icin RequestParam ekleyelim... -->	
										<td align="center" colspan="2">
											<a href="person.delete?personId=${person.id}" class="btn btn-danger" type="button"><spring:message code="person.action.delete"/></a>
											<!-- edit islemi icin RequestParam ekleyelim... -->			
											<a href="person.edit?personId=${person.id}" class="btn btn-warning" type="button"><spring:message code="person.action.edit"/></a>
										</td>									    
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<template:footer></template:footer>
</body>
</html>