package br.com.igen.model.bo;

import java.util.List;

import br.com.igen.model.dao.ClienteDao;
import br.com.igen.model.vo.ClienteVO;

public class ClienteBO {
	
	public void inserirCliente ( ClienteVO cliente ) {
		
		if( cliente == null ) {
			return;
			
		}
		
		ClienteDao dao = new ClienteDao();
		dao.insert(cliente);
		
	}
	
	public void atualizarCliente ( ClienteVO cliente ) {
		
		if( cliente == null ) {
			return;
			
		}
		
		ClienteDao dao = new ClienteDao();
		dao.update(cliente);
		
	}
	
	public void deletarCliente ( ClienteVO cliente ) {
		
		if( cliente == null ) {
			return;
			
		}
		
		ClienteDao dao = new ClienteDao();
		dao.delete(cliente);
		
	}
	
	public List<ClienteVO> buscarCliente ( String nome ) {
		
		if( nome == null ) {
			return null;
			
		}
		
		ClienteDao dao = new ClienteDao();
		return dao.select(nome);
	}
	
	public List< ClienteVO > buscarTodosCliente() {
		ClienteDao dao = new ClienteDao();
		
		return dao.selectAll();
	}

}
