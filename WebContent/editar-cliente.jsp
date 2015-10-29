<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">



<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<%
		String idCliente = request.getParameter("id");
		%>
		
		<h3>Editar <small>cliente</small></h3>
		<hr>
		<form action="editarCliente?id=<%=idCliente %>" method="post">
			<div class="form-group">
				<label for="nomeinput" > Id: </label>
				<input type="text" class="form-control" disabled="disabled" id="idinput" name="Id" value="<%=idCliente %>" />		
			</div>			
			<div class="form-group">
				<label for="nomeinput" > Nome: </label>
				<input type="text" class="form-control" id="nomeinput" placeholder="Nome" name="nome" />		
			</div>
			<div class="form-group">
				<label for="cpfinput" > CPF: </label>
				<input type="text" class="form-control" id="cpfinput" placeholder="CPF" name="cpf" />		
			</div>
			<div class="form-group">
				<label for="emailinput" > Email: </label>
				<input type="email" class="form-control" id="emailinput" placeholder="Email" name="email"/>		
			</div>
			<button type="submit" class="btn btn-success btn-xs"> Alterar </button>		
			<a href='index.jsp' class='btn btn-warning btn-xs' />Voltar</a>
		</form>
		
		

	
	</div> <!-- /container -->
	

	

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>