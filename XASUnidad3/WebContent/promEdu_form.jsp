<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProgramaEducativo Form</title>
</head>
<body>
	<form action="PromEduController">
	
		<label>Numero de Alumnos:</label><br/>
		<input type="number" name="numeroalumnos" value="${programa.numeroalumnos}"/><br/>
		<label>Carrera:</label><br/>
		<input type="text" name="carrera" value="${programa.carrera}"/><br/>
		<label>Edificio:</label><br/>
		<input type="text" name="edificio" value="${programa.edificio}"/><br/>
		<input type="submit" name="btn_save" value="Save"/>
	</form>

</body>
</html>
