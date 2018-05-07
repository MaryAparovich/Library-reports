package com.epam.library.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.library.bean.Employee;
import com.epam.library.dao.impl.util.DBConnectionHelper;

public class ConnectionTest {
	private Connection connection;
	private static final String DB_CONNECT_FAKE_PROPERTY = "db_config_test";

	@BeforeClass
	public void initDefaultDBConnection() {
		
		connection = DBConnectionHelper.connect();
		System.out.println("Before class: connection opened");
	}
	
	@Test(expectedExceptions = SQLException.class)
	public void testCorrectConnect() throws ClassNotFoundException, SQLException{
		DBConnectionHelper.connect(DB_CONNECT_FAKE_PROPERTY);
	}
	
	@AfterClass
	public void closeDBConnection() {
		
		DBConnectionHelper.disconnect(connection);
		System.out.println("AfterClass: connection closed");
	}
}
