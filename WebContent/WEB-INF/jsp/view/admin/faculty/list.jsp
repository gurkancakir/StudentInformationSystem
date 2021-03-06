<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html class="app js no-touch no-android no-chrome firefox no-iemobile no-ie no-ie10 no-ie11 no-ios">

<spring:message var="faculty" code="leftmenu.admin.faculty.list" />
<template:header title="${ faculty }"></template:header>

<c:url var="addUrl" value="/admin/faculty/add" />
<c:url var="pageUrl" value="/admin/faculty/?page=" />
<c:url var="deleteUrl" value="/admin/faculty/delete/" />
<c:url var="updateUrl" value="/admin/faculty/update/" />

<body>
<section class="vbox">
	<template:top_menu></template:top_menu>
	<section>
		<section class="hbox stretch">
			<template:admin_menu></template:admin_menu>
			<template:content>
				<jsp:attribute name="content">
					<section class="vbox">
            			<section class="scrollable padder">
            				<section class="panel panel-default">
				                <header class="panel-heading">
				                  <spring:message code="faculty.list" />
				                </header>
				                <div class="row wrapper">
				                  <div class="col-sm-3 m-b-xs">
				                    <a class="btn btn-sm btn-success" href="${addUrl }">+</a>                
				                  </div>
				                  <div class="col-sm-6">
				                  	<input id="search" type="text" class="input-sm form-control" placeholder="<spring:message code='faculty.list.search' />" onkeyup="search()">
				                  </div>
				                </div>
				                <div class="table-responsive">
				                  <table class="table table-hover table-striped b-t b-light">
				                    <thead>
				                        <th><spring:message code="faculty.list.id" /></th>
				                        <th><spring:message code="faculty.list.name" /></th>
				                        <th><spring:message code="faculty.list.operation" /></th>
				                      </tr>
				                    </thead>
				                    <tbody id="tbody">
				                      <c:forEach var="faculty" items="${facultyList}">
									      <tr>
					                        <td><c:out value="${faculty.id }" /></td>
					                        <td><c:out value="${faculty.name }" /></td>
					                        <td><a class="btn btn-sm btn-info" href="${ updateUrl.concat(faculty.id) }"><spring:message code="faculty.list.updateButton" /></a> 
					                        <a class="btn btn-sm btn-danger" href="${ deleteUrl.concat(faculty.id) }"><spring:message code="faculty.list.deleteButton" /></a> </td>
					                      </tr>
									  </c:forEach>
									  <c:if test="${ empty facultyList}">
									  	<tr>
									  		<td colspan="3" align="center">
									  			<b><spring:message code="error.recordsNotFound" /></b>
									  		</td>
									  	</tr>
									  </c:if>
				                    </tbody>
				                  </table>
				                </div>
				                <footer class="panel-footer">
				                  <div class="row">
				                    <div class="col-sm-offset-4 col-sm-4 text-right text-center-xs imp-center">                
				                      <ul class="pagination pagination-sm m-t-none m-b-none">
				                      	<c:if test="${currentPage != 1}">
				                        	<li><a href="${pageUrl.concat(currentPage-1) }"><i class="fa fa-chevron-left"></i></a></li>
				                      	</c:if>
				                        <c:forEach var="i" begin="1" end="${totalPage }">
										   <li><a href="${pageUrl.concat(i)}"><c:out value="${i}"/></a></li>
										</c:forEach>
										<c:if test="${currentPage != totalPage && totalPage != 0}">
				                        	<li><a href="${pageUrl.concat(currentPage+1) }"><i class="fa fa-chevron-right"></i></a></li>
				                      	</c:if>
				                      </ul>
				                    </div>
				                    <div class="clearfix" />
				                  </div>
				                </footer>
				              </section>
            			</section>
            		</section>
				</jsp:attribute>
			</template:content>
		</section> <!-- <section class="hbox stretch"> -->
	</section>
</section>


<template:footer></template:footer>
<script type="text/javascript">
function search() {
	  var input, filter, table, tr, td, i;
	  
	  input = document.getElementById("search");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("tbody");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[1];
	    if (td) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
</script>

</body>
</html>