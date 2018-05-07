package com.epam.library.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.library.bean.Book;
import com.epam.library.bean.Entity;
import com.epam.library.bean.Report;
import com.epam.library.dao.impl.util.DBConnectionHelper;
import com.epam.library.service.LibraryService;

import net.bytebuddy.asm.Advice.Return;

public class LibraryServiceImpl implements LibraryService {
	private static final String SQL_SELECT_MORE_THAN_TWO_BOOKS = "SELECT employees.name, COUNT(employee_book.id_book) AS SumBooks "	+ "FROM employee_book " + "INNER JOIN books "
																+ "ON employee_book.id_book = books.id INNER JOIN employees ON employee_book.id_employee = employees.id "
																+ "GROUP BY employees.id " + "HAVING SumBooks>2 order by SumBooks asc";
	
	private static final String SQL_SELECT_LASS_THAN_FIVE_BOOKS = "SELECT employees.name, employees.date_of_birth, COUNT(books.id) AS SumBooks " + "FROM employee_book " + "INNER JOIN books "
																+ "ON employee_book.id_book = books.id INNER JOIN employees ON employee_book.id_employee = employees.id "
																+ "GROUP BY employees.id " + "HAVING SumBooks<=5 order by employees.date_of_birth asc";

	@Override
	public List<Report> getReportMoreThanTwoBooks() {
		List<Report> listReport = new ArrayList<>();

		Connection connection = DBConnectionHelper.connect();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_MORE_THAN_TWO_BOOKS);

			while (rs.next()) {
				String name = rs.getString("name");
				int sumBooks = rs.getInt("SumBooks");
				Report report = new Report(name, sumBooks);
				listReport.add(report);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnectionHelper.disconnect(connection);
		return listReport;
	}

	@Override
	public List<Report> getReportLassThanFiveBooks() {
		List<Report> listReport = new ArrayList<>();

		Connection connection = DBConnectionHelper.connect();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_LASS_THAN_FIVE_BOOKS);

			while (rs.next()) {
				String name = rs.getString("name");
				String date = rs.getString("date_of_birth");
				int sumBooks = rs.getInt("SumBooks");
				Report report = new Report(name, sumBooks, date);
				listReport.add(report);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnectionHelper.disconnect(connection);
		return listReport;
	}
}
