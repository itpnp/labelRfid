<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page trimDirectiveWhitespaces="true" %>
<%@page isELIgnored="false" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Palette</title>
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/bootstrap/css/dataTables.bootstrap.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/bootstrap/js/jquery-1.10.2.js" />"></script>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
</head>
<body>
	<form name="form" action="/labelRfid/getData" method="post">
	<div class="panel-body">
		<div class="panel panel-default">
             <div class="panel-heading">
                  Kelompok Berurutan
             </div>
            <div class="panel-body">
	   		<div class="form-group">
	             <label>Start</label>
	             <input name="startNumber" class="form-control" type="text" placeholder="Start Label Number">
	             <label>End</label>
	             <input name="endNumber" class="form-control" type="text" placeholder="End Label Number">
	             <label>Kode Pengawas</label>
	             <input name="kodePengawas" class="form-control" type="text" placeholder="Kode Pengawas">
	        </div>
	        </div>
        </div>
        <div class="panel panel-default">
             <div class="panel-heading">
                  Satuan
             </div>
            <div class="panel-body">
	   		<div class="form-group">
	             <label>Satuan</label>
             	 <input name="satuan" class="form-control" type="text" placeholder="Satuan">
	        </div>
	        </div>
        </div>
        <button type="submit" class="btn btn-default">View Data</button>
     </div>
		</form>
		</body>
</html>