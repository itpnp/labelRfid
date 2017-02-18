<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/bootstrap/css/dataTables.bootstrap.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/bootstrap/js/jquery-1.10.2.js" />"></script>
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
<title>View Data</title>
</head>
<body>
	<form name="form" action="/labelRfid/export" method="post">
		<div class="panel-body">
		<div class="form-group">
			<spring:url value="/home" var="home" />
			<button type="submit" class="btn btn-default">Export Data</button>
			<input type="button" onclick="location.href='${home}'" class="btn btn-default" value="back">
		</div>
	        <div class="table-responsive">
	          <table class="table table-striped table-bordered table-hover">
				<tr>
					<th>KODE RIM</th>
					<th>NO LABEL</th>
					<th>KODE BAHAN</th>
					<th>NOMOR SOP</th>
					<th>NOMOR ORDER</th>
					<th>JATUH TEMPO</th>
				</tr>
				<c:if test="${!empty printLabel}">
				<c:forEach items="${printLabel}" var="palette">
					<tr>
						<td>${palette.kodeRim}</td>
						<td>${palette.noLabel}</td>
						<td>${palette.masterBahan.kodeBahan}</td>
						<td>${palette.nomorSop}</td>
						<td>${palette.nomorOrder}</td>
						<td>${palette.jatuhTempo}</td>
					</tr>
				</c:forEach>
				</c:if>
			</table>
			<%-- <tag:paginate max="1000" offset="${offset}" count="${count}"
	   		uri="palette" next="&raquo;" previous="&laquo;" />
			</div> --%>
		</div>
		</div>
		
	</form>
</body>
</html>