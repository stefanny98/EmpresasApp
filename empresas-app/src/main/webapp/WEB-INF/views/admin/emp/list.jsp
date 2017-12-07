<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Empresas</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-8">
				<h4 class="text-center">Empresa</h4>
				<hr>
				<a href="<%=request.getContextPath()%>/admin/emp/createform"
					class="btn btn-success"><i class="glyphicon glyphicon-edit"></i>
					Crear Empresa</a> <a href="<%=request.getContextPath()%>/admin/menu"
					class="btn btn-primary"><i class="glyphicon glyphicon-edit"></i>
					Menu</a> <br />
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Descripcion</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
			
						<c:forEach var="emp" items="${empresas}" >
							<tr>
								<td>${emp.id}</td>
								<td>${emp.nombre}</td>
								<td>${emp.descripcion}</td>
								<td><a
									href="<%=request.getContextPath()%>/admin/emp/editform/${emp.id}"
									class="btn btn-info btn-xs"> <i
										class="glyphicon glyphicon-check"></i>Edit
								</a></td>
								<td><a
									href="<%=request.getContextPath()%>/admin/emp/deleteform/${emp.id}"
									class="btn btn-danger btn-xs"> <i
										class="glyphicon glyphicon-trash"></i> Delete
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<font color="red">${message}</font>
		</div>
	</div>
</body>
</html>