package br.com.igen.controller.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.igen.model.bo.ClienteBO;
import br.com.igen.model.vo.ClienteVO;


@WebServlet("/adicionarCliente")
public class AdicionarClienteServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteVO cliente = new ClienteVO();
		
		cliente.setNome( request.getParameter("nome") );
		cliente.setEmail( request.getParameter("email") );
		cliente.setCpf( request.getParameter("cpf") );
		
		ClienteBO bo = new ClienteBO();
		bo.inserirCliente(cliente);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
