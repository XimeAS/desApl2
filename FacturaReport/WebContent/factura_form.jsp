<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Factura Form</title>
</head>
<body>
	<form action="FacturaController">
	
		<label>Proveedor:</label><br/>
		<input type="text" name="proveedor" value="${factura.proveedor}"/><br/>
		<label>Fecha:</label><br/>
		<input type="text" name="fecha" value="${factura.fecha}"/><br/>
		<label>Importe:</label><br/>
		<input type="number" name="importe" value="${factura.importe}"/><br/>
		<label>Empleado:</label><br/>
		<input type="text" name="empleado" value="${factura.empleado}"/><br/>
		<input type="submit" name="btn_save" value="Save"/>
	</form>

</body>
</html>
