package com.epam.library.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.epam.library.bean.Book;
import com.epam.library.controller.Input;
import com.epam.library.dao.BookDao;
import com.epam.library.dao.impl.util.DBConnectionHelper;

public class BookDaoDBImpl implements BookDao {
	private static final String SQL_SELECT_BOOKS = "select *from books";

	public void create(Book book) {

		Connection connection = DBConnectionHelper.connect();

		try {
			Statement st = connection.createStatement();
		      st.executeUpdate("INSERT INTO books (title, author, genre, date_of_publishing) values ("  + "'" + book.getTitle() + "', " + "'" + book.getAuthor() + "', " + "'" + book.getGenre() + "', " + "'"+ book.getDateOfPublishing() +  "')" );

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> readByTitle(String title) {

		List<Book> listBooks = new ArrayList<>();

		Connection connection = DBConnectionHelper.connect();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select *from books where title = " + "'" + title + "'");

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setGenre(rs.getString("genre"));
				book.setDateOfPublishing(rs.getString("date_of_publishing"));
				book.setAuthor(rs.getString("author"));
				
				listBooks.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBConnectionHelper.disconnect(connection);
		return listBooks;
	}

	@Override
	public List<Book> readAll() {
		List<Book> listBooks = new ArrayList<>();

		Connection connection = DBConnectionHelper.connect();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_BOOKS);

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setGenre(rs.getString("genre"));
				book.setDateOfPublishing(rs.getString("date_of_publishing"));
				book.setAuthor(rs.getString("author"));

				listBooks.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnectionHelper.disconnect(connection);
		return listBooks;
	}

	@Override
	public void delete(int id) {
		Connection connection = DBConnectionHelper.connect();

		try {
			Statement st = connection.createStatement();
		      st.executeUpdate("DELETE FROM books WHERE id = " + "'" + id + "'");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Book book) {
		Connection connection = DBConnectionHelper.connect();

		try {
			Statement st = connection.createStatement();
		      st.executeUpdate("UPDATE books SET title = " + "'" + book.getTitle() + "', " +  "author = " + "'" + book.getAuthor() + "'," + "genre = " + "'" + book.getGenre() + "', " + "date_of_publishing = " + "'" + book.getDateOfPublishing() + "' " + "WHERE ID = " + book.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
