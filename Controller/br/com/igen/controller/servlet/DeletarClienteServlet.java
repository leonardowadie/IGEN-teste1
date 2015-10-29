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


@WebServlet("/deletarCliente")
public class DeletarClienteServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteVO cliente = new ClienteVO();
		cliente.setId( Long.parseLong(request.getParameter("id") ) );
		
		
		ClienteBO bo = new ClienteBO();
		bo.deletarCliente(cliente);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
