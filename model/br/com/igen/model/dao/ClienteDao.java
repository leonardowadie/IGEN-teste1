package br.com.igen.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import br.com.igen.model.vo.ClienteVO;
import br.com.igen.util.ConnectionFactory;

public class ClienteDao implements InterfaceDao < ClienteVO > {

	@Override
	public void insert(ClienteVO t) {
		
		PreparedStatement pstm = null;
		Connection con = null;
		
		try {
			
			con = ConnectionFactory.getInstance().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO cliente (cpf, nome, email)");
			sql.append(" VALUES (?, ?, ?)");
			
			pstm = con.prepareStatement(sql.toString());
			pstm.setString(1, t.getCpf() );
			pstm.setString(2,  t.getNome() );
			pstm.setString(3, t.getEmail() );
			pstm.execute();
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				
				
			}
		}
		
	}

	@Override
	public void update(ClienteVO t) {
		PreparedStatement pstm = null;
		Connection con = null;
		
		try {
			
			con = ConnectionFactory.getInstance().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE cliente SET nome = ?, email = ?, cpf = ? ");
			sql.append(" WHERE id = ? ");
			
			pstm = con.prepareStatement(sql.toString());
			pstm.setString(1, t.getNome() );
			pstm.setString(2,  t.getEmail() );
			pstm.setString(3, t.getCpf() );
			pstm.setLong(4, t.getId() );
			pstm.executeUpdate();
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				
				
			}
		}
		
	}

	@Override
	public void delete(ClienteVO t) {
		PreparedStatement pstm = null;
		Connection con = null;
		
		try {
			
			con = ConnectionFactory.getInstance().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM cliente ");
			sql.append(" WHERE id = ? ");
			
			pstm = con.prepareStatement(sql.toString());
			pstm.setLong(1, t.getId() );
		
			pstm.execute();
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				
				
			}
		}
		
	}

	@Override
	public List<ClienteVO> selectAll() {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<ClienteVO> lista = new ArrayList<>();
		
		try {
			
			con = ConnectionFactory.getInstance().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM cliente ");
			
			pstm = con.prepareStatement(sql.toString());
			rs = pstm.executeQuery();
			
			while ( rs.next() ){
				lista.add( setClienteVO(rs) );
				
			}

			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			try {
				rs.close();
				pstm.close();
				con.close();
			} catch (SQLException e) {
				
				
			}
		}
		
		return lista;
	}

	public List< ClienteVO > select (String nome) {
		
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<ClienteVO> cli = new ArrayList<>();
		
		try {
			con = ConnectionFactory.getInstance().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM cliente WHERE nome LIKE ? ");
			
			pstm = con.prepareStatement(sql.toString());
			pstm.setString(1, "%"+nome+"%");
			rs = pstm.executeQuery();
			
			while ( rs.next() ){
				cli.add( setClienteVO(rs) );
				
			}
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			try {
				rs.close();
				pstm.close();
				con.close();
			} catch (SQLException e) {
				
				
			}
		}
		
		return cli;
		
	}
	
	private ClienteVO setClienteVO(ResultSet rs) throws SQLException {
		Long id = rs.getLong("id");
		String nome = rs.getString("nome");
		String email = rs.getString("email");
		String cpf = rs.getString("cpf");
		
		ClienteVO cli = new ClienteVO(nome, cpf, email);
		cli.setId(id);
		return cli;
	}
	
	
	
	

}
