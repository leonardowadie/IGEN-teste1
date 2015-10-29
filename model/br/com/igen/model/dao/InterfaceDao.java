package br.com.igen.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao <T> {
	
	void insert( T t ) throws SQLException;
	
	void update( T t ) throws SQLException;
	
	void delete( T t ) throws SQLException;
	
	List< T > selectAll () throws SQLException;

}
