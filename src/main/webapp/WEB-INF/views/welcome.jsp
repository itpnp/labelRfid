<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page isELIgnored="false" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Test Spring</title>
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/bootstrap/css/dataTables.bootstrap.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/bootstrap/js/jquery-1.10.2.js" />"></script>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
</head>
<body>
	<form role="form">
	<div class="panel-body">
   		<div class="form-group has-success">
          <label class="control-label" for="inputSuccess">Input with success</label>
          <input type="text" class="form-control" id="inputSuccess">
         </div>
          <div class="form-group has-warning">
              <label class="control-label" for="inputWarning">Input with warning</label>
              <input type="text" class="form-control" id="inputWarning">
          </div>
              <div class="form-group has-error">
              <label class="control-label" for="inputError">Input with error</label>
              <input type="text" class="form-control" id="inputError">
          </div>
        </div>
		<div class="panel-body">
        	<div class="table-responsive">
	          <table class="table table-striped table-bordered table-hover">
				<tr>
					<th>CODE BAHAN</th>
					<th>NAMA BAHAN</th>
					<th>JENIS</th>
					<th>LEBAR</th>
					<th>GSM</th>
					<th>SERI</th>
					<th>PANJANG</th>
					<th>AKTIF</th>
					<th>DESAIN</th>
					<th>WASTE PROSES KK</th>
				</tr>
					<c:if test="${!empty master}">
						<c:forEach items="${master}" var="bahan">
							<tr bgcolor="#E1E1E1">
								<td>${bahan.kodeBahan}</td>
								<td>${bahan.namaBahan}</td>
								<td>${bahan.jenis}</td>
								<td>${bahan.lebar}</td>
								<td>${bahan.gsm}</td>
								<td>${bahan.seri}</td>
								<td>${bahan.panjang}</td>
								<td>${bahan.aktif}</td>
								<td>${bahan.desain}</td>
								<td>${bahan.wasteProsesKK}</td>
							</tr>
						</c:forEach>
					</c:if>
			</table>
		</div>
	</div>
</form>
</body>
</html>