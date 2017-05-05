package com.qingke.easyjava.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class BaseDao {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
