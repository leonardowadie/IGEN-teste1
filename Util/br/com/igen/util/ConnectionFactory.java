package br.com.igen.util;

import java.sql.*;

public class ConnectionFactory {

	private static ConnectionFactory connectionFactory;
	private final String URL = "jdbc:mysql://localhost/teste1";
	private final String USER = "root";
	private final String PASS = "ms4-290889";

	private ConnectionFactory() {

	}

	public static ConnectionFactory getInstance() {

		if (connectionFactory == null) {

			connectionFactory = new ConnectionFactory();
		}

		return connectionFactory;
	}

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);

		}

		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


}
