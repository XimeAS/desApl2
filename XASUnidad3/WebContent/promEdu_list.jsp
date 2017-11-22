<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProgrmaEducativo list</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
			<form action="PromEduController">
				<input type="submit" name="btn_new" value="New"/>
			</form>
			<a href="PromEduReport">Imprimir Lista</a>
			</th>
			<th>Id</th>
			<th>numeroalumnos</th>
			<th>carrera</th>
			<th>Edificio</th>
			
		</tr>
		<c:forEach var="programa" items="${programas}">
			<tr>
				<td>
					<form action="PromEduController">
						<input type="hidden" name="id" value="${programa.id}"/>
						<input type="submit" name="btn_edit" value="Edit"/>
						<input type="submit" name="btn_delete" value="Delete"/>
					</form>
				</td>
			
			<td>${programa.id}</td>
			<td>${programa.numeroalumnos}</td>
			<td>${programa.carrera}</td>
			<td>${programa.edificio}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>