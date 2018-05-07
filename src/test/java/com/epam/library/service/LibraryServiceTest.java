package com.epam.library.service;
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

import com.epam.library.bean.Book;
import com.epam.library.bean.Report;
import com.epam.library.dao.impl.BookDaoDBImpl;
import com.epam.library.dao.impl.util.DBConnectionHelper;
import com.epam.library.service.LibraryService;
import com.epam.library.service.impl.LibraryServiceImpl;

public class LibraryServiceTest {

	private static final String TEST_TITLE = "Юность";
	private static final String SQL_SELECT_MORE_THAN_TWO_BOOKS = "SELECT employees.name, COUNT(employee_book.id_book) AS SumBooks "	+ "FROM employee_book " + "INNER JOIN books "
			+ "ON employee_book.id_book = books.id INNER JOIN employees ON employee_book.id_employee = employees.id "
			+ "GROUP BY employees.id " + "HAVING SumBooks>2 order by SumBooks asc";

	private static final String SQL_SELECT_LASS_THAN_FIVE_BOOKS = "SELECT employees.name, employees.date_of_birth, COUNT(books.id) AS SumBooks " + "FROM employee_book " + "INNER JOIN books "
			+ "ON employee_book.id_book = books.id INNER JOIN employees ON employee_book.id_employee = employees.id "
			+ "GROUP BY employees.id " + "HAVING SumBooks<=5 order by employees.date_of_birth asc";

	private Connection connection;
	private List<Report> expectedFirstReport;
	private List<Report> expectedSecondReport;
	private Statement st;
	private LibraryService service;

	@BeforeClass
	public void initDefaultDBConnection() {
		
		connection = DBConnectionHelper.connect();
		System.out.println("Before class: connection opened");
	}

	@BeforeMethod
	public void getExpectedFirstReport() throws SQLException {

		st = connection.createStatement();
		ResultSet rs = st.executeQuery(SQL_SELECT_MORE_THAN_TWO_BOOKS);
		expectedFirstReport = new ArrayList<>();

		while (rs.next()) {
			expectedFirstReport.add(new Report());
		}
		
		System.out.println("BeforeMethod: actualList was recieved");
	}
	
	@BeforeMethod
	public void getExpectedSecondReport() throws SQLException {

		st = connection.createStatement();
		ResultSet rs = st.executeQuery(SQL_SELECT_LASS_THAN_FIVE_BOOKS);
		expectedSecondReport = new ArrayList<>();

		while (rs.next()) {
			expectedSecondReport.add(new Report());
		}
		
		System.out.println("BeforeMethod: actualList was recieved");
	}

	@BeforeMethod
	public void initDao() {
		service = new LibraryServiceImpl();
	}
	
	@Test
	public void testCorrectReportMoreThanTwoBooks() {
		List<Report> actualReport = service.getReportMoreThanTwoBooks();
		Assert.assertEquals(actualReport.size(), expectedFirstReport.size(), "The received count of books is not correct");
	}
	
	@Test
	public void testCorrectReportLassThanFiveBooks() {
		List<Report> actualReport = service.getReportLassThanFiveBooks();
		Assert.assertEquals(actualReport.size(), expectedSecondReport.size(), "The received count of books is not correct");
	}
	
	@AfterMethod
	public void cleanExpectedValues() {
		
		expectedFirstReport = null;
		expectedSecondReport = null;
		System.out.println("After method");
	}
	
	@AfterClass
	public void closeDBConnection() {
		
		DBConnectionHelper.disconnect(connection);
		System.out.println("AfterClass: connection closed");
	}
}
