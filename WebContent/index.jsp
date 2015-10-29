<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List" %>
<%@ page import="br.com.igen.model.vo.ClienteVO" %>
<%@ page import="br.com.igen.model.bo.ClienteBO" %>

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
		<h3>Clientes</h3>
		 
			<form class="form-inline" action="exibir-cliente.jsp?nome=pesquisar">
				<div class="form-group">
					<label for="pesquisar">Pesquisar por nome:</label>
					<input type="text" class="form-control input-sm" id="pesquisar" placeholder="Nome" name="pesquisar">
				</div>
				<button type="submit" class="btn btn-primary btn-xs">Pesquisar</button>
			</form>
			<hr>
			
		<table class="table table-condensed">
			<tr class="active">
				<th>ID</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Email</th>
				<th>Editar</th>
				<th>Excluir</th>			
			</tr>
			<%
								
				List < ClienteVO > listaDeClientes = new ClienteBO().buscarTodosCliente();
				
				for ( ClienteVO cliente : listaDeClientes ) {
					
					out.print("<tr>");
					out.print("<td>"+cliente.getId()+"</td>");
					out.print("<td>"+cliente.getNome()+"</td>");
					out.print("<td>"+cliente.getCpf()+"</td>");
					out.print("<td>"+cliente.getEmail()+"</td>");
					out.print("<td> <a href='editar-cliente.jsp?id="+cliente.getId()+"' class='btn btn-warning btn-xs' />Editar</a></td>");
					//out.print("<td> <a href='deletarCliente?id="+cliente.getId()+"' class='btn btn-danger btn-xs' />Excluir</a></td>");
			%>
			<td> <a href=deletarCliente?id=<%=cliente.getId()%> class="btn btn-danger btn-xs" onclick = "return confirm('Você tem certeza que deseja excluir esse registro?')"/>Excluir</a></td>
			<% 
					out.print("</tr>");
					
				}
				
			
			%>
		
		
		
		</table> <!-- /table -->	
		<%
		out.print("<a href='adicionar-cliente.jsp' class='btn btn-success btn-xs' />Novo cliente</a>");
		%>
		
	</div> <!-- /container -->

	

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>