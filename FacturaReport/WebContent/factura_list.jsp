<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Facturas Amazon list</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
			<form action="FacturaController">
				<input type="submit" name="btn_new" value="New"/>
			</form>
			<a href="ReportFactura">Imprimir Lista</a>
			</th>
			<th>Id</th>
			<th>Proveedor</th>
			<th>Fecha</th>
			<th>Importe</th>
			<th>Empleado</th>
			
		</tr>
		<c:forEach var="factura" items="${facturas}">
			<tr>
				<td>
					<form action="FacturaController">
						<input type="hidden" name="id" value="${factura.id}"/>
						<input type="submit" name="btn_edit" value="Edit"/>
						<input type="submit" name="btn_delete" value="Delete"/>
					</form>
				</td>
			
			<td>${factura.id}</td>
			<td>${factura.proveedor}</td>
			<td>${factura.fecha}</td>
			<td>${factura.importe}</td>
			<td>${factura.empleado}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>