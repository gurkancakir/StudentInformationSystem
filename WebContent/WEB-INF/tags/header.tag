<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${title}</title>
	<c:set var="url">${pageContext.request.requestURL}</c:set>
	<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
	
	<!-- bootstrap ve jqery icin js ve css ekleme islemi.. -->
	<link rel="stylesheet" type="text/css" media="screen" href="resources/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="resources/css/main.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="resources/css/toastr.min.css" />
	
	<link rel="stylesheet" type="text/css" media="screen" href="resources/css/animate.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="resources/css/app.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="resources/css/font-aweasome.min.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="resources/css/font.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="resources/css/app.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="resources/css/datatables.css" />

</head>