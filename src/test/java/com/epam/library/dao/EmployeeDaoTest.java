package com.epam.library.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.library.bean.Employee;
import com.epam.library.dao.EmployeeDao;
import com.epam.library.dao.impl.EmployeeDaoDBImpl;
import com.epam.library.dao.impl.util.DBConnectionHelper;


public class EmployeeDaoTest {
	
	private Connection connection;
	private List<Employee> expectedListEmployees;
	private List<Employee> expectedListEmployeesByName;
	private EmployeeDao employeeDao;
	private static final String TEST_NAME = "Михаил";

	@BeforeClass
	public void initDefaultDBConnection() {
		
		connection = DBConnectionHelper.connect();
		System.out.println("Before class: connection opened");
	}
	
	@BeforeMethod
	public void initDao() {
		
		employeeDao = new EmployeeDaoDBImpl();
	}
	
	@BeforeMethod
	public void getExpectedList() throws SQLException {

		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select *from employees");
		expectedListEmployees = new ArrayList<>();

		while (rs.next()) {
			expectedListEmployees.add(new Employee());
		}
		System.out.println("BeforeMethod: expectedList was recieved");
	}
	
	@BeforeMethod
	public void getExpectedEmployeeName() throws SQLException {
		expectedListEmployeesByName = new ArrayList<>();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select *from employees where name = " + "'" + TEST_NAME + "'");
		
		while (rs.next()) {
			Employee employee = new Employee();
			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employee.setEmail(rs.getString("email"));
			employee.setDateOfBirth(rs.getString("date_of_birth"));
			expectedListEmployeesByName.add(employee);
		}
	}

	@Test
	public void testRecievedCorrectEmployeeCount() {
		
		List<Employee> actualEmployees = employeeDao.readAll();
		Assert.assertEquals(actualEmployees.size(), expectedListEmployees.size(), "The received count of employees is not correct");
	}
	
	@Test
	public void testRecievedCorrectEmployeesByName() {
		
		List<Employee> actualEmployeesByName = employeeDao.readByName(TEST_NAME);
		Assert.assertEquals(actualEmployeesByName, expectedListEmployeesByName);
	}
	
	@AfterMethod
	public void cleanExpectedValues() {
		expectedListEmployees = null;
		System.out.println("After method");
	}
	
	@AfterClass
	public void closeDBConnection() {
		
		DBConnectionHelper.disconnect(connection);
		System.out.println("AfterClass: connection closed");
	}
	
}
